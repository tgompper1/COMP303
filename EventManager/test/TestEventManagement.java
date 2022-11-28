import EventFactory.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestEventManagement {
    EventManagement manager;
    @BeforeEach
    void setUp(){
        manager = new EventManagement();
    }

    @Test
    void addConcertSuccessTest(){
        manager.addConcertEvent("Stromae", Optional.of(Location.BellCentre), LocalDate.of(2022, 9, 20), Optional.of(55.00), Optional.of(200), "Stromae", new ArrayList<VIP>());
        assertEquals(1, manager.getHostedEvents().size());
    }

    @Test
    void addConcertMissingNameTest(){
        try{
            manager.addConcertEvent(null, Optional.of(Location.BellCentre), LocalDate.of(2022, 9, 20), Optional.of(55.00), Optional.of(200), "Stromae", new ArrayList<VIP>());
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void addConcertMissingDateTest(){
        try{
            manager.addConcertEvent("Stromae", Optional.of(Location.BellCentre), null, Optional.of(55.00), Optional.of(200), "Stromae", new ArrayList<VIP>());
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void addConcertIllegalDateTest(){
        try{
            manager.addConcertEvent("Stromae", Optional.of(Location.BellCentre), LocalDate.now(), Optional.of(55.00), Optional.of(200), "Stromae", new ArrayList<VIP>());
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void addConcertMissingArtistTest(){
        try{
            manager.addConcertEvent("Stromae", Optional.of(Location.BellCentre), LocalDate.of(2022, 9, 20), Optional.of(55.00), Optional.of(200), null, new ArrayList<VIP>());
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void addConcertMissingVIPsTest(){
        try{
            manager.addConcertEvent("c1", Optional.of(Location.BellCentre), LocalDate.of(2022, 9, 20), Optional.of(55.00), Optional.of(200), "Stromae", null);
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void addConcertInvalidPriceTest(){
        try{
            manager.addConcertEvent("c1", Optional.of(Location.BellCentre), LocalDate.of(2022, 9, 20), Optional.of(-2.00), Optional.of(200), "Stromae", new ArrayList<VIP>());
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void addConcertInvalidNumTicketsTest(){
        try{
            manager.addConcertEvent("c1", Optional.of(Location.BellCentre), LocalDate.of(2022, 9, 20), Optional.of(55.00), Optional.of(0), "Stromae", new ArrayList<VIP>());
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void addScreeningSuccessTest(){
        manager.addScreeningEvent("Movie Night", Optional.of(Location.OlympicStadium), LocalDate.of(2022, 7, 4), Optional.of(10.00), Optional.of(100), Rating.G);
        assertEquals(1, manager.getHostedEvents().size());
    }

    @Test
    void addScreeningMissingNameTest(){
        try{
            manager.addScreeningEvent(null, Optional.of(Location.OlympicStadium), LocalDate.of(2022, 7, 4), Optional.of(10.00), Optional.of(100), Rating.G);
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void addScreeningMissingDateTest(){
        try{
            manager.addScreeningEvent("Movie Night", Optional.of(Location.OlympicStadium), null, Optional.of(10.00), Optional.of(100), Rating.G);
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void addScreeningIllegalDateTest(){
        try{
            manager.addScreeningEvent("Movie Night", Optional.of(Location.OlympicStadium), LocalDate.now(), Optional.of(10.00), Optional.of(100), Rating.G);
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void addScreeningMissingRatingTest(){
        try{
            manager.addScreeningEvent("Movie Night", Optional.of(Location.OlympicStadium), LocalDate.of(2022, 7, 4), Optional.of(10.00), Optional.of(100), null);
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void addScreeningInvalidPriceTest(){
        try{
            manager.addScreeningEvent("Movie Night", Optional.of(Location.OlympicStadium), LocalDate.of(2022, 7, 4), Optional.of(-10.00), Optional.of(100), Rating.G);
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void addScreeningInvalidNumTicketsTest(){
        try{
            manager.addScreeningEvent("Movie Night", Optional.of(Location.OlympicStadium), LocalDate.of(2022, 7, 4), Optional.of(10.00), Optional.of(0), Rating.G);
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void addGalaSuccessTest(){
        manager.addGalaEvent("Party", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(500), new ArrayList<VIP>());
        assertEquals(1, manager.getHostedEvents().size());
    }

    @Test
    void addGalaMissingNameTest(){
        try{
            manager.addGalaEvent(null, Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(500), new ArrayList<VIP>());
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void addGalaMissingDateTest(){
        try{
            manager.addGalaEvent("Party", Optional.of(Location.PlaceDesArts), null, Optional.of(3.00), Optional.of(500), new ArrayList<VIP>());
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void addGalaIllegalDateTest(){
        try{
            manager.addGalaEvent("Party", Optional.of(Location.PlaceDesArts), LocalDate.now(), Optional.of(3.00), Optional.of(500), new ArrayList<VIP>());
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void addGalaMissingVIPsTest(){
        try{
            manager.addGalaEvent("Party", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(500), null);
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void addGalaInvalidPriceTest(){
        try{
            manager.addGalaEvent("Party", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 5, 3), Optional.of(-3.00), Optional.of(500), new ArrayList<VIP>());
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void addGalaInvalidNumTicketsTest(){
        try{
            manager.addGalaEvent("Party", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(0), new ArrayList<VIP>());
            fail();
        }catch(AssertionError e){};
    }


    @Test
    void addWorkshopSuccessTest(){
        manager.addWorkshopEvent("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        assertEquals(1, manager.getHostedEvents().size());
    }

    @Test
    void addWorkshopMissingNameTest(){
        try{
            manager.addWorkshopEvent(null, Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void addWorkshopMissingDateTest(){
        try{
            manager.addWorkshopEvent("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), null, Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void addWorkshopIllegalDateTest(){
        try{
            manager.addWorkshopEvent("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.now(), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void addWorkshopMissingPrereqsTest(){
        try{
            manager.addWorkshopEvent("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), null);
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void addWorkshopInvalidPriceTest(){
        try{
            manager.addWorkshopEvent("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(-25.00), Optional.of(25), new ArrayList<Workshop>());
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void addWorkshopInvalidNumTicketsTest(){
        try{
            manager.addWorkshopEvent("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(-25), new ArrayList<Workshop>());
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void addFestivalSuccessTest(){
        manager.addWorkshopEvent("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        ArrayList<Event> e = manager.getHostedEvents();
        manager.addFestivalEvent("Festival", e);
        assertEquals(2, manager.getHostedEvents().size());
    }

    @Test
    void addFestivalMissingNameTest(){
        manager.addWorkshopEvent("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        ArrayList<Event> ev = manager.getHostedEvents();
        try{
            manager.addFestivalEvent(null, ev);
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void addFestivalMissingEventsTest(){
        try{
            manager.addFestivalEvent("Festival", null);
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void addFestivalInvalidEventsTest(){
        try{
            manager.addFestivalEvent("Festival", new ArrayList<Event>());
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void getHostedEventsTest(){
        manager.addWorkshopEvent("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        manager.addGalaEvent("Party", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(500), new ArrayList<VIP>());
        manager.addConcertEvent("Stromae", Optional.of(Location.BellCentre), LocalDate.of(2022, 9, 20), Optional.of(55.00), Optional.of(200), "Stromae", new ArrayList<VIP>());

        assertEquals(3, manager.getHostedEvents().size());
    }

    @Test
    void getEventNameTest(){
        manager.addGalaEvent("Party", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(500), new ArrayList<VIP>());
        assertEquals("Party", manager.getEventName(manager.getHostedEvents().get(0)));
    }

    @Test
    void getEventNameNullTest(){
        manager.addGalaEvent("Party", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(500), new ArrayList<VIP>());
        try{
            manager.getEventName(null);
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void getEventDateTest(){
        manager.addGalaEvent("Party", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(500), new ArrayList<VIP>());
        assertEquals(LocalDate.of(2022, 5, 3), manager.getEventDate(manager.getHostedEvents().get(0)));
    }

    @Test
    void getEventDateNullTest(){
        manager.addGalaEvent("Party", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(500), new ArrayList<VIP>());
        try{
            manager.getEventDate(null);
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void getEventLocationTest(){
        manager.addGalaEvent("Party", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(500), new ArrayList<VIP>());
        assertEquals(Location.PlaceDesArts, manager.getEventLocation(manager.getHostedEvents().get(0)));
    }

    @Test
    void getEventNullLocationTest(){
        manager.addGalaEvent("Party", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(500), new ArrayList<VIP>());
        try{
            manager.getEventLocation(null);
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void getEventEmptyLocationTest(){
        manager.addGalaEvent("Party", Optional.empty(), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(500), new ArrayList<VIP>());
        try{
            manager.getEventLocation(manager.getHostedEvents().get(0));
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void getEventTicketPriceTest(){
        manager.addGalaEvent("Party", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(500), new ArrayList<VIP>());
        assertEquals(3, manager.getEventTicketPrice(manager.getHostedEvents().get(0)));
    }

    @Test
    void getEventNullTicketPriceTest(){
        manager.addGalaEvent("Party", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(500), new ArrayList<VIP>());
        try{
            manager.getEventTicketPrice(null);
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void getEventDateEmptyTicketPriceTest(){
        manager.addGalaEvent("Party", Optional.empty(), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(500), new ArrayList<VIP>());
        try{
            manager.getEventTicketPrice(manager.getHostedEvents().get(0));
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void getEventNumTicketsTest(){
        manager.addGalaEvent("Party", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(500), new ArrayList<VIP>());
        assertEquals(500, manager.getEventNumTickets(manager.getHostedEvents().get(0)));
    }

    @Test
    void getEventNullNumTicketsTest(){
        manager.addGalaEvent("Party", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(500), new ArrayList<VIP>());
        try{
            manager.getEventNumTickets(null);
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void getEventEmptyNumTicketsTest(){
        manager.addGalaEvent("Party", Optional.empty(), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(500), new ArrayList<VIP>());
        try{
            manager.getEventNumTickets(manager.getHostedEvents().get(0));
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void getEventVIPListConcertTest(){
        VIP dummy = new VIP("name", Optional.of("company"));
        ArrayList<VIP> vips = new ArrayList<>();
        vips.add(dummy);
        manager.addConcertEvent("Stromae", Optional.of(Location.BellCentre), LocalDate.of(2022, 9, 20), Optional.of(55.00), Optional.of(200), "Stromae", vips);
        assertEquals(vips, manager.getEventVIPList(manager.getHostedEvents().get(0)));
    }
    @Test
    void getEventVIPListGalaTest(){
        VIP dummy = new VIP("name", Optional.of("company"));
        ArrayList<VIP> vips = new ArrayList<>();
        vips.add(dummy);
        manager.addGalaEvent("Party", Optional.empty(), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(500), vips);
        assertEquals(vips, manager.getEventVIPList(manager.getHostedEvents().get(0)));
    }
    @Test
    void getEventVIPsNullTicketsTest(){
        manager.addGalaEvent("Party", Optional.empty(), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(500), new ArrayList<VIP>());
        try{
            manager.getEventVIPList(manager.getHostedEvents().get(0));
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void getEventVIPListWorkshopTest(){
        manager.addWorkshopEvent("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        try{
            manager.getEventVIPList(manager.getHostedEvents().get(0));
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void getConcertArtistTest(){
        manager.addConcertEvent("Stromae", Optional.of(Location.BellCentre), LocalDate.of(2022, 9, 20), Optional.of(55.00), Optional.of(200), "Stromae", new ArrayList<>());
        assertEquals("Stromae", manager.getConcertArtist((Concert)manager.getHostedEvents().get(0)));
    }

    @Test
    void getConcertArtistNullTest(){
        try{
            manager.getConcertArtist(null);
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void getFestivalEventsTest(){
        manager.addWorkshopEvent("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        ArrayList<Event> e = manager.getHostedEvents();
        manager.addFestivalEvent("Festival", e);
        assertEquals(e, manager.getFestivalEvents((Festival)manager.getHostedEvents().get(1)));
    }

    @Test
    void getFestivalEventsNullTest(){
        try{
            manager.getFestivalEvents(null);
            fail();
        }catch(AssertionError e){};
    }

    @Test
    void getScreeningRatingTest(){
        manager.addScreeningEvent("Movie Night", Optional.of(Location.OlympicStadium), LocalDate.of(2022, 7, 4), Optional.of(10.00), Optional.of(100), Rating.G);
        assertEquals(Rating.G, manager.getScreeningRating((Screening)manager.getHostedEvents().get(0)));
    }

    @Test
    void getScreeningRatingNullTest(){
        try{
            manager.getScreeningRating(null);
            fail();
        }catch(AssertionError e){}
    }

    @Test
    void getWorkshopPrerequisitesTest(){
        manager.addWorkshopEvent("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        ArrayList<Workshop> prereqs =new ArrayList<>();
        prereqs.add((Workshop)manager.getHostedEvents().get(0));
        manager.addWorkshopEvent("Learn to Knit2", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 13), Optional.of(25.00), Optional.of(25), prereqs);
        assertEquals(prereqs, manager.getWorkshopPrerequisites((Workshop)manager.getHostedEvents().get(1)));
    }

    @Test
    void getWorkshopPrequisitesNullTest(){
        try{
            manager.getWorkshopPrerequisites(null);
            fail();
        }catch(AssertionError e){}
    }

    @Test
    void setEventLocationTest(){
        manager.addWorkshopEvent("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        manager.setEventLocation(manager.getHostedEvents().get(0), Location.PlaceDesArts );
        assertEquals(Location.PlaceDesArts, manager.getEventLocation(manager.getHostedEvents().get(0)));
    }

    @Test
    void setEventLocationNullETest(){
        try{
            manager.setEventLocation(null, Location.ParcJeanDrapeau);
            fail();
        }catch(AssertionError e){}
    }

    @Test
    void setEventLocationNullLTest(){
        try{
            manager.addWorkshopEvent("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
            manager.setEventLocation(manager.getHostedEvents().get(0), null);
            fail();
        }catch(AssertionError e){}
    }


    @Test
    void setEventDateTest(){
        manager.addWorkshopEvent("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        manager.setEventDate(manager.getHostedEvents().get(0), LocalDate.of(2023, 4, 7) );
        assertEquals(LocalDate.of(2023, 4, 7), manager.getEventDate(manager.getHostedEvents().get(0)));
    }

    @Test
    void setEventDateNullETest(){
        try{
            manager.setEventDate(null, LocalDate.of(2023, 4, 7));
            fail();
        }catch(AssertionError e){}
    }

    @Test
    void setEventDateInvalidDateTest(){
        try{
            manager.addWorkshopEvent("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
            manager.setEventDate(manager.getHostedEvents().get(0), LocalDate.now());
            fail();
        }catch(AssertionError e){}
    }

    @Test
    void setEventNameTest(){
        manager.addWorkshopEvent("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        manager.setEventName(manager.getHostedEvents().get(0), "Learn To Knit2");
        assertEquals("Learn To Knit2", manager.getEventName(manager.getHostedEvents().get(0)));
    }

    @Test
    void setEventNameNullETest(){
        try{
            manager.setEventName(null, "2");
            fail();
        }catch(AssertionError e){}
    }

    @Test
    void setEventNameNullNameTest(){
        try{
            manager.addWorkshopEvent("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
            manager.setEventName(manager.getHostedEvents().get(0), null);
            fail();
        }catch(AssertionError e){}
    }

    @Test
    void setEventPriceTest(){
        manager.addWorkshopEvent("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        manager.setEventPrice(manager.getHostedEvents().get(0), 80.00);
        assertEquals(80.00, manager.getEventTicketPrice(manager.getHostedEvents().get(0)));
    }

    @Test
    void setEventPriceNullETest(){
        try{
            manager.setEventPrice(null, 20.00);
            fail();
        }catch(AssertionError e){}
    }

    @Test
    void setEventPriceInvalidPriceTest(){
        try{
            manager.addWorkshopEvent("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
            manager.setEventPrice(manager.getHostedEvents().get(0), -50.00);
            fail();
        }catch(AssertionError e){}
    }

    @Test
    void setEventNumTicketsTest(){
        manager.addWorkshopEvent("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        manager.setEventNumTickets(manager.getHostedEvents().get(0), 50);
        assertEquals(50, manager.getEventNumTickets(manager.getHostedEvents().get(0)));
    }

    @Test
    void setEventNumTicketsNullETest(){
        try{
            manager.setEventNumTickets(null, 20);
            fail();
        }catch(AssertionError e){}
    }

    @Test
    void setEventNumTicketsInvalidNumTest(){
        try{
            manager.addWorkshopEvent("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
            manager.setEventNumTickets(manager.getHostedEvents().get(0), -50);
            fail();
        }catch(AssertionError e){}
    }

    @Test
    void addVIPtoConcertTest(){
        manager.addConcertEvent("Stromae", Optional.of(Location.BellCentre), LocalDate.of(2022, 9, 20), Optional.of(55.00), Optional.of(200), "Stromae", new ArrayList<VIP>());
        VIP v = new VIP("name", Optional.of("Company"));
        ArrayList<VIP> vips= new ArrayList<>();
        vips.add(v);
        manager.addVIPtoEvent(manager.getHostedEvents().get(0), v );
        assertEquals(vips, manager.getEventVIPList(manager.getHostedEvents().get(0)));
    }

    @Test
    void addVIPtoGalaTest(){
        manager.addGalaEvent("Party", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(500), new ArrayList<VIP>());
        VIP v = new VIP("name", Optional.of("Company"));
        ArrayList<VIP> vips= new ArrayList<>();
        vips.add(v);
        manager.addVIPtoEvent(manager.getHostedEvents().get(0), v );
        assertEquals(vips, manager.getEventVIPList(manager.getHostedEvents().get(0)));
    }

    @Test
    void addNullVIPtoEventTest(){
        try{
            manager.addConcertEvent("Stromae", Optional.of(Location.BellCentre), LocalDate.of(2022, 9, 20), Optional.of(55.00), Optional.of(200), "Stromae", new ArrayList<VIP>());
            manager.addVIPtoEvent(manager.getHostedEvents().get(0), null );
            fail();
        }catch(AssertionError e){}
    }

    @Test
    void addVIPtoWorkshopTest(){
        manager.addWorkshopEvent("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        try{
            manager.addVIPtoEvent(manager.getHostedEvents().get(0), new VIP("name", Optional.of("Company")));
            fail();
        }catch(AssertionError e){}
    }

    @Test
    void removeVIPFromConcertTest(){
        VIP v = new VIP("name", Optional.of("Company"));
        ArrayList<VIP> vips= new ArrayList<>();
        vips.add(v);
        manager.addConcertEvent("Stromae", Optional.of(Location.BellCentre), LocalDate.of(2022, 9, 20), Optional.of(55.00), Optional.of(200), "Stromae", vips);
        manager.removeVIPFromEvent(manager.getHostedEvents().get(0), v );
        vips.remove(v);
        assertEquals(vips, manager.getEventVIPList(manager.getHostedEvents().get(0)));
    }

    @Test
    void removeVIPFromGalaTest(){
        VIP v = new VIP("name", Optional.of("Company"));
        ArrayList<VIP> vips= new ArrayList<>();
        vips.add(v);
        manager.addGalaEvent("Party", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 5, 3), Optional.of(3.00), Optional.of(500), new ArrayList<VIP>());
        manager.removeVIPFromEvent(manager.getHostedEvents().get(0), v );
        vips.remove(v);
        assertEquals(vips, manager.getEventVIPList(manager.getHostedEvents().get(0)));
    }

    @Test
    void removeNullVIPFromEventTest(){
        try{
            manager.addConcertEvent("Stromae", Optional.of(Location.BellCentre), LocalDate.of(2022, 9, 20), Optional.of(55.00), Optional.of(200), "Stromae", new ArrayList<VIP>());
            manager.removeVIPFromEvent(manager.getHostedEvents().get(0), null );
            fail();
        }catch(AssertionError e){}
    }

    @Test
    void removeVIPtoWorkshopTest(){
        manager.addWorkshopEvent("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        try{
            manager.removeVIPFromEvent(manager.getHostedEvents().get(0), new VIP("name", Optional.of("Company")));
            fail();
        }catch(AssertionError e){}
    }

    @Test
    void setConcertArtistTest(){
        manager.addConcertEvent("Stromae", Optional.of(Location.BellCentre), LocalDate.of(2022, 9, 20), Optional.of(55.00), Optional.of(200), "Stromae", new ArrayList<>());
        manager.setConcertArtist((Concert)manager.getHostedEvents().get(0), "New artist");
        assertEquals("New artist", manager.getConcertArtist((Concert)manager.getHostedEvents().get(0)));
    }

    @Test
    void setConcertArtistNullETest(){
        try{
            manager.setConcertArtist(null, "your mom");
            fail();
        }catch(AssertionError e){}
    }

    @Test
    void setConcertArtistNullATest(){
        try{
            manager.addConcertEvent("Stromae", Optional.of(Location.BellCentre), LocalDate.of(2022, 9, 20), Optional.of(55.00), Optional.of(200), "Stromae", new ArrayList<>());
            manager.setConcertArtist((Concert)manager.getHostedEvents().get(0), null);
            fail();
        }catch(AssertionError e){}
    }

    @Test
    void setScreeningRatingTest(){
        manager.addScreeningEvent("Movie Night", Optional.of(Location.OlympicStadium), LocalDate.of(2022, 7, 4), Optional.of(10.00), Optional.of(100), Rating.G);
        manager.setScreeningRating((Screening)manager.getHostedEvents().get(0), Rating.R);
        assertEquals(Rating.R, manager.getScreeningRating((Screening)manager.getHostedEvents().get(0)));
    }

    @Test
    void setScreeningRatingNullETest(){
        try{
            manager.setScreeningRating(null, Rating.R);
            fail();
        }catch(AssertionError e){}
    }

    @Test
    void setScreeningRatingNullRTest(){
        try{
            manager.addScreeningEvent("Movie Night", Optional.of(Location.OlympicStadium), LocalDate.of(2022, 7, 4), Optional.of(10.00), Optional.of(100), Rating.G);
            manager.setScreeningRating((Screening)manager.getHostedEvents().get(0), null);
            fail();
        }catch(AssertionError e){}
    }

    @Test
    void addWorkshopPrereqTest(){
        manager.addWorkshopEvent("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        Workshop prereq = (Workshop) manager.getHostedEvents().get(0);
        ArrayList<Workshop> pr = new ArrayList<>();
        pr.add(prereq);
        manager.addWorkshopEvent("Learn to Knit2", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 13), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        manager.addWorkshopPrereq((Workshop)manager.getHostedEvents().get(1), prereq);
        assertEquals(pr, manager.getWorkshopPrerequisites((Workshop)manager.getHostedEvents().get(1)));
    }

    @Test
    void addWorkshopPrereqNullWTest(){
        manager.addWorkshopEvent("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        Workshop prereq = (Workshop) manager.getHostedEvents().get(0);
        try{
            manager.addWorkshopPrereq(null, prereq);
            fail();
        }catch (AssertionError e){}
    }

    @Test
    void addWorkshopPrereqNullPTest(){
        manager.addWorkshopEvent("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        try{
            manager.addWorkshopPrereq((Workshop)manager.getHostedEvents().get(0), null);
        }catch(AssertionError e){}
    }

    @Test
    void addWorkshopPrereqInvalidTest(){
        manager.addWorkshopEvent("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 14), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        Workshop prereq = (Workshop) manager.getHostedEvents().get(0);
        manager.addWorkshopEvent("Learn to Knit2", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 13), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        try{
            manager.addWorkshopPrereq((Workshop)manager.getHostedEvents().get(1), prereq);
            fail();
        }catch(AssertionError e){}
    }

    @Test
    void removeWorkshopPrereqTest(){
        manager.addWorkshopEvent("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        Workshop prereq = (Workshop) manager.getHostedEvents().get(0);
        ArrayList<Workshop> pr = new ArrayList<>();
        pr.add(prereq);
        manager.addWorkshopEvent("Learn to Knit2", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 13), Optional.of(25.00), Optional.of(25), pr);
        pr.remove(prereq);
        manager.removeWorkshopPrereq((Workshop)manager.getHostedEvents().get(1), prereq);
        assertEquals(pr, manager.getWorkshopPrerequisites((Workshop)manager.getHostedEvents().get(1)));
    }

    @Test
    void removeWorkshopPrereqNullWTest(){
        manager.addWorkshopEvent("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        Workshop prereq = (Workshop) manager.getHostedEvents().get(0);
        try{
            manager.removeWorkshopPrereq(null, prereq);
            fail();
        }catch (AssertionError e){}
    }


    @Test
    void removeWorkshopPrereqInvalidTest(){
        manager.addWorkshopEvent("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 14), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        Workshop prereq = (Workshop) manager.getHostedEvents().get(0);
        manager.addWorkshopEvent("Learn to Knit2", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 13), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        try{
            manager.removeWorkshopPrereq((Workshop)manager.getHostedEvents().get(1), prereq);
            fail();
        }catch(AssertionError e){}
    }

    @Test
    void filterEventsTest(){
        manager.addWorkshopEvent("Learn to Knit", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 14), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        manager.addWorkshopEvent("Learn to Knit", Optional.of(Location.OlympicStadium), LocalDate.of(2022, 5, 14), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        ArrayList<Event> goal = new ArrayList<>();
        goal.add(manager.getHostedEvents().get(0));
        FilterResult fr = manager.filterEvents(new ByLocationFilter(Location.ParcJeanDrapeau), manager.getHostedEvents());
        assertEquals(goal, fr.getFilteredEvents());
    }

    @Test
    void filterEventNullFilterTest(){
        try {
            FilterResult fr = manager.filterEvents(null, manager.getHostedEvents());
            fail();
        }catch(AssertionError e){}
    }

    @Test
    void filterEventEmptyListTest(){
        ArrayList<Event> ev = new ArrayList<>();
        try {
            FilterResult fr = manager.filterEvents(new ByLocationFilter(Location.ParcJeanDrapeau), ev);
            fail();
        }catch(AssertionError e){}
    }
}
