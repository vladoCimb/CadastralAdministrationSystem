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
public class Person implements Comparable<Person> {

    private String firstName;
    private String surnName;
    private long identifNumb;
    private Property permResidence;
    private AVLTree<PropertyList> propertyLists;

    public Person(String firstName, String surnName, long identifNumb, Property permResidence) {
        this.firstName = firstName;
        this.surnName = surnName;
        this.identifNumb = identifNumb;
        this.permResidence = permResidence;
        propertyLists = new AVLTree<PropertyList>();
    }

    public Person(String firstName, String surnName, long identifNumb) {
        this.firstName = firstName;
        this.surnName = surnName;
        this.identifNumb = identifNumb;
        propertyLists = new AVLTree<PropertyList>();
    }

    public AVLTree<PropertyList> getPropertyLists() {
        return propertyLists;
    }
    public void addPropertyList(PropertyList list){
        propertyLists.insert(list);
    }
    
    public Person() {

    }

    public long getIdentifNumb() {
        return identifNumb;
    }

    public void setIdentifNumb(long identifNumb) {
        this.identifNumb = identifNumb;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurnName() {
        return surnName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurnName(String surnName) {
        this.surnName = surnName;
    }

    public Property getPermResidence() {
        return permResidence;
    }

    public void setPermResidence(Property permResidence) {
        this.permResidence = permResidence;
    }
    
    public void deletePropertyList(int listID){
        propertyLists.delete(new PropertyList(null,listID));
    }
    
    

    @Override
    public int compareTo(Person person) {
        if (this.identifNumb > person.identifNumb) {
            return 1;
        } else if (this.identifNumb < person.identifNumb) {
            return -1;
        } else {
            return 0;
        }
    }

}
