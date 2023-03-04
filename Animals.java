
package animals;

public class Animals {
    int energy = 100;
    
    public int showenergy(){
        System.out.println("Animal's Energy:" + energy );
    return energy;
    }
    public Animals(int energy){
            this.energy = energy;
    }
    public void eat(){
    System.out.println("It Ate Something");
    energy += 10;
    System.out.println("It's Energy Recovered Slightly");
    }
    
    public void sleep(){
    System.out.println("It Rested");
    energy += 30;
    System.out.println("It's Energy Drastically Recovered");
    }
    
    public void drink(){
    System.out.println("It Drank Water");
    energy += 5;
    System.out.println("It's Energy is Recovered");
    }
    
    
}
