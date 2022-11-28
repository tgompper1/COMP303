import EventFactory.Event;
import EventFactory.Location;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestCompositeFilter {


    @Test
    void nullArgumentFilterTest(){
        ByPriceFilter p = new ByPriceFilter(50, 100);
        ByLocationFilter l = new ByLocationFilter(Location.OlympicStadium);
        ArrayList<AbstractFilter> pl = new ArrayList<>();
        pl.add(p); pl.add(l);
        CompositeFilter f = new CompositeFilter(pl);
        try{
            f.filter(null);
            fail();
        }
        catch(AssertionError e){
            //pass
        }
    }

    @Test
    void filterByLocationAndPriceTest(){
        ByPriceFilter p = new ByPriceFilter(50, 100);
        ByLocationFilter l = new ByLocationFilter(Location.ParcJeanDrapeau);
        ArrayList<AbstractFilter> pl = new ArrayList<>();
        pl.add(p); pl.add(l);
        CompositeFilter f = new CompositeFilter(pl);
        EventStub e1 = new EventStub(100, Location.ParcJeanDrapeau);
        EventStub e2 = new EventStub(150, Location.OlympicStadium);
        EventStub e3 = new EventStub(200, Location.ParcJeanDrapeau);
        EventStub e4 = new EventStub(70, Location.PlaceDesArts);
        EventStub e5 = new EventStub(80, Location.ParcJeanDrapeau);
        ArrayList<Event> events = new ArrayList<>();
        events.add(e1); events.add(e2); events.add(e3); events.add(e4); events.add(e5);

        ArrayList<Event> filtered = f.filter(events);
        events.remove(e2); events.remove(e4); events.remove(e3);
        assertEquals(events, filtered);
    }
}
