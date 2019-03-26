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
public class PropertyList implements Comparable<PropertyList> {

    private CadastralArea cadastralArea;
    private int numbProperList;
    private AVLTree<Property> propertiesOnList;
    private Ownership ownership;

    public PropertyList(CadastralArea cadastralArea, int numbProperList) {
        this.cadastralArea = cadastralArea;
        this.numbProperList = numbProperList;
        propertiesOnList = new AVLTree<Property>();
        ownership = new Ownership();
    }

    public PropertyList(int numberPropertyList) {
        this.numbProperList = numberPropertyList;
        propertiesOnList = new AVLTree<Property>();
        this.cadastralArea = null;
        ownership = new Ownership();
    }

    public PropertyList() {
        propertiesOnList = new AVLTree<Property>();
        ownership = new Ownership();
    }

    public void setPropertiesOnList(AVLTree<Property> propertiesOnList) {
        this.propertiesOnList = propertiesOnList;
    }
    
    public CadastralArea getCadastralArea() {
        return cadastralArea;
    }

    public int getNumbProperList() {
        return numbProperList;
    }

    public void setCadastralArea(CadastralArea cadastralArea) {
        this.cadastralArea = cadastralArea;
    }

    public void setNumbProperList(int numbProperList) {
        this.numbProperList = numbProperList;
    }

    public AVLTree<Property> getPropertiesOnList() {
        return propertiesOnList;
    }
   

    public void addPropertyOnList(Property property) {
        if (cadastralArea != null) {
            propertiesOnList.insert(property);
        } else {
            JOptionPane.showMessageDialog(Globals.panel, "Pre pridanie nehnuteľnosti na list musí byť pridelené katastrálne územie.");
        }
    }

    public Ownership getOwnership() {
        return ownership;
    }
    
    public boolean deleteOwners(int ownerID){
        return ownership.deleteOwner(ownerID);
        
    }

    public Property getPropertyByRegNumb(int regNumb) {
        return propertiesOnList.findNode(new Property(regNumb, "", "")).getData();
    }

    @Override
    public int compareTo(PropertyList list) {
        if (this.numbProperList > list.numbProperList) {
            return 1;
        } else if (this.numbProperList < list.numbProperList) {
            return -1;
        } else {
            return 0;
        }
    }
    

}
