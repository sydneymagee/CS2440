package soltion;

public class Coyote extends Canine
{
    public Coyote (Zoo myZoo, String name)
    {
    }
    public void makeNoise()
    {
        System.out.println("howl...");
    }
    public void eat()
    {
        System.out.println("gnaws...");
        getHungerLevel();
        setHungerLevel();
        hunger -= 2;
    }
}
