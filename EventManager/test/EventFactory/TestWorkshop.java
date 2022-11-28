package EventFactory;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWorkshop {
    //getters tests
    @Test
    void getNameTest() {
        Workshop myTestWorkshop = new Workshop("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        assertEquals("Learn to Knit", myTestWorkshop.getName());
    }

    @Test
    void getDateTest() {
        Workshop myTestWorkshop = new Workshop("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        assertEquals(LocalDate.of(2022, 5, 12), myTestWorkshop.getDate());
    }

    @Test
    void getLocationPresentTest() {
        Workshop myTestWorkshop = new Workshop("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        assertEquals(Location.ParcJeanDrapeau, myTestWorkshop.getLocation().get());
    }

    @Test
    void getLocationEmptyTest() {
        Workshop myTestWorkshop = new Workshop("Learn to Knit", Optional.empty(), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        assertEquals(Optional.empty(), myTestWorkshop.getLocation());
    }

    @Test
    void getPricePresentTest() {
        Workshop myTestWorkshop = new Workshop("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        assertEquals(25, myTestWorkshop.getPrice().get());
    }

    @Test
    void getPriceEmptyTest() {
        Workshop myTestWorkshop = new Workshop("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.empty(), Optional.of(25), new ArrayList<Workshop>());
        assertEquals(Optional.empty(), myTestWorkshop.getPrice());
    }

    @Test
    void getNumTicketsPresentTest() {
        Workshop myTestWorkshop = new Workshop("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        assertEquals(25, myTestWorkshop.getNumTickets().get());
    }

    @Test
    void getNumTicketsEmptyTest() {
        Workshop myTestWorkshop = new Workshop("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.empty(), new ArrayList<Workshop>());
        assertEquals(Optional.empty(), myTestWorkshop.getNumTickets());
    }

    @Test
    void getExpectedProfitTest() {
        Workshop myTestWorkshop = new Workshop("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        Calculator c = new Calculator(0, 60, 70, 100);
        assertEquals(375, myTestWorkshop.getExpectedProfit(c));
    }

    @Test
    void getExpectedProfitMissingPriceTest() {
        Workshop myTestWorkshop = new Workshop("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.empty(), Optional.of(25), new ArrayList<Workshop>());
        Calculator c = new Calculator(20, 0, 70, 100);
        assertEquals(0, myTestWorkshop.getExpectedProfit(c));
    }

    @Test
    void getExpectedProfitMissingNumTicketsTest() {
        Workshop myTestWorkshop = new Workshop("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.empty(), Optional.of(25), new ArrayList<Workshop>());
        Calculator c = new Calculator(20, 0, 70, 100);
        assertEquals(0, myTestWorkshop.getExpectedProfit(c));
    }

    @Test
    void getNumVIPsTest(){
        Workshop myTestWorkshop = new Workshop("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        assertEquals(0, myTestWorkshop.getNumVIPS());
    }

    @Test
    void getPrerequisitesTest(){
        Workshop workshop1 = new Workshop("pre1", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 9), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        Workshop workshop2 = new Workshop("pre2", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 10), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        Workshop workshop3 = new Workshop("pre3", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 11), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        Workshop workshopFail = new Workshop("pre4", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 13), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        ArrayList<Workshop> prereqs = new ArrayList<>();
        prereqs.add(workshop1); prereqs.add(workshop2); prereqs.add(workshop3); prereqs.add(workshopFail);

        Workshop myTestWorkshop = new Workshop("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), prereqs);
        prereqs.remove(workshopFail);
        assertEquals(prereqs, myTestWorkshop.getPrerequisites());
    }

    //setters tests
    @Test
    void setNameTest() {
        Workshop myTestWorkshop = new Workshop("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        myTestWorkshop.setName("Learn to Knit level 1");
        assertEquals("Learn to Knit level 1", myTestWorkshop.getName());
    }

    @Test
    void setLocationTest() {
        Workshop myTestWorkshop = new Workshop("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        myTestWorkshop.setLocation(Location.OlympicStadium);
        assertEquals(Location.OlympicStadium, myTestWorkshop.getLocation().get());
    }

    @Test
    void setDateTest() {
        Workshop myTestWorkshop = new Workshop("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        myTestWorkshop.setDate(LocalDate.of(2022, 10, 20));
        assertEquals(LocalDate.of(2022, 10, 20), myTestWorkshop.getDate());
    }

    @Test
    void setPriceTest() {
        Workshop myTestWorkshop = new Workshop("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        myTestWorkshop.setPrice(75.00);
        assertEquals(75.00, myTestWorkshop.getPrice().get());
    }

    @Test
    void setNumTicketsTest() {
        Workshop myTestWorkshop = new Workshop("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        myTestWorkshop.setNumTickets(1000);
        assertEquals(1000, myTestWorkshop.getNumTickets().get());
    }

    @Test
    void addPrereqTest(){
        Workshop workshop1 = new Workshop("pre1", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 9), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        ArrayList<Workshop> ws = new ArrayList<>();
        ws.add(workshop1);
        Workshop myTestWorkshop = new Workshop("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        myTestWorkshop.addPrerequisite(workshop1);
        assertEquals(ws, myTestWorkshop.getPrerequisites());
    }

    @Test
    void removePrereqTest(){
        Workshop workshop1 = new Workshop("pre1", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 9), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        Workshop workshop2 = new Workshop("pre2", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 10), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        Workshop workshop3 = new Workshop("pre3", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 11), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        ArrayList<Workshop> prereqs = new ArrayList<>();
        prereqs.add(workshop1); prereqs.add(workshop2); prereqs.add(workshop3);
        Workshop myTestWorkshop = new Workshop("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), prereqs);
        prereqs.remove(workshop2);
        myTestWorkshop.removePrerequisite(workshop2);
        assertEquals(prereqs, myTestWorkshop.getPrerequisites());
    }
}
