package com.mycompany.foodmenu;

import java.util.*;
public class Foodmenu {
        Scanner scan = new Scanner(System.in);
        private String name = "";
        private double price = 0.0;
    
    public Foodmenu(String n, double p){
        this.name = n;
        this.price = p;
    }
    
    
    
    public void add(String n, double p){
        
        Foodmenu.this.name = n;
        Foodmenu.this.price = p;
            System.out.println("Added item : " + n + " to the menu for : " + p + " php.");
        }
    
    
    public void edit(String Nname, double Nprice){
        
       
    }
   
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        Foodmenu menu1 = new Foodmenu("",0.0);
        Foodmenu menu2 = new Foodmenu("",0.0);
        Foodmenu menu3 = new Foodmenu("",0.0);
        Foodmenu menu4 = new Foodmenu("",0.0);
        Foodmenu menu5 = new Foodmenu("",0.0);
        Foodmenu menu6 = new Foodmenu("",0.0);
        Foodmenu menu7 = new Foodmenu("",0.0);
        Foodmenu menu8 = new Foodmenu("",0.0);
        Foodmenu menu9 = new Foodmenu("",0.0);
        Foodmenu menu10 = new Foodmenu("",0.0);
        
        boolean running = true;
        
        
        while(running){
        System.out.println("~~~~~~~~~~~~~~~~~~~");
        System.out.println("Food menu: ");
        System.out.println("~~~~~~~~~~~~~~~~~~~");
        System.out.println("1. Insert");
        System.out.println("2. Edit");
        System.out.println("3. View");
        System.out.println("4. Exit");
        System.out.println("~~~~~~~~~~~~~~~~~~~");
        int Input = scan.nextInt();
        
        switch(Input){
            
            case 1 -> {
                System.out.println("~~~~~~~~~~~~~~~~~~~");
                System.out.println("Enter new menu item name:  ");
                String name1 = scan.next();
                System.out.println("Enter new menu item price: ");
                double price1 = scan.nextDouble();
            menu1.add(name1, price1);
                
                System.out.println("~~~~~~~~~~~~~~~~~~~");
                System.out.println("Enter new menu item name:  ");
                String name2 = scan.next();
                    if (!name2.equals(name1)){
                System.out.println("Enter new menu item price: ");
                double price2 = scan.nextDouble();
            menu2.add(name2, price2);}
                    else{System.out.println("Name already exists!");}
                
                System.out.println("~~~~~~~~~~~~~~~~~~~");
                System.out.println("Enter new menu item name:  ");
                String name3 = scan.next();
                    if (!name3.equals(name2)||!name3.equals(name1)){
                System.out.println("Enter new menu item price: ");
                double price3 = scan.nextDouble();
            menu3.add(name3, price3);}
                    else{System.out.println("Name already exists!");}
                
                System.out.println("~~~~~~~~~~~~~~~~~~~");
                System.out.println("Enter new menu item name:  ");
                String name4 = scan.next();
                System.out.println("Enter new menu item price: ");
                double price4 = scan.nextDouble();
            menu4.add(name4, price4);
            
                System.out.println("~~~~~~~~~~~~~~~~~~~");
                System.out.println("Enter new menu item name:  ");
                String name5 = scan.next();
                System.out.println("Enter new menu item price: ");
                double price5 = scan.nextDouble();
            menu5.add(name5, price5);
            
                System.out.println("~~~~~~~~~~~~~~~~~~~");
                System.out.println("Enter new menu item name:  ");
                String name6 = scan.next();
                System.out.println("Enter new menu item price: ");
                double price6 = scan.nextDouble();
            menu6.add(name6, price6);
            
                System.out.println("~~~~~~~~~~~~~~~~~~~");
                System.out.println("Enter new menu item name:  ");
                String name7 = scan.next();
                System.out.println("Enter new menu item price: ");
                double price7 = scan.nextDouble();
            menu7.add(name7, price7);
            
                System.out.println("~~~~~~~~~~~~~~~~~~~");
                System.out.println("Enter new menu item name:  ");
                String name8 = scan.next();
                System.out.println("Enter new menu item price: ");
                double price8 = scan.nextDouble();
            menu8.add(name8, price8);
            
                System.out.println("~~~~~~~~~~~~~~~~~~~");
                System.out.println("Enter new menu item name:  ");
                String name9 = scan.next();
                System.out.println("Enter new menu item price: ");
                double price9 = scan.nextDouble();
            menu9.add(name9, price9);
            
                System.out.println("~~~~~~~~~~~~~~~~~~~");
                System.out.println("Enter new menu item name:  ");
                String name10 = scan.next();
                System.out.println("Enter new menu item price: ");
                double price10 = scan.nextDouble();
            menu10.add(name10, price10);
                }
               
            case 2 -> {
                
                
                }
                
            case 3 -> {
                System.out.println("~~~~~~~~~~~~~~~~~~~");
                System.out.println("1.      " + menu1.name + " : " + menu1.price);
                System.out.println("2.      " + menu2.name + " : " + menu2.price);
                System.out.println("3.      " + menu3.name + " : " + menu3.price);
                System.out.println("4.      " + menu4.name + " : " + menu4.price);
                System.out.println("5.      " + menu5.name + " : " + menu5.price);
                System.out.println("6.      " + menu6.name + " : " + menu6.price);
                System.out.println("7.      " + menu7.name + " : " + menu7.price);
                System.out.println("8.      " + menu8.name + " : " + menu8.price);
                System.out.println("9.      " + menu9.name + " : " + menu9.price);
                System.out.println("10.      " + menu10.name + " : " + menu10.price);
                }
            
            case 4 -> {
                System.out.println("TERMINATING PROGRAM");
                running = false;
                break;
                }
            default -> System.out.println("Invalid Choice, Try Again");
        }
        }
    }
}
