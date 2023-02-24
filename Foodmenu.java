
package com.mycompany.foodmenu;

import java.util.*;
public class Foodmenu {

        public final Map <String, Double> items;
    
    public Foodmenu(){
        items = new HashMap<>();
        
    }
    
    public void add(String n, double p){
        
        if (items.containsKey(n)){
        System.out.println("Menu already exists!");
        }else{items.put(n, p);
        System.out.println("Added item : " + n + " to the menu for : " + p + " php.");
        }
    }
    
    public void edit(String n, double p){
        
        if (items.containsKey(n)){
            items.put(n, p);
        System.out.println("Changed price of : " + n + " to : " + n + " php.");
        }else{
            System.out.println( n + " is not on the menu");
        }  
    }
    
    public void display(){
        
        if(items.isEmpty()){
        System.out.println("No Food Entry Found!");
        }
        System.out.println("Menu: ");
        items.entrySet().forEach(entry -> {
            System.out.println(entry.getKey()+ " : " + entry.getValue()+ " php.");
            });
    }

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        Foodmenu menu = new Foodmenu();
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
                String NewName = scan.next();
                System.out.println("Enter new menu item price: ");
                double NewPrice = scan.nextDouble();
                menu.add(NewName, NewPrice);
                }
               
            case 2 -> {
                System.out.println("~~~~~~~~~~~~~~~~~~~");
                System.out.println("Enter new menu item name:  ");
                String Newname = scan.next();
                System.out.println("Enter new menu item price: ");
                double Newprice = scan.nextDouble();
                menu.edit(Newname, Newprice);
                }
                
            case 3 -> {
                System.out.println("~~~~~~~~~~~~~~~~~~~");
                menu.display();
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