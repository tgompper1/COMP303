import EventFactory.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class TestFilterResult {

    public class FilterEventStub implements Event{
        Optional<Location> aLocation;
        Optional<Double> aPrice;
        Optional<Integer> aNumTickets;
        int aNumVIPs;

        public FilterEventStub(Location pLocation, double pPrice, int pNumTickets, int pNumVIPs){
            aLocation = Optional.of(pLocation);
            aPrice = Optional.of(pPrice);
            aNumTickets = Optional.of(pNumTickets);
            aNumVIPs = pNumVIPs;
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public Optional<Location> getLocation() {
            return aLocation;
        }

        @Override
        public LocalDate getDate() {
            return null;
        }

        @Override
        public Optional<Double> getPrice() {
            return aPrice;
        }

        @Override
        public Optional<Integer> getNumTickets() {
            return aNumTickets;
        }

        @Override
        public double getExpectedProfit(Calculator c) {
            return ((aPrice.get()*aNumTickets.get())*c.getConcertPercentage())/100;
        }

        @Override
        public int getNumVIPS() {
            return aNumVIPs;
        }

        @Override
        public void setName(String pName) {

        }

        @Override
        public void setLocation(Location pLocation) {

        }

        @Override
        public void setDate(LocalDate pDate) {

        }

        @Override
        public void setPrice(double pPrice) {

        }

        @Override
        public void setNumTickets(int pNumTickets) {

        }
    }

    @Test
    void nullFilterTest(){
        try{
            FilterResult fr = new FilterResult(null, new ArrayList<>());
            fail();
        }catch(AssertionError e){}
    }

    @Test
    void nullListTest(){
        try{
            FilterResult fr  = new FilterResult(new ByLocationFilter(Location.ParcJeanDrapeau), null);
            fail();
        }catch(AssertionError e){}
    }



    @Test
    void getFilteredEventsTest(){
        EventStub e1 = new EventStub(100, Location.ParcJeanDrapeau);
        EventStub e2 = new EventStub(150, Location.BellCentre);
        EventStub e3 = new EventStub(25, Location.BellCentre);
        EventStub e4 = new EventStub(70, Location.BellCentre);
        EventStub e5 = new EventStub(80, Location.ParcJeanDrapeau);
        ArrayList<Event> events = new ArrayList<>();
        events.add(e1); events.add(e2); events.add(e3); events.add(e4); events.add(e5);
        FilterResult fr = new FilterResult(new ByLocationFilter(Location.BellCentre), events);
        events.remove(e1); events.remove(e5);
        assertEquals(events, fr.getFilteredEvents());
    }

    @Test
    void expectedProfitNullTest(){
        EventStub e1 = new EventStub(100, Location.ParcJeanDrapeau);
        EventStub e2 = new EventStub(150, Location.BellCentre);
        EventStub e3 = new EventStub(25, Location.BellCentre);
        EventStub e4 = new EventStub(70, Location.BellCentre);
        EventStub e5 = new EventStub(80, Location.ParcJeanDrapeau);
        ArrayList<Event> events = new ArrayList<>();
        events.add(e1); events.add(e2); events.add(e3); events.add(e4); events.add(e5);
        FilterResult fr = new FilterResult(new ByLocationFilter(Location.BellCentre), events);
        try{
            fr.expectedProfit(null);
            fail();
        }
        catch(AssertionError e){};
    }

    //uses reflection
    @Test
    void expectedProfitTestWith() {
        FilterEventStub c1 = new FilterEventStub(Location.BellCentre, 10, 100, 4);
        FilterEventStub c2 = new FilterEventStub(Location.ParcJeanDrapeau, 20, 200, 2);
        FilterEventStub c3 = new FilterEventStub(Location.BellCentre, 20, 200, 2);
        FilterEventStub c4 = new FilterEventStub(Location.BellCentre, 50, 100, 3);
        ArrayList<Event> concerts = new ArrayList<>();
        concerts.add(c1); concerts.add(c2); concerts.add(c3); concerts.add(c4);

        FilterResult fr = new FilterResult(new ByLocationFilter(Location.BellCentre), concerts);
        Calculator c = new Calculator();
        assertEquals( 5000, fr.expectedProfit(c));
    }

    @Test
    void totalNumVIPsTest(){
        FilterEventStub c1 = new FilterEventStub(Location.BellCentre, 10, 100, 4);
        FilterEventStub c2 = new FilterEventStub(Location.ParcJeanDrapeau, 20, 200, 2);
        FilterEventStub c3 = new FilterEventStub(Location.BellCentre, 20, 200, 2);
        FilterEventStub c4 = new FilterEventStub(Location.BellCentre, 50, 100, 3);
        ArrayList<Event> concerts = new ArrayList<>();
        concerts.add(c1); concerts.add(c2); concerts.add(c3); concerts.add(c4);

        FilterResult fr = new FilterResult(new ByLocationFilter(Location.BellCentre), concerts);
        assertEquals(9, fr.totalNumVIPs());
    }
    //total num vips
}
