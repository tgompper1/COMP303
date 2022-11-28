import EventFactory.Event;

import java.util.ArrayList;

// interface for filter objects, filter objects must have a filter functionality
public interface AbstractFilter {
    ArrayList<Event> filter(ArrayList<Event> unfilteredEvents);
}
