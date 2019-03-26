/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import AVL.AVLTree;

/**
 *
 * @author Vladko
 */
public class Property implements Comparable<Property> {
    private int regNumber;
    private String adress;
    private String description;
    private AVLTree listOfResidents;
    private CadastralArea cadArea;
    private PropertyList propertyList;
  

    public Property(int regNumber, String adress, String description) {
        this.regNumber = regNumber;
        this.adress = adress;
        this.description = description;
        listOfResidents = new AVLTree<Person>();
 
    }

    public Property() {
        
    }

    public int getRegNumber() {
        return regNumber;
    }

    public String getAdress() {
        return adress;
    }

    public String getDescription() {
        return description;
    }

    public void setRegNumber(int regNumber) {
        this.regNumber = regNumber;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void addResident(Person person){
        listOfResidents.insert(person);
    }

    public AVLTree getListOfResidents() {
        return listOfResidents;
    }

    

    public CadastralArea getCadArea() {
        return cadArea;
    }

    public void setPropertyList(PropertyList propertyList) {
        this.propertyList = propertyList;
    }
    
    

    public void setCadArea(CadastralArea cadArea) {
        this.cadArea = cadArea;
    }

    public PropertyList getPropertyList() {
        return propertyList;
    }

    public void setList(PropertyList list) {
        this.propertyList = list;
    }
    public void deleteResident(Person p){
        listOfResidents.delete(p);
    }


    @Override
    public int compareTo(Property property) {
        if (this.regNumber > property.regNumber) {
            return 1;
        } else if (this.regNumber < property.regNumber) {
            return -1;
        } else {
            return 0;
        }
    }
    
    
    
}
