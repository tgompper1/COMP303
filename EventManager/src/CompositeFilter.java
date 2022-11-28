import EventFactory.Event;

import java.util.ArrayList;

public class CompositeFilter implements AbstractFilter {
    ArrayList<AbstractFilter> aFilters;

    /**
     * create a filter consisting of multiple filter critera
     * @param pFilters
     * @pre !pFilters.isEmpty()
     */
    public CompositeFilter(ArrayList<AbstractFilter> pFilters){
        assert !pFilters.isEmpty();
        aFilters = pFilters;
    }

    /**Co
     * @param unfilteredEvents
     * @pre unfilteredEvents != null
     * @return an arrayList of events filtered by required filters
     */
    @Override
    public ArrayList<Event> filter(ArrayList<Event> unfilteredEvents) {
        assert unfilteredEvents != null;
        ArrayList<Event> filtered = unfilteredEvents;
        for(AbstractFilter f : aFilters){
            filtered = f.filter(filtered);
        }
        return filtered;
    }
}
