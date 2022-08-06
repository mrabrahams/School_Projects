/**
 * Lab1 is a Java class containing a main method to run your program when completed.
 * This class will not compile until you have completed the requirements outlined in 
 * the lab description.
 *
 * @originalAuthor Professor Arafat (abc123)
 * @author Dwight
 * Lab 1 - Zoo Management
 * Summer 2022
 */

public class Lab1 {

    public static void main( String[] args ) throws Exception {
        Zoo animalKingdom = new Zoo( "Animal Kingdom" );

        // Load data for the zoo, and print its current status
        animalKingdom.loadZones("animalData/zones.csv");
        animalKingdom.loadAnimals("animalData/animals.csv");


        System.out.println( animalKingdom );

        // Relocate the lion, "Christian" to the "Lion" zone, it was kept
        //in the "Tiger" zone! then print updated status of the Zoo.
        animalKingdom.relocate( "Christian", "L" );
        animalKingdom.save();

        System.out.println( animalKingdom );
    }
}