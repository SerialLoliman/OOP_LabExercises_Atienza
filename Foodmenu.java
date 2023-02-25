
package com.mycompany.foodmenu;

import java.util.*;
public class Foodmenu {
        private String FName = "";
        private double FPrice = 0.0;
        
    
        public Foodmenu(String n, int p){
            
            this.FName = n;
            this.FPrice = p;
            
        }
    
        
        
        public void add(){
            
            for(int i = 0; i <10; i++){
                if (this.FName.matches(FName)){
                    System.out.println("Food already exists!");
                }
                else{
                
                    
                
                }
            
            }
            
           
        
        }
        
        public void edit(){
            if(FName.equals(FName)){
                
            }
            
        }
        
        public void display(){
        
        
        
        }
        
        
    

    public void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
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
            
            case 1 : {
                System.out.println("~~~~~~~~~~~~~~~~~~~");
                System.out.println("Enter new menu item name:  ");
                String FName = scan.next();
                System.out.println("Enter new menu item price: ");
                double FPrice = scan.nextDouble();
                Foodmenu.add();
                
                
                }
               
            case 2 : {
                System.out.println("~~~~~~~~~~~~~~~~~~~");
                System.out.println("Enter new menu item name:  ");
                String FName = scan.next();
                System.out.println("Enter new menu item price: ");
                double FPrice = scan.nextDouble();
                Foodmenu.edit();
                }
                
            case 3 : {
                System.out.println("~~~~~~~~~~~~~~~~~~~");
                Foodmenu.display();
            }
            
            case 4 : {
                System.out.println("TERMINATING PROGRAM");
                running = false;
                break;
                }
            default :
                
                System.out.println("Invalid Choice, Try Again");
        }
        }
    }
}
