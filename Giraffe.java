package animals;
public class Giraffe extends Animals{
    public Giraffe(int energy, String name) {
        super(energy, name);}
    
    public void stretch(){
    System.out.println("This " + this.name + " stretched");
    energy -= 5;}

    public void run(){
    System.out.println("This " + this.name + " ran");
    energy -= 15;}
    
    public void gallop(){
    System.out.println("This " + this.name + " galloped");
    energy -= 20;}
}

