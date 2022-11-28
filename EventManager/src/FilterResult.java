
import EventFactory.Calculator;
import EventFactory.Event;

import java.util.ArrayList;

public class FilterResult {
    private final ArrayList<Event> aFilteredEvents; // Arraylist of events after they are filtered by given filter

    /**
     * creates a FilterResult object containing a list of filtered events that have been filtered
     *      by the provided filter
     * @param filter
     * @param unfilteredEvents
     * @pre filter != null && unfilteredEvents != null
     */
    public FilterResult(AbstractFilter filter, ArrayList<Event> unfilteredEvents){
        assert filter != null && unfilteredEvents != null;
        aFilteredEvents = filter.filter(unfilteredEvents);
    }

    /**
     * @return list of filtered events
     */
    public ArrayList<Event> getFilteredEvents(){
        ArrayList<Event> toReturn = new ArrayList<>();
        for(Event e : aFilteredEvents){
            toReturn.add(e);
        }
        return toReturn;
    }

    /**
     * finds the expected profit using the provided calculator which contains either
     *      the default profit percentages or the ones provided by Bob
     * @param c
     * @pre c != null
     * @return expected profit of all the filtered events combined
     */
    public double expectedProfit(Calculator c){
        assert c != null;
        double expectedProfit = 0;
        for(Event e : aFilteredEvents){
            expectedProfit += e.getExpectedProfit(c);
        }
        return expectedProfit;
    }

    /**
     * @return total number of VIPs attending all events (always 0 for workshops and screenings)
     */
    public int totalNumVIPs(){
        int numVIPs = 0;
        for(Event e : aFilteredEvents){
            numVIPs += e.getNumVIPS();
        }
        return numVIPs;
    }
}
