package animals;
public class Falcon extends Animals{
    public Falcon(int energy, String name) {
        super(energy, name);
        this.name = "Falcon";}
    
    public void fly(){
    System.out.println("This " + this.name + " Flew");
    energy -= 10;}

    public void swoop(){
    System.out.println("This " + this.name + " Swooped");
    energy -= 15;}
    
    public void flap(){
    System.out.println("This " + this.name + " Flapped");
    energy -= 5;}
}
