/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import AVL.AVLTree;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Vladko
 */
public class Ownership {

    private PropertyList propertyList;
    private AVLTree<Person> owners;
    private double freePart;
    private ArrayList<String> personParts;
    private int numberOfOwners;
    private MainSystem system;

    public Ownership(MainSystem system, PropertyList list) {
        this.propertyList = list;
        this.owners = new AVLTree<>();
        personParts = new ArrayList();
        freePart = 1;
        this.system = system;
    }

    public Ownership(MainSystem system) {
        this.system = system;
    }
    
    

    public Ownership() {
        this.owners = new AVLTree<>();
        personParts = new ArrayList();
        freePart = 1;
    }

    public void addPerson(Person person) {   
        if (owners.insert(person)) {
            numberOfOwners++;
            double part = recountParts();
            personParts.add(person.getIdentifNumb() + ";" + Double.toString(part));
            freePart -= part;
            recountOthers();
            // freePart -= part;      
        } else {
            JOptionPane.showMessageDialog(Globals.panel, "Daná osoba už má vlastnícky podiel na tomto liste vlastnictva");
        }
           
    }
    
    public void addPerson(Person person, Double part){
         if (owners.insert(person)) {
            numberOfOwners++;
            personParts.add(person.getIdentifNumb() + ";" + Double.toString(part));
            freePart -= part;
            //recountOthers();
                 
        } else {
            JOptionPane.showMessageDialog(Globals.panel, "Daná osoba už má vlastnícky podiel na tomto liste vlastnictva");
        }
    }
    
    public double recountParts() {
        double part = 1;

        part = part / numberOfOwners;
        return part;
    }

    public void setPersonParts(ArrayList<String> personParts) {
        this.personParts = personParts;
    }

    public void recountOthers() {
        if (numberOfOwners > 1) {
            for (int i = 0; i < owners.inOrderTraverseTreeArray(owners.getRoot(), null).size(); i++) {
                for (int j = 0; j < personParts.size(); j++) {
                    String[] parts = personParts.get(j).split(";");
                    long personID = ((Person) owners.inOrderTraverseTreeArray(owners.getRoot(), null).get(i)).getIdentifNumb();
                    if (personID == Integer.parseInt(parts[0])) {
                        personParts.set(j, personID + ";" + Double.toString(1.0 / numberOfOwners));
                    }
                }
            }
        }
    }

    public void changeParts(String ownerID, Double part) {
        for (int i = 0; i < owners.inOrderTraverseTreeArray(owners.getRoot(), null).size(); i++) {
            for (int j = 0; j < personParts.size(); j++) {
                String[] parts = personParts.get(j).split(";");
                if (ownerID.compareTo(parts[0]) == 0) {
                    personParts.set(j, ownerID + ";" + Double.toString(part));
                }
            }
        }
    }

    public PropertyList getPropertyList() {
        return propertyList;
    }

    public boolean deleteOwner(int ownerID) {
        owners.delete(new Person("", "", ownerID));
        int deleteIndex = -5;
        for (int j = 0; j < personParts.size(); j++) {
            String[] parts = personParts.get(j).split(";");          
            if (ownerID == Integer.parseInt(parts[0])) {
                deleteIndex = j;
            }
        }
        if(deleteIndex >= 0){
            personParts.remove(deleteIndex);  
            return true;
        }else{
            return false;
        }
    }

    public String getPartOfOwner(String ownerID) {
        String returnString = "0";
        for (int i = 0; i < personParts.size(); i++) {
            String[] parts = personParts.get(i).split(";");
            if (parts[0].compareTo(ownerID) == 0) {
                returnString = parts[1];
            }
        }
        return returnString;
    }

    public double getFreePart() {
        return 1 - freePart;
    }

    public boolean findPerson(int personID) {
        if (owners.findNode(new Person("", "", personID)) != null) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<String> getPersonParts() {
        return personParts;
    }

    public AVLTree<Person> getPersons() {
        return owners;
    }

    public void setProperty(PropertyList list) {
        this.propertyList = list;
    }

    public void setPersons(AVLTree<Person> persons) {
        this.owners = persons;
    }

}
