import EventFactory.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestByPriceFilter {

    @Test
    void minGreaterThanMaxTest(){
        try{
            ByPriceFilter f = new ByPriceFilter(100, 50);
            fail();
        }
        catch(AssertionError e){
            //pass
        }
    }

    @Test
    void nullArgumentFilterTest(){
        ByPriceFilter f = new ByPriceFilter(50, 100);
        try{
            f.filter(null);
            fail();
        }
        catch(AssertionError e){
            //pass
        }
    }

    @Test
    void filterByPriceTest(){
        ByPriceFilter f = new ByPriceFilter(50, 100);
        EventStub e1 = new EventStub(100, Location.ParcJeanDrapeau);
        EventStub e2 = new EventStub(150, Location.ParcJeanDrapeau);
        EventStub e3 = new EventStub(25, Location.ParcJeanDrapeau);
        EventStub e4 = new EventStub(70, Location.ParcJeanDrapeau);
        EventStub e5 = new EventStub(80, Location.ParcJeanDrapeau);
        ArrayList<Event> events = new ArrayList<>();
        events.add(e1); events.add(e2); events.add(e3); events.add(e4); events.add(e5);

        ArrayList<Event> filtered = f.filter(events);
        events.remove(e2); events.remove(e3);
        assertEquals(events, filtered);
    }
}
