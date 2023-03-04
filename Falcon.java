
package animals;
public class Falcon extends Animals{

    public Falcon(int energy) {
        super(energy);
    }
    
    public void fly(){
    System.out.println("This Falcon Flew");
    energy -= 10;
    }

    public void swoop(){
    System.out.println("This Falcon Swooped");
    energy -= 15;
    }
    
    public void flap(){
    System.out.println("This Falcon Flapped");
    energy -= 5;
    }
}