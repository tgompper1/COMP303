import java.util.ArrayList;
import java.util.Collections;

public class RunDrone {
    public static void main(String args[]) {

        Drone myDrone = new Drone("myDrone");

        Flight flight1 = new Flight("flight1");
        Flight flight2 = new Flight("flight2");
        Flight flight3 = new Flight("flight3");

        // Client can create tricks with different distances and/or speeds and can record them or not
        Trick takeoff10 = new TakeOff(10, true, VideoFormats.MP4);
        Trick spindive5 = new Spindive(5, true, VideoFormats.MP4);
        Trick pucker25 = new Pucker(25, true, Speed.HIGH, VideoFormats.MP4);
        Trick takeoff20 = new TakeOff(20, false, null);

        // Client can group a series of tricks into a flight
        flight1.addTrick(takeoff10);
        flight1.addTrick(takeoff20);
        flight1.addTrick(spindive5);
        flight1.addTrick(pucker25);

        flight2.addTrick(takeoff20);
        flight2.addTrick(spindive5);
        flight2.addTrick(pucker25);

        flight3.addTrick(takeoff10);

        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("Query the number of unique directions in a flight:");
        System.out.println("Flight1 has " + flight1.getUniqueDirections() + " unique directions.");
        System.out.println("Flight2 has " + flight2.getUniqueDirections() + " unique directions.");
        System.out.println("Flight3 has " + flight3.getUniqueDirections() + " unique directions.");

        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("Execute flights, demonstrating video recording functionality, take-off, pucker and a third trick, spindive:");
        int flight1ID = myDrone.addFlight(flight1);
        myDrone.executeFlight(flight1, flight1ID);

        System.out.println();

        int flight2ID = myDrone.addFlight(flight2);
        myDrone.executeFlight(flight2, flight2ID);

        System.out.println();

        int flight3ID = myDrone.addFlight(flight3);
        myDrone.executeFlight(flight3, flight3ID);

        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("Flight sorting capabilities:");
        ArrayList<Flight> flights = myDrone.getFlights();
        System.out.println("Unsorted: " + flights);

        System.out.println("Sorting flights in ascending order based on number of tricks:");
        Collections.sort(flights, new ByNumTricksComparator());
        System.out.println("Sorted: " + flights);

        System.out.println();

        ArrayList<Flight> flights2 = myDrone.getFlights();
        System.out.println("Unsorted: " + flights2);

        System.out.println("Sorting flights in ascending order based on number of unique movements");
        Collections.sort(flights2, new ByUniqueMovementsComparator());
        System.out.println("Sorted: " + flights2);

        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
