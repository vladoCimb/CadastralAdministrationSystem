/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;
import GUI.JTabbedPaneWithCloseIcons;
import javax.swing.JPanel;

/**
 *
 * @author Vladko
 */
public class Logika {
    
    public void addTabOnMainWindow(JTabbedPaneWithCloseIcons jTab, JPanel jPanel, String title){
        jTab.addTab(title, jPanel);
    }
    
    public void setLastTab() {

        int pocet_tabov = Globals.panel.getTabCount();
        Globals.panel.setSelectedIndex(pocet_tabov - 1);
        //Zabezpeci focus na vybraty tab a tym funcnost Ctrl-Tab
        Globals.panel.requestFocus();
        

    }
   
    
   
    
}
