package EventFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestFestival {
    Festival myTestFestival;
    ArrayList<Event> evs;

    @BeforeEach
    void festivalSetUp(){
        Screening myTestScreening = new Screening("Screening", Optional.of(Location.OlympicStadium), LocalDate.of(2022, 7, 1), Optional.of(10.00), Optional.of(100), Rating.G);
        Gala myTestGala = new Gala("Movie", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 7, 3), Optional.of(3.00), Optional.of(500), new ArrayList<VIP>());
        Concert myTestConcert = new Concert("Concert", Optional.of(Location.BellCentre), LocalDate.of(2022, 7, 4), Optional.of(55.00), Optional.of(200), "Stromae", new ArrayList<VIP>());
        Workshop myTestWorkshop = new Workshop("Workshop", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 7, 5), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        evs = new ArrayList<>();
        evs.add(myTestConcert); evs.add(myTestGala); evs.add(myTestWorkshop); evs.add(myTestScreening);

        myTestFestival = new Festival("July Festival", evs);
    }

    //getters tests
    @Test
    void getNameTest() {
        assertEquals("July Festival", myTestFestival.getName());
    }

    @Test
    void getDateTest() {
        assertEquals(LocalDate.of(2022, 7, 1), myTestFestival.getDate());
    }

    @Test
    void getLocationMultipleTest() {
        assertEquals(Location.Multiple, myTestFestival.getLocation().get());
    }

    @Test
    void getLocationSingleTest() {
        Screening myTestScreening = new Screening("Screening", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 7, 1), Optional.of(10.00), Optional.of(100), Rating.G);
        Gala myTestGala = new Gala("Movie", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 7, 3), Optional.of(3.00), Optional.of(500), new ArrayList<VIP>());
        Concert myTestConcert = new Concert("Concert", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 7, 4), Optional.of(55.00), Optional.of(200), "Stromae", new ArrayList<VIP>());
        Workshop myTestWorkshop = new Workshop("Workshop", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 7, 5), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        ArrayList<Event> events = new ArrayList<>();
        events.add(myTestConcert); events.add(myTestGala); events.add(myTestWorkshop); events.add(myTestScreening);

        Festival myTestFestival2 = new Festival("July Festival", events);
        assertEquals(Location.PlaceDesArts, myTestFestival2.getLocation().get());
    }

    @Test
    void getLocationEmptyTest() {
        Screening myTestScreening = new Screening("Screening", Optional.empty(), LocalDate.of(2022, 7, 1), Optional.of(10.00), Optional.of(100), Rating.G);
        Gala myTestGala = new Gala("Movie", Optional.empty(), LocalDate.of(2022, 7, 3), Optional.of(3.00), Optional.of(500), new ArrayList<VIP>());
        Concert myTestConcert = new Concert("Concert", Optional.empty(), LocalDate.of(2022, 7, 4), Optional.of(55.00), Optional.of(200), "Stromae", new ArrayList<VIP>());
        Workshop myTestWorkshop = new Workshop("Workshop", Optional.empty(), LocalDate.of(2022, 7, 5), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        ArrayList<Event> events = new ArrayList<>();
        events.add(myTestConcert); events.add(myTestGala); events.add(myTestWorkshop); events.add(myTestScreening);

        Festival myTestFestival2 = new Festival("July Festival", events);
        assertEquals(Optional.empty(), myTestFestival2.getLocation());
    }

    @Test
    void getPriceTest() {
        assertEquals(18.6, myTestFestival.getPrice().get());
    }


    @Test
    void getNumTicketsTest() {
        assertEquals(25, myTestFestival.getNumTickets().get());
    }

    @Test
    void getExpectedProfitTest() {
        Calculator c = new Calculator(10, 20, 30, 40);
        assertEquals(2075, myTestFestival.getExpectedProfit(c));
    }

    @Test
    void getNumVIPsTest(){
        Screening myTestScreening = new Screening("Screening", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 7, 1), Optional.of(10.00), Optional.of(100), Rating.G);
        VIP vip11 = new VIP("one", Optional.empty());
        VIP vip21 = new VIP("two", Optional.empty());
        VIP vip31 = new VIP("three", Optional.empty());
        ArrayList<VIP> vips1 = new ArrayList<>();
        vips1.add(vip11);
        vips1.add(vip21);
        vips1.add(vip31);
        Gala myTestGala = new Gala("Party", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(500), vips1);
        VIP vip1 = new VIP("one", Optional.empty());
        VIP vip2 = new VIP("two", Optional.empty());
        VIP vip3 = new VIP("three", Optional.empty());
        ArrayList<VIP> vips = new ArrayList<>();
        vips.add(vip1);
        vips.add(vip2);
        vips.add(vip3);
        Concert myTestConcert = new Concert("Stromae", Optional.of(Location.BellCentre), LocalDate.of(2022, 9, 20), Optional.of(55.00), Optional.of(200), "Stromae", vips);
        Workshop myTestWorkshop = new Workshop("Workshop", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 7, 5), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        ArrayList<Event> events = new ArrayList<>();
        events.add(myTestConcert); events.add(myTestGala); events.add(myTestWorkshop); events.add(myTestScreening);

        Festival myTestFestival2 = new Festival("July Festival", events);
        assertEquals(6, myTestFestival2.getNumVIPS());
    }

    @Test
    void getEventsTest(){
        assertEquals(evs, myTestFestival.getEvents());
    }

    //setters tests
    @Test
    void setNameTest() {
        myTestFestival.setName("Fest");
        assertEquals("Fest", myTestFestival.getName());
    }

    @Test
    void setLocationTest() {
        myTestFestival.setLocation(Location.ParcJeanDrapeau);
        assertNotEquals(Location.ParcJeanDrapeau, myTestFestival.getLocation().get());
    }

    @Test
    void setDateTest() {
        myTestFestival.setDate(LocalDate.of(2022, 10, 20));
        assertNotEquals(LocalDate.of(2022, 10, 20), myTestFestival.getDate());
    }

    @Test
    void setPriceTest() {
        myTestFestival.setPrice(75.00);
        assertNotEquals(75.00, myTestFestival.getPrice().get());
    }

    @Test
    void setNumTicketsTest() {
        myTestFestival.setNumTickets(1000);
        assertNotEquals(1000, myTestFestival.getNumTickets().get());
    }
}
