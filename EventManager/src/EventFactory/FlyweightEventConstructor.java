package EventFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class FlyweightEventConstructor {
    private final ArrayList<Event> allEvents = new ArrayList<>(); // all events created to prevent duplicates

    public FlyweightEventConstructor(){};
    /**
     * creates a new concert if an event does not already exist on that date at that location
     * otherwise returns an empty to be dealt with by eventManagement
     */
    public  Optional<Concert> createConcert(String pName, Optional<Location> pLocation, LocalDate pDate, Optional<Double> pPrice, Optional<Integer> pNumTickets, String pArtist, ArrayList<VIP> pVIPs){
        if(pLocation.isEmpty()){
            Concert comingSoon = new Concert(pName, pLocation, pDate, pPrice, pNumTickets, pArtist, pVIPs);
            allEvents.add(comingSoon);
            return Optional.of(comingSoon);
        }
        else if(checkSafe(pLocation.get(), pDate)){
            Concert newConcert = new Concert(pName, pLocation, pDate, pPrice, pNumTickets, pArtist, pVIPs);
            allEvents.add(newConcert);
            return Optional.of(newConcert);
        }
        System.out.println("Event cannot be created due to existing event");
        return Optional.empty();
    }

    /**
     * creates a new Gala if an event does not already exist on that date at that location
     * otherwise returns an empty to be dealt with by eventManagement
     */
    public  Optional<Gala> createGala(String pName, Optional<Location> pLocation, LocalDate pDate, Optional<Double> pPrice, Optional<Integer> pNumTickets, ArrayList<VIP> pVIPs){
        if(pLocation.isEmpty()){
            Gala comingSoon = new Gala(pName, pLocation, pDate, pPrice, pNumTickets, pVIPs);
            allEvents.add(comingSoon);
            return Optional.of(comingSoon);
        }
        else if(checkSafe(pLocation.get(), pDate)){
            Gala newGala = new Gala(pName, pLocation, pDate, pPrice, pNumTickets, pVIPs);
            allEvents.add(newGala);
            return Optional.of(newGala);
        }
        System.out.println("Event cannot be created due to existing event");
        return Optional.empty();
    }

    /**
     * creates a new Screening if an event does not already exist on that date at that location
     * otherwise returns an empty to be dealt with by eventManagement
     */
    public  Optional<Screening> createScreening(String pName, Optional<Location> pLocation, LocalDate pDate, Optional<Double> pPrice, Optional<Integer> pNumTickets, Rating pRating){
        if(pLocation.isEmpty()){
            Screening comingSoon = new Screening(pName, pLocation, pDate, pPrice, pNumTickets, pRating);
            allEvents.add(comingSoon);
            return Optional.of(comingSoon);
        }
        else if(checkSafe(pLocation.get(), pDate)){
            Screening newScreening = new Screening(pName, pLocation, pDate, pPrice, pNumTickets, pRating);
            allEvents.add(newScreening);
            return Optional.of(newScreening);
        }
        System.out.println("Event cannot be created due to existing event");
        return Optional.empty();
    }

    /**
     * creates a new Workshop if an event does not already exist on that date at that location
     * otherwise returns an empty to be dealt with by eventManagement
     */
    public  Optional<Workshop> createWorkshop(String pName, Optional<Location> pLocation, LocalDate pDate, Optional<Double> pPrice, Optional<Integer> pNumTickets, ArrayList<Workshop> pPrerequisites){
        if(pLocation.isEmpty()){
            Workshop comingSoon = new Workshop(pName, pLocation, pDate, pPrice, pNumTickets, pPrerequisites);
            allEvents.add(comingSoon);
            return Optional.of(comingSoon);
        }
        if(checkSafe(pLocation.get(), pDate)){
            Workshop newWorkshop = new Workshop(pName, pLocation, pDate, pPrice, pNumTickets, pPrerequisites);
            allEvents.add(newWorkshop);
            return Optional.of(newWorkshop);
        }
        System.out.println("Event cannot be created due to existing event");
        return Optional.empty();
    }

    /**
     * Creates a new festival. Does not need to check location and dates because all events within the festival
     * should already be safely created. Does not get added to allEvents because all sub-events are already present
     */
    public  Optional<Festival> createFestival(String pName, ArrayList<Event> pEvents){
        Festival potentialAdd = new Festival(pName, pEvents);
        //allEvents.add(potentialAdd);
        return Optional.of(potentialAdd);
    }

    /**
     * checks if it is safe to change the date of an event and then changes the date of the event or not.
     * Only safe if the event does not yet have a location or if there is not an event on the desired date
     * at the location.
     */
    public  void changeDate(Event e, LocalDate newDate){
        Optional<Location> l = e.getLocation();
        if(l.isEmpty()){
            // doesn't matter if another event has the same date because location is unknown right now
            e.setDate(newDate);
        }
        else if(checkSafe(l.get(), newDate)){
            e.setDate(newDate);
        }
        else{
            System.out.println("Cannot change date due to existing event");
        }
    }

    /**
     * checks if it is safe to change the location of an event and then changes the location of the event or not.
     * Only safe if there is not yet an event at the desired location on the date of the event.
     */
    public  void changeLocation(Event e, Location newLocation){
        LocalDate date = e.getDate();
        if(checkSafe(newLocation, date)){
            e.setLocation(newLocation);
        }
        else{
            System.out.println("Cannot change location due to existing event");
        }
    }

    /**
     * checks if an event can be created on a given date at a given location
     */
    private boolean checkSafe(Location pLocation, LocalDate pDate){
        for(Event e : allEvents){
            if(e.getLocation().isPresent()) {
                if (e.getLocation().get().equals(pLocation) && e.getDate().equals(pDate)) {
                    return false;
                }
            }
        }
        return true;
    }
}
