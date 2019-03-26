/*
 * JTabbedPaneWithCloseIcons.java
 *
 * Created on Streda, 2006, jul 12, 10:52
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A JTabbedPane which has a close ('X') icon on each tab.
 *
 * To add a tab, use the method addTab(String, Component)
 *
 * To have an extra icon on each tab (e.g. like in JBuilder, showing the file type) use
 * the method addTab(String, Component, Icon). Only clicking the 'X' closes the tab.
 */
public class JTabbedPaneWithCloseIcons extends JTabbedPane implements MouseListener {

    
    private String[] list = new String[50];
    private int index = -1;
    
    public JTabbedPaneWithCloseIcons() {
        super();
        addMouseListener(this);
    }
    
    //Ulozenie aktivnej zalozky
    public void changeTab(String tab){
        try{
            if(index>=0){
               if(!list[index].equals(tab)){
                 index++;
                 list[index] = tab;
               }
            }
            else{
               index++;
               list[index] = tab;
            }
        }
        catch(Exception e){}
    }
   
    
    @Override
    public void removeAll(){
        super.removeAll();
        list = new String[50];
        index = -1;
    }
    
    @Override
    public void addTab(String title, Component component) {
        this.addTab(title, component, null);
       
    }

    
    //Vlozenie novej zalozky
    public void addTab(String title, Component component, Icon extraIcon) {
        int sufixTitle = 1;
        //V pripade existencie zalozky s rovnakym menom je doplnene za nazov poradove cislo
        if(this.indexOfTab(title)!= -1){
          while(this.indexOfTab(title + " ["+sufixTitle +"]" )!= -1)
              sufixTitle++;
          title=title + " ["+sufixTitle +"]";
        }
        super.addTab(title, new CloseTabIcon(extraIcon), component);
        changeTab(title);
    }

    public void addTabWithoutIcon(String title, Component component) {
        super.addTab(title, component);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String tabSelected = this.getTitleAt(this.getSelectedIndex());
        int tabNumber = getUI().tabForCoordinate(this, e.getX(), e.getY());
        if (tabNumber < 0) {
            return;
        }
        String tabName = this.getTitleAt(tabNumber);
        
        changeTab(tabSelected);
        Rectangle rect = ((CloseTabIcon) getIconAt(tabNumber)).getBounds();
        
        if (rect.contains(e.getX(), e.getY()) && tabName.equals(tabSelected)) {        
            this.remove(tabNumber);
            if(index == -1)
              return;
            list[index] = "";
            String[] list2 = new String[50];
            int index1 = 0;
            int index2 = 0;
            for(index1=0; index1<index;index1++){
                String value = list[index1];
                if(value.equals(tabName)){}
                else{
                    list2[index2] = list[index1];
                    index2++;
                } 
            }
            for(int i=0;i<list.length;i++){
                if(i<index2)
                  list[i] = list2[i];
                else
                  list[i] = "";
            }
            index=index2 - 1;
            if(index >= 0)
                this.setSelectedIndex(this.indexOfTab(list[index]));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        }
    }

/**
 * The class which generates the 'X' icon for the tabs. The constructor
 * accepts an icon which is extra to the 'X' icon, so you can have tabs
 * like in JBuilder. This value is null if no extra icon is required.
 */
class CloseTabIcon implements Icon {

    private int x_pos;
    private int y_pos;
    private int width;
    private int height;
    private Icon fileIcon;

    public CloseTabIcon(Icon fileIcon) {
        this.fileIcon = fileIcon;
        width = 16;
        height = 16;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        this.x_pos = x;
        this.y_pos = y;

        Color col = g.getColor();

        g.setColor(Color.black);
        int y_p = y + 2;
        g.drawLine(x + 1, y_p, x + 12, y_p);
        g.drawLine(x + 1, y_p + 13, x + 12, y_p + 13);
        g.drawLine(x, y_p + 1, x, y_p + 12);
        g.drawLine(x + 13, y_p + 1, x + 13, y_p + 12);
        g.drawLine(x + 3, y_p + 3, x + 10, y_p + 10);
        g.drawLine(x + 3, y_p + 4, x + 9, y_p + 10);
        g.drawLine(x + 4, y_p + 3, x + 10, y_p + 9);
        g.drawLine(x + 10, y_p + 3, x + 3, y_p + 10);
        g.drawLine(x + 10, y_p + 4, x + 4, y_p + 10);
        g.drawLine(x + 9, y_p + 3, x + 3, y_p + 9);
        g.setColor(col);
        if (fileIcon != null) {
            fileIcon.paintIcon(c, g, x + width, y_p);
        }
    }

    @Override
    public int getIconWidth() {
        return width + (fileIcon != null ? fileIcon.getIconWidth() : 0);
    }

    @Override
    public int getIconHeight() {
        return height;
    }

    public Rectangle getBounds() {
        return new Rectangle(x_pos, y_pos, width, height);
    }

    }
