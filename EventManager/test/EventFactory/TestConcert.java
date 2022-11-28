package EventFactory;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

public class TestConcert {

    //getters tests
    @Test
    void getNameTest() {
        Concert myTestConcert = new Concert("Stromae", Optional.of(Location.BellCentre), LocalDate.of(2022, 9, 20), Optional.of(55.00), Optional.of(200), "Stromae", new ArrayList<VIP>());
        assertEquals("Stromae", myTestConcert.getName());
    }

    @Test
    void getDateTest() {
        Concert myTestConcert = new Concert("Stromae", Optional.of(Location.BellCentre), LocalDate.of(2022, 9, 20), Optional.of(55.00), Optional.of(200), "Stromae", new ArrayList<VIP>());
        assertEquals(LocalDate.of(2022, 9, 20), myTestConcert.getDate());
    }

    @Test
    void getArtistTest() {
        Concert myTestConcert = new Concert("Stromae", Optional.of(Location.BellCentre), LocalDate.of(2022, 9, 20), Optional.of(55.00), Optional.of(200), "Stromae", new ArrayList<VIP>());
        assertEquals("Stromae", myTestConcert.getArtist());
    }

    @Test
    void getNumVIPsTest() {
        VIP vip1 = new VIP("one", Optional.empty());
        VIP vip2 = new VIP("two", Optional.empty());
        VIP vip3 = new VIP("three", Optional.empty());
        ArrayList<VIP> vips = new ArrayList<>();
        vips.add(vip1);
        vips.add(vip2);
        vips.add(vip3);

        Concert myTestConcert = new Concert("Stromae", Optional.of(Location.BellCentre), LocalDate.of(2022, 9, 20), Optional.of(55.00), Optional.of(200), "Stromae", vips);
        assertEquals(3, myTestConcert.getNumVIPS());
    }

    @Test
    void getVIPsTest() {
        VIP vip1 = new VIP("one", Optional.empty());
        VIP vip2 = new VIP("two", Optional.empty());
        VIP vip3 = new VIP("three", Optional.empty());
        ArrayList<VIP> vips = new ArrayList<>();
        vips.add(vip1);
        vips.add(vip2);
        vips.add(vip3);

        Concert myTestConcert = new Concert("Stromae", Optional.of(Location.BellCentre), LocalDate.of(2022, 9, 20), Optional.of(55.00), Optional.of(200), "Stromae", vips);
        assertEquals(vips, myTestConcert.getVIPs());
    }

    @Test
    void getLocationPresentTest() {
        Concert myTestConcert = new Concert("Stromae", Optional.of(Location.BellCentre), LocalDate.of(2022, 9, 20), Optional.of(55.00), Optional.of(200), "Stromae", new ArrayList<VIP>());
        assertEquals(Location.BellCentre, myTestConcert.getLocation().get());
    }

    @Test
    void getLocationEmptyTest() {
        Concert myTestConcert = new Concert("Stromae", Optional.empty(), LocalDate.of(2022, 9, 20), Optional.of(55.00), Optional.of(200), "Stromae", new ArrayList<VIP>());
        assertEquals(Optional.empty(), myTestConcert.getLocation());
    }

    @Test
    void getPricePresentTest() {
        Concert myTestConcert = new Concert("Stromae", Optional.of(Location.BellCentre), LocalDate.of(2022, 9, 20), Optional.of(55.00), Optional.of(200), "Stromae", new ArrayList<VIP>());
        assertEquals(55, myTestConcert.getPrice().get());
    }

    @Test
    void getPriceEmptyTest() {
        Concert myTestConcert = new Concert("Stromae", Optional.of(Location.BellCentre), LocalDate.of(2022, 9, 20), Optional.empty(), Optional.of(200), "Stromae", new ArrayList<VIP>());
        assertEquals(Optional.empty(), myTestConcert.getPrice());
    }

    @Test
    void getNumTicketsPresentTest() {
        Concert myTestConcert = new Concert("Stromae", Optional.of(Location.BellCentre), LocalDate.of(2022, 9, 20), Optional.of(55.00), Optional.of(200), "Stromae", new ArrayList<VIP>());
        assertEquals(200, myTestConcert.getNumTickets().get());
    }

    @Test
    void getNumTicketsEmptyTest() {
        Concert myTestConcert = new Concert("Stromae", Optional.of(Location.BellCentre), LocalDate.of(2022, 9, 20), Optional.of(55.00), Optional.empty(), "Stromae", new ArrayList<VIP>());
        assertEquals(Optional.empty(), myTestConcert.getNumTickets());
    }

    @Test
    void getExpectedProfitTest() {
        Concert myTestConcert = new Concert("Stromae", Optional.of(Location.BellCentre), LocalDate.of(2022, 9, 20), Optional.of(55.00), Optional.of(200), "Stromae", new ArrayList<VIP>());
        Calculator c = new Calculator(20, 0, 0, 0);
        assertEquals(2200, myTestConcert.getExpectedProfit(c));
    }

    @Test
    void getExpectedProfitMissingPriceTest() {
        Concert myTestConcert = new Concert("Stromae", Optional.of(Location.BellCentre), LocalDate.of(2022, 9, 20), Optional.empty(), Optional.of(200), "Stromae", new ArrayList<VIP>());
        Calculator c = new Calculator(20, 0, 0, 0);
        assertEquals(0, myTestConcert.getExpectedProfit(c));
    }

    @Test
    void getExpectedProfitMissingNumTicketsTest() {
        Concert myTestConcert = new Concert("Stromae", Optional.of(Location.BellCentre), LocalDate.of(2022, 9, 20), Optional.of(55.00), Optional.empty(), "Stromae", new ArrayList<VIP>());
        Calculator c = new Calculator(20, 0, 0, 0);
        assertEquals(0, myTestConcert.getExpectedProfit(c));
    }

    //setters tests
    @Test
    void addVIPTest() {
        VIP newVIP = new VIP("added", Optional.empty());
        ArrayList vips = new ArrayList<>();
        vips.add(newVIP);
        Concert myTestConcert = new Concert("Stromae", Optional.of(Location.BellCentre), LocalDate.of(2022, 9, 20), Optional.of(55.00), Optional.of(200), "Stromae", new ArrayList<VIP>());
        myTestConcert.addVIP(newVIP);
        assertEquals(vips, myTestConcert.getVIPs());
    }

    @Test
    void removeVIPTest() {
        VIP toRemoveVIP = new VIP("added", Optional.empty());
        ArrayList vips = new ArrayList<>();
        vips.add(toRemoveVIP);
        Concert myTestConcert = new Concert("Stromae", Optional.of(Location.BellCentre), LocalDate.of(2022, 9, 20), Optional.of(55.00), Optional.of(200), "Stromae", vips);
        myTestConcert.removeVIP(toRemoveVIP);
        vips.remove(toRemoveVIP);
        assertEquals(vips, myTestConcert.getVIPs());
    }

    @Test
    void setNameTest() {
        Concert myTestConcert = new Concert("Stromae", Optional.of(Location.BellCentre), LocalDate.of(2022, 9, 20), Optional.of(55.00), Optional.of(200), "Stromae", new ArrayList<VIP>());
        myTestConcert.setName("Concert of the Year");
        assertEquals("Concert of the Year", myTestConcert.getName());
    }

    @Test
    void setLocationTest() {
        Concert myTestConcert = new Concert("Stromae", Optional.of(Location.BellCentre), LocalDate.of(2022, 9, 20), Optional.of(55.00), Optional.of(200), "Stromae", new ArrayList<VIP>());
        myTestConcert.setLocation(Location.OlympicStadium);
        assertEquals(Location.OlympicStadium, myTestConcert.getLocation().get());
    }

    @Test
    void setDateTest() {
        Concert myTestConcert = new Concert("Stromae", Optional.of(Location.BellCentre), LocalDate.of(2022, 9, 20), Optional.of(55.00), Optional.of(200), "Stromae", new ArrayList<VIP>());
        myTestConcert.setDate(LocalDate.of(2022, 10, 20));
        assertEquals(LocalDate.of(2022, 10, 20), myTestConcert.getDate());
    }

    @Test
    void setPriceTest() {
        Concert myTestConcert = new Concert("Stromae", Optional.of(Location.BellCentre), LocalDate.of(2022, 9, 20), Optional.of(55.00), Optional.of(200), "Stromae", new ArrayList<VIP>());
        myTestConcert.setPrice(75.00);
        assertEquals(75.00, myTestConcert.getPrice().get());
    }

    @Test
    void setNumTicketsTest() {
        Concert myTestConcert = new Concert("Stromae", Optional.of(Location.BellCentre), LocalDate.of(2022, 9, 20), Optional.of(55.00), Optional.of(200), "Stromae", new ArrayList<VIP>());
        myTestConcert.setNumTickets(300);
        assertEquals(300, myTestConcert.getNumTickets().get());
    }

    @Test
    void setArtistTest() {
        Concert myTestConcert = new Concert("Stromae", Optional.of(Location.BellCentre), LocalDate.of(2022, 9, 20), Optional.of(55.00), Optional.of(200), "Stromae", new ArrayList<VIP>());
        myTestConcert.setArtist("Fake Stromae");
        assertEquals("Fake Stromae", myTestConcert.getArtist());
    }
}
