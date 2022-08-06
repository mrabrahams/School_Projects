/**
 * @author      Dwight
 * @category    Applications Programming
 * @version     v1.0 16 June 2022
 */


/**
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
    private String name;
    private int zoneCapacity;
    private Zone[] zones = new Zone[zoneCapacity];

    //default constructor
    public Zoo() {
    }
    //constructor
    public Zoo(String name, int capacity) {
        this.name = name;
        this.zoneCapacity = capacity;
//        zones = new Zone[capacity];
    }

    //addZone method returns nothing
    public void addZone(Zone zone) {
        //add zone to array of zones
        Zone[] temp = new Zone[zones.length + 1]; //STEP = removed +1
        for (int i = 0; i < zones.length; i++) {
            temp[i] = zones[i];
        }
        temp[zones.length] = zone; //add zone to array
        zones = temp; //set zones to new array
    }

    //toString method calls upon toString method in Zone.java to return as a String all needed information
    public String toString() {
        String output = "\nWelcome to the " + "\"" + this.name + "\"!\n";
        output += "-----------------------------------\n";
        for (Zone zone : zones) {
            output += zone.toString() + "\n"; //add zone to string
        }
        return output;
    }

    //setters, getters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Zone[] getZones() {
        return zones;
    }
    public void setZones(Zone[] zones) {
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
