
package animals;


public class Giraffe extends Animals{

    public Giraffe(int energy) {
        super(energy);
    }
    
    public void stretch(){
    System.out.println("This Giraffe stretched");
    energy -= 5;
    }

    public void run(){
    System.out.println("This Giraffe ran");
    energy -= 15;
    }
    
    public void gallop(){
    System.out.println("This Giraffe galloped");
    energy -= 20;
    }
}

