import java.util.ArrayList;

/**
 * @author      Dwight
 * @category    Applications Programming
 * @version     v1.1 30 June 2022
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

    private ArrayList<Animal> animals = new ArrayList<>();

    private char zoneCode;

    private String safetyRating;

    //default constructor
    public Zone() {
    }
    //custom constructor
    public Zone(String name, String safetyRating, char zoneCode) {
        this.name = name;
        this.zoneCode = zoneCode;
        this.safetyRating = safetyRating;
    }

    //a toString method which returns a String representation of all the animals in the zone
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(this.name).append(" Zone : \n");//add name of zone
        output.append("----------------\n");
        for (Animal animal : animals) {
            output.append(animal.toString()).append("\n"); //add animal to string
        }
        return output.toString();
    }

    // a method addAnimal which takes in an Animal and adds them to that respective Zone
    public void addAnimal(Animal animal) {
        this.animals.add(animal); //add animal to arraylist
        animal.setZoneCode(this.zoneCode); //set zone code of animal to zone code of zone
    }

    // a method removeAnimal which takes in an Animal and zone then removes them from that Zone
    public void removeAnimal(Animal animal) {
        this.animals.remove(animal); //remove animal from arraylist
        animal.setZoneCode(' '); //set zone code of animal to blank
    }



    //getters and setters for variables
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(char zoneCode) {
        this.zoneCode = zoneCode;
    }

    public String getSafetyRating() {
        return safetyRating;
    }

    public void setSafetyRating(String safetyRating) {
        this.safetyRating = safetyRating;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
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
