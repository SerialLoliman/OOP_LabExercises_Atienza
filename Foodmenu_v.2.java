package com.mycompany.foodmenu;
import java.util.*;
public class Foodmenu {
    Scanner scan = new Scanner(System.in);
    private String name = "";
    private int price = 0;
    
   public Foodmenu(String n, int p){
    this.name = n;
    this.price = p;}

   public void add(String name, int price){
    System.out.println("~~~~~~~~~~~~~~~~~~~");
    System.out.println("Please add a menu");
    String n = scan.next(); this.name = n;
    System.out.println("Please add it's price");
    int p = scan.nextInt(); this.price = p;
    if (this.name.equals(Foodmenu.this.name)){
    System.out.println("Menu label already occupied by an existing Food");}
    System.out.println("Menu added!Enter >y< to continue...");}
   
   public void edit(String n,int p){
       System.out.println("~~~~~~~~~~~~~~~~~~~");
       System.out.println("Please enter new name");
       String an = scan.next();System.out.println(an + " Successfully added to the menu");
       System.out.println("Please enter it's new price");
       int ap = scan.nextInt();
       System.out.println("Price successfully established as: " + ap + "php."); 
       this.name = an; this.price = ap;}
   
   public void show(String name, int price){
       System.out.println("~~~~~~~~~~~~~~~~~~~");
       System.out.println("1.      " + name + " : " + price + " php.");}
   
   public static void main (String args[]){  
    Foodmenu Food1 = new Foodmenu("", 0);
    Foodmenu Food2 = new Foodmenu("", 0);
    Foodmenu Food3 = new Foodmenu("", 0);
    Foodmenu Food4 = new Foodmenu("", 0);
    Foodmenu Food5 = new Foodmenu("", 0);
    Foodmenu Food6 = new Foodmenu("", 0);
    Foodmenu Food7 = new Foodmenu("", 0);
    Foodmenu Food8 = new Foodmenu("", 0);
    Foodmenu Food9 = new Foodmenu("", 0);
    Foodmenu Food10 = new Foodmenu("", 0);
    boolean running = true;

    while(running){
        Scanner scan = new Scanner(System.in);
        System.out.println("~~~~~~~~~~~~~~~~~~~");
        System.out.println("Food menu: ");
        System.out.println("~~~~~~~~~~~~~~~~~~~");
        System.out.println("1. Add");
        System.out.println("2. Edit");
        System.out.println("3. View");
        System.out.println("4. Exit");
        System.out.println("~~~~~~~~~~~~~~~~~~~");
        int input = scan.nextInt();
        
    switch (input){
    
        case 1:{
        System.out.println("~~~~~~~~~~~~~~~~~~~");
        Food1.add("",0); String cont = scan.next(); if(!"y".equals(cont)){break;}
        Food2.add("",0); cont = scan.next(); if(!"y".equals(cont)){break;}
        Food3.add("",0); cont = scan.next(); if(!"y".equals(cont)){break;}
        Food4.add("",0); cont = scan.next(); if(!"y".equals(cont)){break;}
        Food5.add("",0); cont = scan.next(); if(!"y".equals(cont)){break;}
        Food6.add("",0); cont = scan.next(); if(!"y".equals(cont)){break;}
        Food7.add("",0); cont = scan.next(); if(!"y".equals(cont)){break;}
        Food8.add("",0); cont = scan.next(); if(!"y".equals(cont)){break;}
        Food9.add("",0); cont = scan.next(); if(!"y".equals(cont)){break;}
        Food10.add("",0);break;}
        
        case 2:{
        System.out.println("Pick which item label(1 to 10): ");
        int put = scan.nextInt();
        
            switch (put){
                case 1:{Food1.edit("", 0);break;}
                case 2:{Food2.edit("", 0);break;}
                case 3:{Food3.edit("", 0);break;}
                case 4:{Food4.edit("", 0);break;}
                case 5:{Food5.edit("", 0);break;}
                case 6:{Food6.edit("", 0);break;}
                case 7:{Food7.edit("", 0);break;}
                case 8:{Food8.edit("", 0);break;}
                case 9:{Food9.edit("", 0);break;}
                case 10:{Food10.edit("", 0);break;}
                default:{System.out.println("Invalid Choice, Try Again");}break;}}
    
    case 3: {
                System.out.println("~~~~~~~~~~~~~~~~~~~");
                System.out.println("1.      " + Food1.name + " : " + Food1.price + " php.");
                System.out.println("2.      " + Food2.name + " : " + Food2.price + " php.");
                System.out.println("3.      " + Food3.name + " : " + Food3.price + " php.");
                System.out.println("4.      " + Food4.name + " : " + Food4.price + " php.");
                System.out.println("5.      " + Food5.name + " : " + Food5.price + " php.");
                System.out.println("6.      " + Food6.name + " : " + Food6.price + " php.");
                System.out.println("7.      " + Food7.name + " : " + Food7.price + " php.");
                System.out.println("8.      " + Food8.name + " : " + Food8.price + " php.");
                System.out.println("9.      " + Food9.name + " : " + Food9.price + " php.");
                System.out.println("10.      " + Food10.name + " : " + Food10.price + " php.");break;}
     
    case 4:{
                System.out.println("TERMINATING PROGRAM");
                running = false;
                break;}
    default:{System.out.println("Invalid Choice, Try Again");}}}}}
