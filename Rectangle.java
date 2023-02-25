
package rectangle;

import java.util.Scanner;
public class Rectangle {

    
    
    public int Area(){
    
        int a = l + w;
    return a;
    }
    
    public void main(String[] args) {
        
    Scanner scan = new Scanner(System.in);
    System.out.println("Please Input the Length: ");
        int l = scan.nextInt();
    System.out.println("Please Input the Width: ");
        int w = scan.nextInt();
    
       
        
    System.out.println("The Area of the Rectangle is:  " + this.Area());
        
        
    }
    
}
