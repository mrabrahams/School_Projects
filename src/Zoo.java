import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

/**
  @author      Dwight
 * @category    Applications Programming
 * @version     v1.1 30 June 2022
 */

/*
 * This class will represent a Zoo object, which we will define as having:
 •       A name, represented as a String (i.e.: Animal Kingdom Zoo)
 •       Zones, stored as an array of Zone objects (i.e. Zone[])
 •       A toString() method, which calls upon the toString() method in Zone.java to
 return as a String all needed information.
 •       An addZone(..) method, which takes as a parameter a Zone object and returns
 nothing.
 This class must have a constructor and getters and setters to accommodate its
 variables
 */


public class Zoo {
    private String name; //name of zoo
    private ArrayList<Zone> zones = new ArrayList<>(); //arraylist of zones

    //default constructor
    public Zoo() {
    }
    //constructor
    public Zoo(String name) {
        this.name = name;
    }

    //addZone method which takes in a Zone and adds it to the arraylist of zones
    public void addZone(Zone zone) {
        this.zones.add(zone);
    }

    //toString method calls upon toString method in Zone.java to return as a String all needed information
    public String toString() {
        StringBuilder output = new StringBuilder("\nWelcome to the " + "\"" + this.name + "\"!\n");
        output.append("-----------------------------------\n");
        for (Zone zone : zones) {
            output.append(zone.toString()).append("\n"); //add zone to string
        }
        return output.toString();
    }

    //loadZones method which takes in a file name and loads the zones from the file
    public void loadZones(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = reader.readLine();
        while (line != null) {
            String[] tokens = line.split(",");
            String name = tokens[0];
            char zoneCode = tokens[2].charAt(0);
            String safetyRating = tokens[1];
            Zone zone = new Zone(name, safetyRating, zoneCode);
            this.addZone(zone);
            line = reader.readLine();
        }
        reader.close();
    }


    //loadAnimals method takes in a file name and throws an IOException if the file is not found
    public void loadAnimals(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = reader.readLine();
        while (line != null) {
            String[] tokens = line.split(",");
            String name = tokens[0];
            String species = tokens[1];
            boolean diet = Boolean.parseBoolean(tokens[2]);
            char zoneCode = tokens[3].charAt(0);
            Animal animal = new Animal(name, species, diet, zoneCode);
            for (Zone zone : this.zones) {
                if (zone.getZoneCode() == animal.getZoneCode()) {
                    zone.addAnimal(animal);
                }
            }
            line = reader.readLine();
        }
        reader.close();
    }

    // object method relocate() which takes in a string Name and a string Zone and relocates the animal to the new zone deleting the animal from the old zone
    public void relocate(String animalToMove, String newZoneCode) {
        Animal animalHolder = null;
        Zone newZoneHolder = null;
        for (Zone zone : this.zones) { // for each zone in the arraylist of zones
            for (Animal animal : zone.getAnimals()) { // for each animal in the arraylist of animals
                if (animal.getName().equals(animalToMove)) { // if the animal's name is equal to the animal to move
                    for (Zone newZone : this.zones) { // for each zone in the arraylist of zones
                        if (newZone.getZoneCode() == newZoneCode.charAt(0)) { // if the new zone's code is equal to the new zone code
                            animalHolder = animal; // set the animal holder to the animal
                            newZoneHolder = newZone; // set the new zone holder to the new zone
                        }
                    }
                }
            }
        }
        for (Zone zone : this.zones) { // for each zone in the arraylist of zones
            if (zone.getZoneCode() == Objects.requireNonNull(animalHolder).getZoneCode()) { // if the zone's code is equal to the animal's zone code
                zone.removeAnimal(animalHolder); // remove the animal from the zone
            }
        }
        Objects.requireNonNull(newZoneHolder).addAnimal(animalHolder); // add the animal to the new zone
    }

    // object method save() which takes no parameters and overwrites the current state of the zoo to the file
    public void save() throws IOException {
        // save the current state of the zoo to the animals.csv file and the zones.csv file
        BufferedWriter writer = new BufferedWriter(new FileWriter("animals.csv"));
        for (Zone z : this.zones) {
            for (Animal a : z.getAnimals()) {
                writer.write(a.getName() + "," + a.getSpecies() + "," + a.isIsCarnivore() + "," + a.getZoneCode());
                writer.newLine();
            }
        }
        writer.close();
        writer = new BufferedWriter(new FileWriter("zones.csv"));
        for (Zone z : this.zones) {
            writer.write(z.getName() + "," + z.getSafetyRating() + "," + z.getZoneCode());
            writer.newLine();
        }
        writer.close();
    }


    //setters, getters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Zone> getZones() {
        return zones;
    }
    public void setZones(ArrayList<Zone> zones) {
        this.zones = zones;
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

		Zoo testZoo = new Zoo("testZoo", 5);

		testZoo.addZone(testZone);


		System.out.println(testZoo);

	}*/
