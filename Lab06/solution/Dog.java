package solution;

public class Dog extends Canine
{
    public Dog(Zoo myZoo, String name)
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
    public void play()
    {
    }
    public void beFriendly()
    {
    }
}
