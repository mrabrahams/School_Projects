/**
 * @author      Dwight
 * @category    Applications Programming
 * @version     v1.0 16 June 2022
 */

 /*
  * This class will represent a Zone object, which we will define as having:
        • A name, represented as a String (i.e.: Tiger Zone)
        • An array of Animal objects.
        • A toString() method which returns a String representation of all animals in the
                zone
        • An addAnimal(..) method, which takes as a parameter an Animal object and
                returns nothing.
This class must have a constructor and getters and setters to accommodate its
variables
  */
public class Zone {
    private String name;

    private int capacity;

    private Animal[] animals = new Animal[capacity];

    //default constructor
    public Zone() {
    }
    //custom constructor
    public Zone(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;


    }

    //a toString method which returns a String representation of all the animals in the zone
    public String toString() {
        String output = "";
        output += this.name + " Zone : \n";//add name of zone
        output += "----------------\n";
        for (Animal animal : animals) {
            output += animal.toString() + "\n"; //add animal to string
        }
        return output;
    }

    //addAnimal method takes an Animal object returns nothing
    public void addAnimal(Animal animal) {
        //add animal to array of animals
        Animal[] temp = new Animal[animals.length + 1]; //create new array of animals
        for (int i = 0; i < animals.length; i++) {
            temp[i] = animals[i]; //copy old array of animals into new array
        }
        temp[animals.length] = animal;
        animals = temp;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal[] getAnimals() {
        return animals;
    }

    public void setAnimals(Animal[] animals) {
        this.animals = animals;
    }

}


/*
    Purpose:  allows the class to be tested**

    public static void main( String[] args ) {
		Animal testAnimal = new Animal( "Monkey", "Bubbles the Chimp", false );
		Animal testAnimal1 = new Animal( "Monkey", "Bubbles the Chimp1", false );

		//System.out.println(testAnimal);
		Zone testZone = new Zone("test", 10);
		testZone.addAnimal(testAnimal);
		testZone.addAnimal(testAnimal1);
		System.out.println(testZone);

	}*/
