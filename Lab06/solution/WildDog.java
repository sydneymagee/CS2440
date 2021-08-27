package solution;

public class WildDog extends Canine
{
    public WildDog(Zoo myZoo, String name)
    {
    }
    public void makeNoise()
    {
        System.out.println("bark...");
    }
    public void eat()
    {
        System.out.println("slop...");
        setHungerLevel();
        hunger -= 3;
        getHungerLevel();
    }
}
