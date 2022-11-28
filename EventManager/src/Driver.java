import EventFactory.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class Driver {
    public static void main(String args[]){
        EventManagement BobsEventManager = new EventManagement();

        // create VIPs
        VIP kimK = new VIP("Kim Kardashian", Optional.of("Skims"));
        VIP andrewGarfield = new VIP("Andrew Garfield", Optional.empty());
        VIP ceoOfVEMO = new VIP("rando", Optional.of("VEMO"));
        VIP mileyCyrus = new VIP("Miley Cyrus", Optional.empty());

        // Create a concert
        ArrayList<VIP> vips = new ArrayList<>();
        vips.add(kimK); vips.add(andrewGarfield); vips.add(ceoOfVEMO);
        BobsEventManager.addConcertEvent("Billy Eilish", Optional.of(Location.BellCentre), LocalDate.of(2022, 7, 8), Optional.of(250.00), Optional.of(1500), "Billie Eilish", vips);

        // create a gala
        vips.add(mileyCyrus);
        BobsEventManager.addGalaEvent("Billie Eilish After Party", Optional.of(Location.PlaceDesArts), LocalDate.of(2022,7,9), Optional.of(300.00), Optional.of(100), vips);

        // create a screening
        BobsEventManager.addScreeningEvent("Billie Eilish Documentary", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 7, 10), Optional.of(50.00), Optional.of(200), Rating.R);

        // create a workshop (no prereqs)
        BobsEventManager.addWorkshopEvent("How to Sing with Billie Eilish 1", Optional.of(Location.OlympicStadium), LocalDate.of(2022, 7, 11), Optional.of(700.00), Optional.of(10), new ArrayList<Workshop>());
        ArrayList<Workshop> prereqs = new ArrayList<>();
        prereqs.add((Workshop)BobsEventManager.getHostedEvents().get(3));
        BobsEventManager.addWorkshopEvent("How to sing with Billie Eilish 2", Optional.of(Location.OlympicStadium), LocalDate.of(2022, 7, 12), Optional.of(600.00), Optional.of(6), prereqs);

        // create a festival
        ArrayList<Event> festEvents = BobsEventManager.getHostedEvents();
        BobsEventManager.addFestivalEvent("Billie Eilish Fest", festEvents);

        // create a coming soon concert
        BobsEventManager.addConcertEvent("Coming soon", Optional.empty(), LocalDate.of(2022, 8, 19), Optional.empty(), Optional.empty(), "Kanye", new ArrayList<>());

        System.out.println("Filtering events for Place Des Arts Events...");
        ByLocationFilter pdaFilter = new ByLocationFilter(Location.PlaceDesArts);
        FilterResult pdaEvents = BobsEventManager.filterEvents(pdaFilter, BobsEventManager.getHostedEvents());
        Calculator c = new Calculator(70, 90, 80, 70);
        System.out.println("Calculating expected profit for Place Des Arts (expecting $31,000): $" + pdaEvents.expectedProfit(c));
        System.out.println("Calculating number of VIPS attending events at Place Des Arts (expecting 4): " + pdaEvents.totalNumVIPs());

        System.out.println();

        System.out.println("Filtering events for events less than $300...");
        ByPriceFilter cheapFilter = new ByPriceFilter(0, 299.00);
        FilterResult cheapEvents = BobsEventManager.filterEvents(cheapFilter, BobsEventManager.getHostedEvents());
        System.out.println("Calculating expected profit for events under $300 (expecting $269500): $" + cheapEvents.expectedProfit(c));
        System.out.println("Calculating number of VIPs for events under $300 (expecting 3): " + cheapEvents.totalNumVIPs());

        System.out.println();

        System.out.println("Filtering events for events under $650 at the Olympic Stadium...");
        ByPriceFilter p650Filter = new ByPriceFilter(0, 650.00);
        ByLocationFilter lOSFilter = new ByLocationFilter(Location.OlympicStadium);
        ArrayList<AbstractFilter> filters = new ArrayList<>();
        filters.add(p650Filter); filters.add(lOSFilter);
        CompositeFilter cf = new CompositeFilter(filters);
        FilterResult osFilter = BobsEventManager.filterEvents(cf, BobsEventManager.getHostedEvents());
        System.out.println("Calculating expected profit for events under $650 at the Olympic Stadium (expecting $3240): $" + osFilter.expectedProfit(c));
        System.out.println("Calculating number of VIPs for events under $650 at the Olympic Stadium (expecting 0): " + osFilter.totalNumVIPs());

        System.out.println();

        // Try to add an event to a day and location with an event already
        BobsEventManager.addConcertEvent("GVF", Optional.of(Location.BellCentre), LocalDate.of(2022, 7, 8), Optional.of(250.00), Optional.of(1500), "Greta Van Fleet", new ArrayList<>());

        ArrayList<Event> eventsWFestival = BobsEventManager.getHostedEvents();
        BobsEventManager.addFestivalEvent("Festival Containing Festival", eventsWFestival);
    }
}
