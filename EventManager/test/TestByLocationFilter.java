import EventFactory.Calculator;
import EventFactory.Event;
import EventFactory.Location;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestByLocationFilter {

    @Test
    void validLocationTest(){
        try{
            ByLocationFilter f = new ByLocationFilter(null);
            fail();
        }
        catch(AssertionError e){
            //pass
        }
    }

    @Test
    void nullArgumentFilterTest(){
        ByLocationFilter f = new ByLocationFilter(Location.OlympicStadium);
        try{
            f.filter(null);
            fail();
        }
        catch(AssertionError e){
            //pass
        }
    }

    @Test
    void filterByLocationTest(){
        ByLocationFilter f = new ByLocationFilter(Location.ParcJeanDrapeau);
        EventStub e1 = new EventStub(100, Location.ParcJeanDrapeau);
        EventStub e2 = new EventStub(150, Location.OlympicStadium);
        EventStub e3 = new EventStub(25, Location.ParcJeanDrapeau);
        EventStub e4 = new EventStub(70, Location.PlaceDesArts);
        EventStub e5 = new EventStub(80, Location.ParcJeanDrapeau);
        ArrayList<Event> events = new ArrayList<>();
        events.add(e1); events.add(e2); events.add(e3); events.add(e4); events.add(e5);

        ArrayList<Event> filtered = f.filter(events);
        events.remove(e2); events.remove(e4);
        assertEquals(events, filtered);
    }
}
