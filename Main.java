
package animals;
public class Main {
    public static void main(String[] args) {
       
        Falcon RedFalcon = new Falcon(110);
        Hippopotamus BlackHippopotamus = new Hippopotamus(2000);
        Giraffe PinkGiraffe = new Giraffe(600);
        
        RedFalcon.fly();
        RedFalcon.showenergy();
        RedFalcon.drink();
        RedFalcon.showenergy();
        BlackHippopotamus.bellyflop();
        BlackHippopotamus.showenergy();
        BlackHippopotamus.eat();
        BlackHippopotamus.showenergy();
        PinkGiraffe.gallop();
        PinkGiraffe.showenergy();
        PinkGiraffe.sleep();
        PinkGiraffe.showenergy();
        
        
        
    }
    
}
