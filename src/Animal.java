/**
 * @author      Dwight
 * @category    Applications Programming
 * @version     v1.0 16 June 2022
 */

 /*
  * This class will represent an Animal object, which we will define as having:
        • A name, represented as a String (i.e. Tigger)
        • A type, represented as a String (i.e. Tiger)
        • Whether or not the animal is Carnivorous. This will be represented as a boolean
            (i.e. true, for Tigger)
        • A toString() method which returns a String representation of the animal object
This class must have a constructor and getters and setters to accommodate its
variables.
  */
public class Animal {
    private String name;
    private String species;
    private boolean isCarnivore;

    //default constructor
    Animal(){
    }
    //constructor
    public Animal(String species, String name, boolean isCarnivore) {
        this.species = species;
        this.name = name;
        this.isCarnivore = isCarnivore;
    }

    //toString method which returns a String representation of the animal
    public String toString() {
        String output = "";
        output += ">> " + this.species + " - " + this.name + " ";
        if (this.isCarnivore) {
            output += "(Carnivore)";
        } else {
            output += "(Vegetarian)";
        }
        return output;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public boolean isIsCarnivore() {
        return isCarnivore;
    }

    public void setIsCarnivore(boolean isCarnivore) {
        this.isCarnivore = isCarnivore;
    }

}

/*
    Purpose:  allows the class to be tested

	public static void main( String[] args ) {
		Animal testAnimal = new Animal( "Monkey", "Bubbles the Chimp", false );
		System.out.println(testAnimal);

	} */
