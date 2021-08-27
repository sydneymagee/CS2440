package solution;
import java.util.ArrayList;

public class Zoo
{
    private String name;
    private double latitude;
    private double longitude;
    private ArrayList<Animal> zooAnimals;

    public Zoo (String name, double lat, double lon)
    {
        this.name = name;
        lat = latitude;
        lon = longitude;
        ArrayList<Animal> zooAnimals = new ArrayList<Animal>();
    }
    public double getLatitude()
    {
        return lat;
    }
    public double getLongitude()
    {
        return lon;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public int getNumOfAnimals()
    {
        return zooAnimals.size();
    }
    public void addAnimal(Animal animal)
    {
        Animal.add(animal);
    }
    public void testAnimals()
    {
        for (int i = 0; i < zooAnimals.length; i++)
        {
        System.out.println(Zoo.getName());
        System.out.println("");
        System.out.println(Zoo.getLattitude());
        System.out.println("");
        System.out.println(Zoo.getLongitude());
        System.out.println("");
        System.out.println(Zoo.getNumOfAnimals());
        System.out.println("");
        }
    }

    public static void main(String[] args)
    {
    }
}
