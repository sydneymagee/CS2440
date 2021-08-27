package solution;

public class Lion extends Feline
{
    public Lion (Zoo myZoo, String name)
    {
    }
    public void makeNoise()
    {
        System.out.println("roar...");
    }
    public void eat()
    {
        System.out.println("rip with teeth...");
        getHungerLevel();
        setHungerLevel();
        hunger -= 2;
    }
}
