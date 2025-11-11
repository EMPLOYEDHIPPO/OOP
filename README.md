
package itonayungtama;


import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Performance extends JFrame{
    
    private String name;
    private double price;
    private JLabel lb1;
    
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    public String getName(){
        return name;
    }
    
    public double getPrice(){
        return price;
    }
    
    
    
    public Performance(){
        FlowLayout fl = new FlowLayout();
        Font fon = new Font("Arial", Font.BOLD, 13);
        lb1 = new JLabel("Item: " + getName());
        lb1.setFont(fon);
        setSize(1280, 600);
        setLayout(fl);
        add(lb1);
        setTitle("Restaurant Item");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public void updateDisplay() {
        if (lb1 != null) {
            lb1.setText("Item: " + getName());
            lb1.revalidate(); 
            lb1.repaint();
        }    
    }

    
    public static void main(String[] args){
        Performance item = new Performance();
        item.setName("Burger");
        item.setPrice(20);
        item.updateDisplay();
        item.setVisible(true);
    }
}

