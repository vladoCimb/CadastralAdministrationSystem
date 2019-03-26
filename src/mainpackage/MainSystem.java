/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import AVL.AVLTree;
import AVL.BSTIterator;
import generateNames.Digit16IDGenerator;
import generateNames.NameGenerator;
import generateNames.RandomStringGenerator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author Vladko
 */
public class MainSystem<T extends Comparable<T>> {

    private AVLTree<Person> citiziens;
    private AVLTree<Property> properties;
    private AVLTree<PropertyList> propertyLists;
    private AVLTree<CadastralArea> cadastralAreas;

    public MainSystem() {
        citiziens = new AVLTree<Person>();
        properties = new AVLTree<Property>();
        propertyLists = new AVLTree<PropertyList>();
        cadastralAreas = new AVLTree<CadastralArea>();

    }

    public void addCitizien(String firstName, String surName, Long identifNumb, Property permResidance) {
        Person p = new Person(firstName, surName, identifNumb, permResidance);
        citiziens.insert(p);
    }

    public void addCitizienWithoutPermProperty(String firstName, String surName, int identifNumb) {
        Person p = new Person(firstName, surName, identifNumb);
        citiziens.insert(p);
    }

    public void addCitizien(Person person) {
        citiziens.insert(person);
    }

    public void addProperty(int regNumber, String adress, String description) {
        Property p = new Property(regNumber, adress, description);
        properties.insert(p);
    }

    public void addProperty(Property property) {
        properties.insert(property);
    }

    public void addPropertyList(CadastralArea cadastralArea, int numbProperList) {
        PropertyList pl = new PropertyList(cadastralArea, numbProperList);
        propertyLists.insert(pl);
    }

    public void addPropertyList(PropertyList propertyList) {
        propertyLists.insert(propertyList);
    }

    public void addCadArea(int numbCadArea, String titleCadAea) {
        CadastralArea ca = new CadastralArea(this, numbCadArea, titleCadAea);
        cadastralAreas.insert(ca);
    }

    public void addCadastralArea(CadastralArea ca) {
        cadastralAreas.insert(ca);
    }

    public AVLTree<Person> getCitiziens() {
        return citiziens;
    }

    public AVLTree<Property> getProperties() {
        return properties;
    }

    public AVLTree<PropertyList> getPropertyLists() {
        return propertyLists;
    }

    public AVLTree<CadastralArea> getCadastralAreaLists() {
        return cadastralAreas;
    }

    public AVLTree<CadastralArea> getCadastralAreas() {
        return cadastralAreas;
    }

    public Property findPropertyByRegNumb(int regNumb) {
        if (getProperties().findNode(new Property(regNumb, "", "")) != null) {
            return getProperties().findNode(new Property(regNumb, "", "")).getData();
        } else {
            return null;
        }

    }

    public CadastralArea findCadAreaByNumber(int number) {
        if (getCadastralAreas().findNode(new CadastralArea(null, number, "")) != null) {
            return getCadastralAreas().findNode(new CadastralArea(null, number, "")).getData();
        } else {
            return null;
        }
    }

    public Person findPersonByID(Long id) {
        if (getCitiziens().findNode(new Person("", "", id, null)) != null) {
            return getCitiziens().findNode(new Person("", "", id, null)).getData();
        } else {
            return null;
        }

    }

    public CadastralArea findCadArea(int numberOfArea) {
        if (getCadastralAreaLists().findNode(new CadastralArea(null, numberOfArea, "")) != null) {
            return getCadastralAreaLists().findNode(new CadastralArea(null, numberOfArea, "")).getData();
        } else {
            return null;
        }
    }

    public PropertyList findPropertyListByNumber(int numbProperList) {
        if (getPropertyLists().findNode(new PropertyList(null, numbProperList)) != null) {
            return getPropertyLists().findNode(new PropertyList(null, numbProperList)).getData();
        } else {
            return null;
        }
    }

    public Property findProperty(Property p) {
        if (getProperties().findNode(p) != null) {
            return getProperties().findNode(p).getData();
        } else {
            return null;
        }
    }

    public void nacitajData() {
        readPropertiesFromFile();
        readPersonsFromFile();
        readCadastralAreasFromFile();
        readPropertyListsFromFile();
        readPropertyListContentFromFile();

    }

    public void generateData() {
        NameGenerator nm = new NameGenerator();
        Digit16IDGenerator gn = new Digit16IDGenerator();
        RandomStringGenerator gr = new RandomStringGenerator();

        for (int i = 0; i < 1000; i++) {
            System.out.println(gn.createRandomInteger());
            addCitizien(nm.generateName(), nm.generateName(), gn.createRandomInteger(), null);
            addProperty(i, gr.generateString(), gr.generateString());
            addCadArea(i, gr.generateString());
            addPropertyList(null, i);
        }

    }

    public void readPersonsFromFile() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\Vladko\\Documents\\NetBeansProjects\\UdajovkySem\\obcania.csv"));
        } catch (Exception e) {
        }

        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("/");
                line = br.readLine();
            }
            String everything = sb.toString();
            String[] lines = everything.split("/");
            for (int i = 0; i < lines.length; i++) {
                String[] values = lines[i].split(";");
                if (values.length == 4) {
                    citiziens.insert(new Person(values[0], values[1], Integer.parseInt(values[2]), findPropertyByRegNumb(Integer.parseInt(values[3]))));
                    findPropertyByRegNumb(Integer.parseInt(values[3])).addResident(findPersonByID(Long.parseLong(values[2])));
                } else {
                    citiziens.insert(new Person(values[0], values[1], Integer.parseInt(values[2])));
                }
            }

            System.out.print(everything);
        } catch (Exception e) {
        }
    }

    public void readPropertiesFromFile() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\Vladko\\Documents\\NetBeansProjects\\UdajovkySem\\nehnutelnosti.csv"));
        } catch (Exception e) {
        }
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(";");
                line = br.readLine();
            }
            String everything = sb.toString();
            String[] tokens = everything.split(";");

            for (int i = 0; i < tokens.length; i += 3) {
                properties.insert(new Property(Integer.parseInt(tokens[i]), tokens[i + 1], tokens[i + 2]));
            }

            System.out.print(everything);
        } catch (Exception e) {
        }
    }

    public void readPropertyListContentFromFile() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\Vladko\\Documents\\NetBeansProjects\\UdajovkySem\\obsahListuVlastnictva.csv"));
        } catch (Exception e) {
        }
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(";");
                line = br.readLine();
            }
            String everything = sb.toString();
            String[] tokens = everything.split(";");
            for (int i = 0; i < tokens.length; i += 3) {
                String[] properties = tokens[i + 1].split(",");
                String[] owners = tokens[i + 2].split(",");
                for (int o = 0; o < properties.length; o++) {
                    addPropertyOnPropertyList(Integer.parseInt(tokens[i]), Integer.parseInt(properties[o]), findPropertyListByNumber(Integer.parseInt(tokens[i])).getCadastralArea().getNumbCadArea());
                    //findPropertyListByNumber(Integer.parseInt(tokens[i])).addPropertyOnList(findPropertyByRegNumb(Integer.parseInt(properties[o])));
                }
                for (int j = 0; j < owners.length; j++) {
                    String[] ownersParts = owners[j].split("-");
                    addOwnerToPropertyList(Integer.parseInt(tokens[i]), Long.parseLong(ownersParts[0]),Double.parseDouble(ownersParts[1]));
                    //  findPropertyListByNumber(Integer.parseInt(tokens[i])).getOwnership().addPerson(findPersonByID(Long.parseLong(owners[j])));
                }

            }
        } catch (Exception e) {
        }
    }

    public void readPropertyListsFromFile() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\Vladko\\Documents\\NetBeansProjects\\UdajovkySem\\listy.csv"));
        } catch (Exception e) {
        }
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(";");
                line = br.readLine();
            }
            String everything = sb.toString();
            String[] tokens = everything.split(";");

            for (int i = 0; i < tokens.length; i += 2) {
                if(tokens[i+1].isEmpty()){
                     propertyLists.insert(new PropertyList(null, Integer.parseInt(tokens[i])));
                } else {
                propertyLists.insert(new PropertyList(findCadAreaByNumber(Integer.parseInt(tokens[i + 1])), Integer.parseInt(tokens[i])));
                findCadAreaByNumber(Integer.parseInt(tokens[i + 1])).addPropertyList(findPropertyListByNumber(Integer.parseInt(tokens[i])));
                }
            }

            System.out.print(everything);
        } catch (Exception e) {
        }
    }

    public void readCadastralAreasFromFile() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\Vladko\\Documents\\NetBeansProjects\\UdajovkySem\\katastralneuzemia.csv"));
        } catch (Exception e) {
        }
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(";");
                line = br.readLine();
            }
            String everything = sb.toString();
            String[] tokens = everything.split(";");

            for (int i = 0; i < tokens.length; i += 2) {
                cadastralAreas.insert(new CadastralArea(this, Integer.parseInt(tokens[i]), tokens[i + 1]));
            }

            System.out.print(everything);
        } catch (Exception e) {
        }
    }

    public void addOwnerToPropertyList(int propertyList, long personID) {
        findPropertyListByNumber(propertyList).getOwnership().addPerson(findPersonByID(personID));
        findPersonByID(personID).addPropertyList(findPropertyListByNumber(propertyList));
    }
    
    public void addOwnerToPropertyList(int propertyList, long personID,double part) {
        findPropertyListByNumber(propertyList).getOwnership().addPerson(findPersonByID(personID),part);
        findPersonByID(personID).addPropertyList(findPropertyListByNumber(propertyList));
    }

    public void addPropertyOnPropertyList(int propertyList, int propertyNumb, int numbOfCadArea) {
        findPropertyByRegNumb(propertyNumb).setList(findPropertyListByNumber(propertyList));
        //system.findCadAreaByNumber(numberCadAreaTF.getText()).addProperty(system.findPropertyByRegNumb(addPropertyTF.getText()));
        findPropertyByRegNumb(propertyNumb).setCadArea(findCadAreaByNumber(numbOfCadArea));
        findPropertyListByNumber(propertyList).addPropertyOnList(findPropertyByRegNumb(propertyNumb));
        findCadArea(numbOfCadArea).addProperty(findPropertyByRegNumb(propertyNumb));
    }

    public void exportData() {
        exportCitiziens();
        exportProperties();
        exportCadAreas();
        exportPropertyLists();
        exportContentOfPropertyLists();
    }
    
    public void exportCitiziens(){
        try{
        PrintWriter pn = new PrintWriter("obcaniaExport.csv");
        StringBuilder sb = new StringBuilder();
        BSTIterator it = new BSTIterator(citiziens.getRoot());
        
        
        Person p = new Person();

        while (it.hasNext()) {
            p = (Person) it.next();
            String permResidecne = "";
            if(p.getPermResidence() != null){
                permResidecne = Integer.toString(p.getPermResidence().getRegNumber());
            }
            String[] row = {p.getFirstName(),p.getSurnName(),Long.toString(p.getIdentifNumb()),permResidecne};
            for(int i = 0; i < row.length; i++){
                sb.append(row[i]);
                sb.append(';');
            }
            sb.append('\n');           
        }
        pn.write(sb.toString());
        pn.close();
            
        
        }catch(Exception e) {
            
        }
    }
    
    public void exportProperties(){
        try{
        PrintWriter pn = new PrintWriter("nehnutelnostiExport.csv");
        StringBuilder sb = new StringBuilder();
        BSTIterator it = new BSTIterator(properties.getRoot());
        
        Property p = new Property();

        while (it.hasNext()) {
            p = (Property) it.next();
            
            String[] row = {Integer.toString(p.getRegNumber()),p.getAdress(),p.getDescription()};
            for(int i = 0; i < row.length; i++){
                sb.append(row[i]);
                sb.append(';');
            }
            sb.append('\n');           
        }
        pn.write(sb.toString());
        pn.close();
            
        
        }catch(Exception e) {
            
        }
    }
    
    public void exportCadAreas(){
        try{
        PrintWriter pn = new PrintWriter("katastralneUzemiaExport.csv");
        StringBuilder sb = new StringBuilder();
        BSTIterator it = new BSTIterator(cadastralAreas.getRoot());
        
        CadastralArea p = new CadastralArea();

        while (it.hasNext()) {
            p = (CadastralArea) it.next();        
            String[] row = {Integer.toString(p.getNumbCadArea()),p.getTitleCadArea()};
            for(int i = 0; i < row.length; i++){
                sb.append(row[i]);
                sb.append(';');
            }
            sb.append('\n');           
        }
        pn.write(sb.toString());
        pn.close();
            
        
        }catch(Exception e) {
            
        }
    }
    
    public void exportPropertyLists(){
        try{
        PrintWriter pn = new PrintWriter("listyExport.csv");
        StringBuilder sb = new StringBuilder();
        BSTIterator it = new BSTIterator(propertyLists.getRoot());
        
        PropertyList p = new PropertyList();

        while (it.hasNext()) {
            p = (PropertyList) it.next(); 
            String numOfCadArea = "";
            if(p.getCadastralArea() != null){
                numOfCadArea = Integer.toString(p.getCadastralArea().getNumbCadArea());
            }
            String[] row = {Integer.toString(p.getNumbProperList()),numOfCadArea};
            for(int i = 0; i < row.length; i++){
                sb.append(row[i]);
                sb.append(';');
            }
            sb.append('\n');           
        }
        pn.write(sb.toString());
        pn.close();
            
        
        }catch(Exception e) {
            
        }
    }
    
    public void exportContentOfPropertyLists(){
        try{
        PrintWriter pn = new PrintWriter("obsahListovVlastnictvaExport.csv");
        StringBuilder sb = new StringBuilder();
        BSTIterator it = new BSTIterator(propertyLists.getRoot());
        
             
        PropertyList p = new PropertyList();
        Person owner = new Person();
        Property prop = new Property();

        while (it.hasNext()) {
            p = (PropertyList) it.next(); 
            String numOfCadArea = "";
            sb.append(Integer.toString(p.getNumbProperList()));
            sb.append(';');
            
            BSTIterator propertiesOnList = new BSTIterator(p.getPropertiesOnList().getRoot());
            while(propertiesOnList.hasNext()){
                prop = (Property) propertiesOnList.next();
                sb.append(prop.getRegNumber());
                if(propertiesOnList.hasNext()){
                sb.append(',');
                }
            }
            sb.append(';');
            
            
            
            BSTIterator owners = new BSTIterator(p.getOwnership().getPersons().getRoot());
            while(owners.hasNext()){
                owner = (Person) owners.next();
                sb.append(owner.getIdentifNumb());
                sb.append('-');
                sb.append(p.getOwnership().getPartOfOwner(Long.toString(owner.getIdentifNumb())));
                if(owners.hasNext()){
                sb.append(',');
                }
            }
            sb.append('\n');
        }
        pn.write(sb.toString());
        pn.close();
            
        
        }catch(Exception e) {
            
        }
    }
    
    
    
    
}
