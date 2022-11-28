package EventFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class Festival extends AbstractEvent{

    private String aName; // name of festival
    private Optional<Location> aLocation; // multiple or location of all events
    private LocalDate aDate; // date of first event
    private Optional<Double> aPrice; // 20% of the sum of the ticket price of all the events
    private Optional<Integer> aNumTickets; //smallest number of tickets of the events
    private final ArrayList<Event> aEvents = new ArrayList<>(); // list of events in the festival, can not be changed

    protected Festival(String pName, ArrayList<Event> pEvents){
        super(pName, Optional.empty(), LocalDate.now(), Optional.empty(), Optional.empty());
        aName = pName;

        for(Event e : pEvents){
            aEvents.add(e);
        }

        double tempPrice = 0;
        for(Event e : aEvents){
            if(e.getPrice().isPresent()) {
                tempPrice += e.getPrice().get();
            }
        }
        tempPrice = tempPrice*0.2;
        aPrice = Optional.of(tempPrice);

        int minNumTickets = Integer.MAX_VALUE;
        for(Event e : aEvents){
            if(e.getNumTickets().isPresent()){
                if(e.getNumTickets().get() < minNumTickets){
                    minNumTickets = e.getNumTickets().get();
                }
            }
        }
        aNumTickets = Optional.of(minNumTickets);

        int counter = 0;
        Location initial = Location.Multiple;
        for(Event e : aEvents){
            if(e.getLocation().isPresent()){
                initial = e.getLocation().get();
                break;
            }
        }
        if(initial.equals(Location.Multiple)){
            //all events in the festival have no location
            aLocation = Optional.empty();
        }
        else {
            for (Event e : aEvents) {
                if(e.getLocation().isPresent() && !e.getLocation().get().equals(initial)){
                    continue;
                }
                else{
                    counter++;
                }
               /* if(e.getLocation().isPresent()) {
                    if (e.getLocation().get().equals(initial)) {
                        counter++;
                    }
                }
                else{
                    counter++;
                }*/
            }
            if (counter == aEvents.size()) {
                aLocation = Optional.of(initial);
            } else {
                //multiple locations
                aLocation = Optional.of(Location.Multiple);
            }
        }
        Optional<Location> holdLocation = aLocation;

        LocalDate firstDay = aEvents.get(0).getDate();
        for(int i = 1 ; i<aEvents.size(); i++){
            if(aEvents.get(i).getDate().isBefore(firstDay)){
                firstDay = aEvents.get(i).getDate();
            }
        }
        aDate = firstDay;

        if(holdLocation.isPresent()) {
            super.setLocation(holdLocation.get());
        }
        super.setDate(firstDay);
        super.setPrice(tempPrice);
        super.setNumTickets(minNumTickets);

    }


    //getters

    @Override
    public double getSpecificExpectedProfit(Calculator c) {
        double totalSum = 0;
        for(Event e : aEvents){
            totalSum+=e.getExpectedProfit(c);
        }
        return totalSum;
    }

    @Override
    public int getNumVIPS() {
        int totalNumVIPs = 0;
        for(Event e : aEvents){
            totalNumVIPs += e.getNumVIPS();
        }
        return totalNumVIPs;
    }

    public ArrayList<Event> getEvents(){
        ArrayList<Event> toReturn = new ArrayList<>();
        for(Event e : aEvents){
            toReturn.add(e);
        }
        return toReturn;
    }

    //setters


    @Override
    public void setLocation(Location pLocation) {
        //doesn't do anything
    }

    @Override
    public void setDate(LocalDate pDate) {
        //doesn't do anything
    }

    @Override
    public void setPrice(double pPrice) {
        //doesn't do anything
    }

    @Override
    public void setNumTickets(int pNumTickets) {
        //doesn't do anything
    }

}
