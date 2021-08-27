package solution;

public abstract class Animal
{
    private String name;
    private Zoo zoo;
    private int hungerLevel;

    public Animal (Zoo myZoo, String animalName)
    {
        myZoo = zoo;
        animalName = name;
        hungerLevel = 0;
    }
    public int getHungerLevel()
    {
        return hungerLevel;
    }
    public void setHungerLevel(int hunger)
    {
        if (hunger < 0)
        {
            hungerLevel  = 0;
        }
        if (hunger > 10)
        {
            hungerLevel  = 10;
        }
        else 
        {
            hungerLevel = hunger;
        }
    }
    public String getName()
    {
        return name;
    }
    public void setName(String animalName)
    {
        this.name = animalName;
    }
    public void sleep()
    {
        System.out.println("sleeping...");
        hungerLevel = 10;
    }
    public void roam()
    {
        System.out.println("moving around...");
        hungerLevel += 1;
    }
    public abstract  void makeNoise();
   
    
    public abstract void eat();
    
    
}

