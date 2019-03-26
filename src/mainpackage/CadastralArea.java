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
public class CadastralArea implements Comparable<CadastralArea> {

    private int numbCadArea;
    private String titleCadArea;
    private ArrayList<Comparable <Property>> propertiesOnCadArea;
    private AVLTree<PropertyList> propertyListsOnArea;
    private MainSystem system;

    public CadastralArea(MainSystem system, int numbCadArea, String titleCadArea) {
        this.numbCadArea = numbCadArea;
        this.titleCadArea = titleCadArea;
        propertyListsOnArea = new AVLTree<PropertyList>();
        propertiesOnCadArea = new ArrayList();
        this.system = system;
    }

    public CadastralArea() {
    }

    public int getNumbCadArea() {
        return numbCadArea;
    }

    public String getTitleCadArea() {
        return titleCadArea;
    }

    public void setNumbCadArea(int numbCadArea) {
        this.numbCadArea = numbCadArea;
    }

    public void setTitleCadArea(String titleCadArea) {
        this.titleCadArea = titleCadArea;
    }

   

    public void addPropertyList(PropertyList list) {
        if (list != null) {
            propertyListsOnArea.insert(list); //TODO:: dat podmienku aj toto do BT
            ArrayList<Comparable <Property>> pom = new ArrayList();
            
           // list.getPropertiesOnList().inOrderTraverseTreeArray(propertyListsOnArea.getRoot(), pom);
            //for(int i = 0; i < pom.size();i++){       //toto pôjde do BT
             //   propertiesOnCadArea.add(pom.get(i));
           // }
            
        }
    }
    public void addProperty(Property property){
        if(property != null){
            propertiesOnCadArea.add(property);
        }
    }
    
    public void deleteProperty(Property property){
        int pomIndex = -5;
        for(int i = 0; i < propertiesOnCadArea.size();i++){
            if(propertiesOnCadArea.get(i).compareTo(property) == 0){
                pomIndex = i;
            }
        }
        if(pomIndex >=0 ){
        propertiesOnCadArea.remove(pomIndex);
        }
    }
    public void deletePropertyList(PropertyList list){
        propertyListsOnArea.delete(list);
    }

    public AVLTree<PropertyList> getPropertyListsOnArea() {
        return propertyListsOnArea;
    }


    public void setPropertyListsOnArea(AVLTree<PropertyList> propertyListsOnArea) {
        this.propertyListsOnArea = propertyListsOnArea;
    }

    public ArrayList<Comparable <Property>> getPropertiesOnCadArea() {
        return propertiesOnCadArea;
    }

    @Override
    public int compareTo(CadastralArea cadArea) {
        if (this.numbCadArea > cadArea.numbCadArea) {
            return 1;
        } else if (this.numbCadArea < cadArea.numbCadArea) {
            return -1;
        } else {
            return 0;
        }
    }

}
