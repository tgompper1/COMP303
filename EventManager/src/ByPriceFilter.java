import EventFactory.Event;

import java.util.ArrayList;

public class ByPriceFilter implements AbstractFilter {

    private final double aMinPrice;
    private final double aMaxPrice;

    /**
     * Create a filter that will filter based on a given price range of the desired events
     * Filter to be used by FilterResult
     * @param pMinPrice
     * @param pMaxPrice
     * @pre pMaxPrice >= pMinPrice
     */
    public ByPriceFilter(double pMinPrice, double pMaxPrice){
        assert pMaxPrice >= pMinPrice;
        aMaxPrice = pMaxPrice;
        aMinPrice = pMinPrice;
    }

    /**
     * @param unfilteredEvents
     * @pre unfilteredEvents !=null
     * @return a list of events filtered to only include events within the specified price range
     */
    @Override
    public ArrayList<Event> filter(ArrayList<Event> unfilteredEvents) {
        assert unfilteredEvents != null;
        ArrayList<Event> filtered = new ArrayList<>();
        for(Event e : unfilteredEvents){
            if(e.getPrice().isPresent()) {
                if (e.getPrice().get() >= aMinPrice && e.getPrice().get() <= aMaxPrice) {
                    filtered.add(e);
                }
            }
        }
        return filtered;
    }
}
