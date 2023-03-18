package animals;
public class Hippopotamus extends Animals{
    public Hippopotamus(int energy, String name) {
        super(energy, name);}
    
    public void bellyflop(){
    System.out.println("This " + this.name + " flopped it's belly");
    energy -= 20;}

    public void squirt(){
    System.out.println("This " + this.name + " Squirted");
    energy -= 5;}
    
    public void swim(){
    System.out.println("This " + this.name + " swam");
    energy -= 15;}
}
