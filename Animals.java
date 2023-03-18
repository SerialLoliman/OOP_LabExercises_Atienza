package animals;
public class Animals {
    int energy = 100;
    String name = "";
    
    public int showenergy(){
        System.out.println("Animal's Energy:" + energy );
    return energy;
    }
    public Animals(int energy, String name){
            this.energy = energy;
            this.name = name;}
    public void eat(){
    System.out.println("This " + this.name + " Ate Something");
    energy += 10;
    System.out.println("This " + this.name + "'s Energy Recovered Slightly");}
    
    public void sleep(){
    System.out.println("This " + this.name + " Rested");
    energy += 30;
    System.out.println("This " + this.name + "'s Energy Drastically Recovered");}
    
    public void drink(){
    System.out.println("This " + this.name + " Drank Water");
    energy += 5;
    System.out.println("This " + this.name + "'s Energy is Recovered");}  
}
