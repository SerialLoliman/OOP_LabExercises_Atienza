
package animals;

public class Hippopotamus extends Animals{

    public Hippopotamus(int energy) {
        super(energy);
    }
    
    public void bellyflop(){
    System.out.println("This Hippopotamus flopped it's belly");
    energy -= 20;
    }

    public void squirt(){
    System.out.println("This Hippopotamus Squirted");
    energy -= 5;
    }
    
    public void swim(){
    System.out.println("This Hippopotamus swam");
    energy -= 15;
    }
}
