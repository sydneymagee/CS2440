package solution;

public class Cat extends Feline
{
    public Cat (Zoo myZoo, String name)
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
    public void play()
    {
    }
    public void beFriendly()
    {
    }
}
