package solution;

public class FeralCat extends Feline
{
    public FeralCat (Zoo myZoo, String name)
    {
    }
    public void makeNoise()
    {
        System.out.println("meow...");
    }
    public void eat()
    {
        System.out.println("pick...");
        getHungerLevel();
        setHungerLevel();
        hunger -= 3;
    }
}
