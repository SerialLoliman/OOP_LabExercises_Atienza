package foodmenu;
import java.util.*;
public class Foodmenu {
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
        Foodmenu.this.name = Nname;
        Foodmenu.this.price = Nprice;
            System.out.println("Changed item : " + Nname + " to : " + Nprice + " php.");
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
        System.out.println("1. Fill The List");
        System.out.println("2. Edit");
        System.out.println("3. View");
        System.out.println("4. Exit");
        System.out.println("~~~~~~~~~~~~~~~~~~~");
        int Input = scan.nextInt();
        
        switch(Input){
            
            case 1: {
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
                    if (name4.equals(name3)||!name4.equals(name2)||!name4.equals(name1)){
                System.out.println("Enter new menu item price: ");
                double price4 = scan.nextDouble();
                menu4.add(name4, price4);}
                    else{System.out.println("Name already exists!");}
                
                System.out.println("~~~~~~~~~~~~~~~~~~~");
                System.out.println("Enter new menu item name:  ");
                String name5 = scan.next();
                    if (name5.equals(name4)||name5.equals(name3)||!name5.equals(name2)||!name5.equals(name1)){
                System.out.println("Enter new menu item price: ");
                double price5 = scan.nextDouble();
                menu5.add(name5, price5);}
                    else{System.out.println("Name already exists!");}
                
                System.out.println("~~~~~~~~~~~~~~~~~~~");
                System.out.println("Enter new menu item name:  ");
                String name6 = scan.next();
                    if (name6.equals(name5)||name6.equals(name4)||name6.equals(name3)||!name6.equals(name2)||!name6.equals(name1)){
                System.out.println("Enter new menu item price: ");
                double price6 = scan.nextDouble();
                menu6.add(name6, price6);}
                    else{System.out.println("Name already exists!");}
            
                System.out.println("~~~~~~~~~~~~~~~~~~~");
                System.out.println("Enter new menu item name:  ");
                String name7 = scan.next();
                    if (name7.equals(name6)||name7.equals(name5)||name7.equals(name4)||name7.equals(name3)||!name7.equals(name2)||!name7.equals(name1)){
                System.out.println("Enter new menu item price: ");
                double price7 = scan.nextDouble();
                menu7.add(name7, price7);}
                    else{System.out.println("Name already exists!");}
            
                System.out.println("~~~~~~~~~~~~~~~~~~~");
                System.out.println("Enter new menu item name:  ");
                String name8 = scan.next();
                    if (name8.equals(name7)||name8.equals(name6)||name8.equals(name5)||name8.equals(name4)||name8.equals(name3)||!name8.equals(name2)||!name8.equals(name1)){
                System.out.println("Enter new menu item price: ");
                double price8 = scan.nextDouble();
                menu8.add(name8, price8);}
                    else{System.out.println("Name already exists!");}
            
                System.out.println("~~~~~~~~~~~~~~~~~~~");
                System.out.println("Enter new menu item name:  ");
                String name9 = scan.next();
                    if (name9.equals(name8)||name9.equals(name7)||name9.equals(name6)||name9.equals(name5)||name9.equals(name4)||name9.equals(name3)||!name9.equals(name2)||!name9.equals(name1)){
                System.out.println("Enter new menu item price: ");
                double price9 = scan.nextDouble();
                menu9.add(name9, price9);}
                    else{System.out.println("Name already exists!");}
            
                System.out.println("~~~~~~~~~~~~~~~~~~~");
                System.out.println("Enter new menu item name:  ");
                String name10 = scan.next();
                    if (name10.equals(name9)||name10.equals(name8)||name10.equals(name7)||name10.equals(name6)||name10.equals(name5)||name10.equals(name4)||name10.equals(name3)||!name10.equals(name2)||!name10.equals(name1)){
                System.out.println("Enter new menu item price: ");
                double price10 = scan.nextDouble();
                menu10.add(name10, price10);}
                    else{System.out.println("Name already exists!");}
                    break;
                }
               
            case 2: {
                System.out.println("~~~~~~~~~~~~~~~~~~~");
                System.out.println("Please enter the menu number that you would like to edit");
                System.out.println("~~~~~~~~~~~~~~~~~~~");
                System.out.println("1.      " + menu1.name + " : " + menu1.price + " php.");
                System.out.println("2.      " + menu2.name + " : " + menu2.price + " php.");
                System.out.println("3.      " + menu3.name + " : " + menu3.price + " php.");
                System.out.println("4.      " + menu4.name + " : " + menu4.price + " php.");
                System.out.println("5.      " + menu5.name + " : " + menu5.price + " php.");
                System.out.println("6.      " + menu6.name + " : " + menu6.price + " php.");
                System.out.println("7.      " + menu7.name + " : " + menu7.price + " php.");
                System.out.println("8.      " + menu8.name + " : " + menu8.price + " php.");
                System.out.println("9.      " + menu9.name + " : " + menu9.price + " php.");
                System.out.println("10.      " + menu10.name + " : " + menu10.price + " php.");
                System.out.println("~~~~~~~~~~~~~~~~~~~");
                System.out.print("Menu Number: ");
                int Nedit = scan.nextInt();
                
                switch(Nedit){
                
                    case 1:{
                System.out.println("~~~~~~~~~~~~~~~~~~~");
                System.out.println("Enter new menu item name:  ");
                String name1 = scan.next();
                System.out.println("Enter new menu item price: ");
                double price1 = scan.nextDouble();
                menu1.edit(name1, price1);
                    break;}
                    
                    case 2:{
                    
                System.out.println("~~~~~~~~~~~~~~~~~~~");
                System.out.println("Enter new menu item name:  ");
                String name2 = scan.next();
                System.out.println("Enter new menu item price: ");
                double price2 = scan.nextDouble();
                menu2.edit(name2, price2);
                    break;}
                
                    case 3:{
                    
                System.out.println("~~~~~~~~~~~~~~~~~~~");
                System.out.println("Enter new menu item name:  ");
                String name3 = scan.next();
                System.out.println("Enter new menu item price: ");
                double price3 = scan.nextDouble();
                menu3.edit(name3, price3);
                    break;}
                
                    case 4:{
                    
                System.out.println("~~~~~~~~~~~~~~~~~~~");
                System.out.println("Enter new menu item name:  ");
                String name4 = scan.next();
                System.out.println("Enter new menu item price: ");
                double price4 = scan.nextDouble();
                menu4.edit(name4, price4);
                    break;}
                    
                    case 5:{
                    
                System.out.println("~~~~~~~~~~~~~~~~~~~");
                System.out.println("Enter new menu item name:  ");
                String name5 = scan.next();
                System.out.println("Enter new menu item price: ");
                double price5 = scan.nextDouble();
                menu5.edit(name5, price5);
                    break;}
                
                    case 6:{
                    
                System.out.println("~~~~~~~~~~~~~~~~~~~");
                System.out.println("Enter new menu item name:  ");
                String name6 = scan.next();
                System.out.println("Enter new menu item price: ");
                double price6 = scan.nextDouble();
                menu6.edit(name6, price6);
                    break;}
                    
                    case 7:{
                    
                System.out.println("~~~~~~~~~~~~~~~~~~~");
                System.out.println("Enter new menu item name:  ");
                String name7 = scan.next();
                System.out.println("Enter new menu item price: ");
                double price7 = scan.nextDouble();
                menu7.edit(name7, price7);
                    break;}
                    
                    case 8:{
                    
                System.out.println("~~~~~~~~~~~~~~~~~~~");
                System.out.println("Enter new menu item name:  ");
                String name8 = scan.next();
                System.out.println("Enter new menu item price: ");
                double price8 = scan.nextDouble();
                menu8.edit(name8, price8);
                    break;}
                    
                    case 9:{
                    
                System.out.println("~~~~~~~~~~~~~~~~~~~");
                System.out.println("Enter new menu item name:  ");
                String name9 = scan.next();
                System.out.println("Enter new menu item price: ");
                double price9 = scan.nextDouble();
                menu9.edit(name9, price9);
                    break;}
                    
                    case 10:{
                    
                System.out.println("~~~~~~~~~~~~~~~~~~~");
                System.out.println("Enter new menu item name:  ");
                String name10 = scan.next();
                System.out.println("Enter new menu item price: ");
                double price10 = scan.nextDouble();
                menu10.edit(name10, price10);
                    break;}
                    
                    default:{System.out.println("Invalid Input");}
                break;}
            }
                
            case 3: {
                System.out.println("~~~~~~~~~~~~~~~~~~~");
                System.out.println("1.      " + menu1.name + " : " + menu1.price + " php.");
                System.out.println("2.      " + menu2.name + " : " + menu2.price + " php.");
                System.out.println("3.      " + menu3.name + " : " + menu3.price + " php.");
                System.out.println("4.      " + menu4.name + " : " + menu4.price + " php.");
                System.out.println("5.      " + menu5.name + " : " + menu5.price + " php.");
                System.out.println("6.      " + menu6.name + " : " + menu6.price + " php.");
                System.out.println("7.      " + menu7.name + " : " + menu7.price + " php.");
                System.out.println("8.      " + menu8.name + " : " + menu8.price + " php.");
                System.out.println("9.      " + menu9.name + " : " + menu9.price + " php.");
                System.out.println("10.      " + menu10.name + " : " + menu10.price + " php.");
            break;
            }
            
            case 4: {
                System.out.println("TERMINATING PROGRAM");
                running = false;
                break;}
            
            default: {System.out.println("Invalid Choice, Try Again");}
        }
        }
    }
}
