import EventFactory.Event;
import EventFactory.Location;

import java.util.ArrayList;

public class ByLocationFilter implements AbstractFilter {
    private final Location aLocation;

    /**
     * Create a filter that will filter based on a given location of the desired events
     * Filter to be used by FilterResult
     * @param pLocation
     * @pre pLocation != null
     */
    public ByLocationFilter(Location pLocation){
        assert pLocation != null;
        aLocation = pLocation;
    }

    /**
     * @param unfilteredEvents
     * @pre unfilteredEvents != null
     * @return a list of events filtered to only include events at the specified location
     */
    @Override
    public ArrayList<Event> filter(ArrayList<Event> unfilteredEvents) {
        assert unfilteredEvents != null;
        ArrayList<Event> filtered = new ArrayList<>();
        for(Event e : unfilteredEvents){
            if(e.getLocation().isPresent()) {
                if (e.getLocation().get().equals((aLocation))) {
                    filtered.add(e);
                }
            }
        }
        return filtered;
    }
}
