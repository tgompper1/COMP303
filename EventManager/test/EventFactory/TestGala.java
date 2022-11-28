package EventFactory;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGala {
    //getters tests
    @Test
    void getNameTest() {
        Gala myTestGala = new Gala("Party", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(500), new ArrayList<VIP>());
        assertEquals("Party", myTestGala.getName());
    }

    @Test
    void getDateTest() {
        Gala myTestGala = new Gala("Party", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(500), new ArrayList<VIP>());
        assertEquals(LocalDate.of(2022, 5, 3), myTestGala.getDate());
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

        Gala myTestGala = new Gala("Party", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(500), vips);
        assertEquals(3, myTestGala.getNumVIPS());
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

        Gala myTestGala = new Gala("Party", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(500), vips);
        assertEquals(vips, myTestGala.getVIPs());
    }

    @Test
    void getLocationPresentTest() {
        Gala myTestGala = new Gala("Party", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(500), new ArrayList<VIP>());
        assertEquals(Location.PlaceDesArts, myTestGala.getLocation().get());
    }

    @Test
    void getLocationEmptyTest() {
        Gala myTestGala = new Gala("Party", Optional.empty(), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(500), new ArrayList<VIP>());
        assertEquals(Optional.empty(), myTestGala.getLocation());
    }

    @Test
    void getPricePresentTest() {
        Gala myTestGala = new Gala("Party", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(500), new ArrayList<VIP>());
        assertEquals(3, myTestGala.getPrice().get());
    }

    @Test
    void getPriceEmptyTest() {
        Gala myTestGala = new Gala("Party", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 5, 3), Optional.empty(), Optional.of(500), new ArrayList<VIP>());
        assertEquals(Optional.empty(), myTestGala.getPrice());
    }

    @Test
    void getNumTicketsPresentTest() {
        Gala myTestGala = new Gala("Party", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(500), new ArrayList<VIP>());
        assertEquals(500, myTestGala.getNumTickets().get());
    }

    @Test
    void getNumTicketsEmptyTest() {
        Gala myTestGala = new Gala("Party", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.empty(), new ArrayList<VIP>());
        assertEquals(Optional.empty(), myTestGala.getNumTickets());
    }

    @Test
    void getExpectedProfitTest() {
        Gala myTestGala = new Gala("Party", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(500), new ArrayList<VIP>());
        Calculator c = new Calculator(0, 0, 70, 0);
        assertEquals(1050, myTestGala.getExpectedProfit(c));
    }

    @Test
    void getExpectedProfitMissingPriceTest() {
        Gala myTestGala = new Gala("Party", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 5, 3), Optional.empty(), Optional.of(500), new ArrayList<VIP>());
        Calculator c = new Calculator(20, 0, 70, 0);
        assertEquals(0, myTestGala.getExpectedProfit(c));
    }

    @Test
    void getExpectedProfitMissingNumTicketsTest() {
        Gala myTestGala = new Gala("Party", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.empty(), new ArrayList<VIP>());
        Calculator c = new Calculator(20, 0, 70, 0);
        assertEquals(0, myTestGala.getExpectedProfit(c));
    }

    //setters tests
    @Test
    void addVIPTest() {
        VIP newVIP = new VIP("added", Optional.empty());
        ArrayList vips = new ArrayList<>();
        vips.add(newVIP);
        Gala myTestGala = new Gala("Party", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(500), new ArrayList<VIP>());
        myTestGala.addVIP(newVIP);
        assertEquals(vips, myTestGala.getVIPs());
    }

    @Test
    void removeVIPTest() {
        VIP toRemoveVIP = new VIP("added", Optional.empty());
        ArrayList vips = new ArrayList<>();
        vips.add(toRemoveVIP);
        Gala myTestGala = new Gala("Party", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(500), vips);
        myTestGala.removeVIP(toRemoveVIP);
        vips.remove(toRemoveVIP);
        assertEquals(vips, myTestGala.getVIPs());
    }

    @Test
    void setNameTest() {
        Gala myTestGala = new Gala("Party", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(500), new ArrayList<VIP>());
        myTestGala.setName("Art Gala");
        assertEquals("Art Gala", myTestGala.getName());
    }

    @Test
    void setLocationTest() {
        Gala myTestGala = new Gala("Party", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(500), new ArrayList<VIP>());
        myTestGala.setLocation(Location.ParcJeanDrapeau);
        assertEquals(Location.ParcJeanDrapeau, myTestGala.getLocation().get());
    }

    @Test
    void setDateTest() {
        Gala myTestGala = new Gala("Party", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(500), new ArrayList<VIP>());
        myTestGala.setDate(LocalDate.of(2022, 10, 20));
        assertEquals(LocalDate.of(2022, 10, 20), myTestGala.getDate());
    }

    @Test
    void setPriceTest() {
        Gala myTestGala = new Gala("Party", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(500), new ArrayList<VIP>());
        myTestGala.setPrice(75.00);
        assertEquals(75.00, myTestGala.getPrice().get());
    }

    @Test
    void setNumTicketsTest() {
        Gala myTestGala = new Gala("Party", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(500), new ArrayList<VIP>());
        myTestGala.setNumTickets(1000);
        assertEquals(1000, myTestGala.getNumTickets().get());
    }
}
