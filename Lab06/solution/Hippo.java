package solution;

public class Hippo extends Animal
{
    public Hippo (Zoo myZoo, String name)
    {
    }
    public void makeNoise()
    {
        System.out.println("blub...");
    }
    public void eat()
    {
        System.out.println("slurp...");
        getHungerLevel();
        setHungerLevel();
        hunger -= 1;
    }
}
