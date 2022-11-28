package EventFactory;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestScreening {
    //getters tests
    @Test
    void getNameTest() {
        Screening myTestScreening = new Screening("Movie Night", Optional.of(Location.OlympicStadium), LocalDate.of(2022, 7, 4), Optional.of(10.00), Optional.of(100), Rating.G);
        assertEquals("Movie Night", myTestScreening.getName());
    }

    @Test
    void getDateTest() {
        Screening myTestScreening = new Screening("Movie Night", Optional.of(Location.OlympicStadium), LocalDate.of(2022, 7, 4), Optional.of(10.00), Optional.of(100), Rating.G);
        assertEquals(LocalDate.of(2022, 7, 4), myTestScreening.getDate());
    }

    @Test
    void getRatingTest(){
        Screening myTestScreening = new Screening("Movie Night", Optional.of(Location.OlympicStadium), LocalDate.of(2022, 7, 4), Optional.of(10.00), Optional.of(100), Rating.G);
        assertEquals(Rating.G, myTestScreening.getRating());
    }

    @Test
    void getLocationPresentTest() {
        Screening myTestScreening = new Screening("Movie Night", Optional.of(Location.OlympicStadium), LocalDate.of(2022, 7, 4), Optional.of(10.00), Optional.of(100), Rating.G);
        assertEquals(Location.OlympicStadium, myTestScreening.getLocation().get());
    }

    @Test
    void getLocationEmptyTest() {
        Screening myTestScreening = new Screening("Movie Night", Optional.empty(), LocalDate.of(2022, 7, 4), Optional.of(10.00), Optional.of(100), Rating.G);
        assertEquals(Optional.empty(), myTestScreening.getLocation());
    }

    @Test
    void getPricePresentTest() {
        Screening myTestScreening = new Screening("Movie Night", Optional.of(Location.OlympicStadium), LocalDate.of(2022, 7, 4), Optional.of(10.00), Optional.of(100), Rating.G);
        assertEquals(10, myTestScreening.getPrice().get());
    }

    @Test
    void getPriceEmptyTest() {
        Screening myTestScreening = new Screening("Movie Night", Optional.of(Location.OlympicStadium), LocalDate.of(2022, 7, 4), Optional.empty(), Optional.of(100), Rating.G);
        assertEquals(Optional.empty(), myTestScreening.getPrice());
    }

    @Test
    void getNumTicketsPresentTest() {
        Screening myTestScreening = new Screening("Movie Night", Optional.of(Location.OlympicStadium), LocalDate.of(2022, 7, 4), Optional.of(10.00), Optional.of(100), Rating.G);
        assertEquals(100, myTestScreening.getNumTickets().get());
    }

    @Test
    void getNumTicketsEmptyTest() {
        Screening myTestScreening = new Screening("Movie Night", Optional.of(Location.OlympicStadium), LocalDate.of(2022, 7, 4), Optional.of(10.00), Optional.empty(), Rating.G);
        assertEquals(Optional.empty(), myTestScreening.getNumTickets());
    }

    @Test
    void getExpectedProfitTest() {
        Screening myTestScreening = new Screening("Movie Night", Optional.of(Location.OlympicStadium), LocalDate.of(2022, 7, 4), Optional.of(10.00), Optional.of(100), Rating.G);
        Calculator c = new Calculator(0, 0, 70, 100);
        assertEquals(1000, myTestScreening.getExpectedProfit(c));
    }

    @Test
    void getExpectedProfitMissingPriceTest() {
        Screening myTestScreening = new Screening("Movie Night", Optional.of(Location.OlympicStadium), LocalDate.of(2022, 7, 4), Optional.empty(), Optional.of(100), Rating.G);
        Calculator c = new Calculator(20, 0, 70, 100);
        assertEquals(0, myTestScreening.getExpectedProfit(c));
    }

    @Test
    void getExpectedProfitMissingNumTicketsTest() {
        Screening myTestScreening = new Screening("Movie Night", Optional.of(Location.OlympicStadium), LocalDate.of(2022, 7, 4), Optional.of(10.00), Optional.empty(), Rating.G);
        Calculator c = new Calculator(20, 0, 70, 100);
        assertEquals(0, myTestScreening.getExpectedProfit(c));
    }

    @Test
    void getNumVIPsTest(){
        Screening myTestScreening = new Screening("Movie Night", Optional.of(Location.OlympicStadium), LocalDate.of(2022, 7, 4), Optional.of(10.00), Optional.of(100), Rating.G);
        assertEquals(0, myTestScreening.getNumVIPS());
    }

    //setters tests
    @Test
    void setNameTest() {
        Screening myTestScreening = new Screening("Movie Night", Optional.of(Location.OlympicStadium), LocalDate.of(2022, 7, 4), Optional.of(10.00), Optional.of(100), Rating.G);
        myTestScreening.setName("Film Night");
        assertEquals("Film Night", myTestScreening.getName());
    }

    @Test
    void setLocationTest() {
        Screening myTestScreening = new Screening("Movie Night", Optional.of(Location.OlympicStadium), LocalDate.of(2022, 7, 4), Optional.of(10.00), Optional.of(100), Rating.G);
        myTestScreening.setLocation(Location.ParcJeanDrapeau);
        assertEquals(Location.ParcJeanDrapeau, myTestScreening.getLocation().get());
    }

    @Test
    void setDateTest() {
        Screening myTestScreening = new Screening("Movie Night", Optional.of(Location.OlympicStadium), LocalDate.of(2022, 7, 4), Optional.of(10.00), Optional.of(100), Rating.G);
        myTestScreening.setDate(LocalDate.of(2022, 10, 20));
        assertEquals(LocalDate.of(2022, 10, 20), myTestScreening.getDate());
    }

    @Test
    void setPriceTest() {
        Screening myTestScreening = new Screening("Movie Night", Optional.of(Location.OlympicStadium), LocalDate.of(2022, 7, 4), Optional.of(10.00), Optional.of(100), Rating.G);
        myTestScreening.setPrice(75.00);
        assertEquals(75.00, myTestScreening.getPrice().get());
    }

    @Test
    void setNumTicketsTest() {
        Screening myTestScreening = new Screening("Movie Night", Optional.of(Location.OlympicStadium), LocalDate.of(2022, 7, 4), Optional.of(10.00), Optional.of(100), Rating.G);
        myTestScreening.setNumTickets(1000);
        assertEquals(1000, myTestScreening.getNumTickets().get());
    }

    @Test
    void setRatingTest(){
        Screening myTestScreening = new Screening("Movie Night", Optional.of(Location.OlympicStadium), LocalDate.of(2022, 7, 4), Optional.of(10.00), Optional.of(100), Rating.G);
        myTestScreening.setRating(Rating.PG13);
        assertEquals(Rating.PG13, myTestScreening.getRating());
    }
}
