package solution;

public class Wolf extends Canine
{
    public Wolf(Zoo myZoo, String name)
    {
    }
    public void makeNoise()
    {
        System.out.println("growl...");
    }
    public void eat()
    {
        System.out.println("rip with teeth...");
        setHungerLevel();
        hunger -= 2;
        getHungerLevel();
    } 
 } 
