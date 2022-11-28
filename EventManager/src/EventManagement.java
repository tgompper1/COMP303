import EventFactory.*;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
Controller to manage events hosted on EventBrite.
 */
public class EventManagement {
    private List<Event> aHostedEvents = new ArrayList<Event>(); // list of all hosted events created by Bob
    private final FlyweightEventConstructor myEventConstructor = new FlyweightEventConstructor();

    public EventManagement(){};

    // event creators
    /**
     * method to host a new Concert event
     *      creates a new Concert event if time and location is available, otherwise
     *      no event is created or added to aHostedEvents
     * @param pName
     * @param pLocation
     * @param pDate
     * @param pPrice
     * @param pNumTickets
     * @param pArtist
     * @param pVIPs
     * @pre pName != null && (pDate !=null && pDate.isAfter(LocalDate.now())) && pArtist != null && pVIPs != null
     *       && (pPrice.isEmpty() || pPrice.get() >=0) && (pNumTickets.isEmpty() || pNumTickets.get() > 0)
     */
    public void addConcertEvent(String pName, Optional<Location> pLocation, LocalDate pDate, Optional<Double> pPrice, Optional<Integer> pNumTickets, String pArtist, ArrayList<VIP> pVIPs){
        assert pName != null && (pDate !=null && pDate.isAfter(LocalDate.now())) && pArtist != null && pVIPs != null
                    && (pPrice.isEmpty() || pPrice.get() >=0) && (pNumTickets.isEmpty() || pNumTickets.get() > 0);
        Optional<Concert> toAdd = myEventConstructor.createConcert(pName, pLocation, pDate, pPrice, pNumTickets, pArtist, pVIPs);
        if(toAdd.isPresent()){
            aHostedEvents.add(toAdd.get());
        }
    }

    /**
     * method to host a new Gala event
     *      creates a new Gala event if time and location is available, otherwise
     *       no event is created or added to aHostedEvents
     * @param pName
     * @param pLocation
     * @param pDate
     * @param pPrice
     * @param pNumTickets
     * @param pVIPs
     * @pre pName != null && (pDate !=null && pDate.isAfter(LocalDate.now())) && pVIPs != null
     *      && (pPrice.isEmpty() || pPrice.get() >=0) && (pNumTickets.isEmpty() || pNumTickets.get() > 0)
     */
    public void addGalaEvent(String pName, Optional<Location> pLocation, LocalDate pDate, Optional<Double> pPrice, Optional<Integer> pNumTickets, ArrayList<VIP> pVIPs){
        assert pName != null && (pDate !=null && pDate.isAfter(LocalDate.now())) && pVIPs != null
                && (pPrice.isEmpty() || pPrice.get() >=0) && (pNumTickets.isEmpty() || pNumTickets.get() > 0);
        Optional<Gala> toAdd = myEventConstructor.createGala(pName, pLocation, pDate, pPrice, pNumTickets, pVIPs);
        if(toAdd.isPresent()){
            aHostedEvents.add(toAdd.get());
        }
    }

    /**
     * method to host a new Screening event
     *      creates a new screening event if time and location is available, otherwise
     *      no event is created or added to aHostedEvents
     * @param pName
     * @param pLocation
     * @param pDate
     * @param pPrice
     * @param pNumTickets
     * @param pRating
     * @pre pName != null && (pDate !=null && pDate.isAfter(LocalDate.now())) && pRating != null
     *          && (pPrice.isEmpty() || pPrice.get() >=0) && (pNumTickets.isEmpty() || pNumTickets.get() > 0)
     */
    public void addScreeningEvent(String pName, Optional<Location> pLocation, LocalDate pDate, Optional<Double> pPrice, Optional<Integer> pNumTickets, Rating pRating){
        assert pName != null && (pDate !=null && pDate.isAfter(LocalDate.now())) && pRating != null && (pPrice.isEmpty() || pPrice.get() >=0) && (pNumTickets.isEmpty() || pNumTickets.get() > 0);
        Optional<Screening> toAdd = myEventConstructor.createScreening(pName, pLocation, pDate, pPrice, pNumTickets, pRating);
        if(toAdd.isPresent()){
            aHostedEvents.add(toAdd.get());
        }
    }

    /**
     * Method to host a new Workshop event
     *      creates a new workshop event if time and location is available, otherwise
     *      no event is created or added to aHostedEvents
     * @param pName
     * @param pLocation
     * @param pDate
     * @param pPrice
     * @param pNumTickets
     * @param pPrerequisites
     * @pre pName != null && (pDate !=null && pDate.isAfter(LocalDate.now())) && pPrerequisites != null
     *      && (pPrice.isEmpty() || pPrice.get() >=0) && (pNumTickets.isEmpty() || pNumTickets.get() > 0)
     */
    public void addWorkshopEvent(String pName, Optional<Location> pLocation, LocalDate pDate, Optional<Double> pPrice, Optional<Integer> pNumTickets, ArrayList<Workshop> pPrerequisites){
        assert pName != null && (pDate !=null && pDate.isAfter(LocalDate.now())) && pPrerequisites != null
                && (pPrice.isEmpty() || pPrice.get() >=0) && (pNumTickets.isEmpty() || pNumTickets.get() > 0);
        Optional<Workshop> toAdd = myEventConstructor.createWorkshop(pName, pLocation, pDate, pPrice, pNumTickets, pPrerequisites);
        if(toAdd.isPresent()){
            aHostedEvents.add(toAdd.get());
        }
    }


    /**
     * method to host a new Festival event
     *      creates a new Festival
     * @param pName
     * @param pEvents
     * @pre pName != null && pEvents != null
     */
    public void addFestivalEvent(String pName, ArrayList<Event> pEvents){
        assert pName != null && pEvents != null && pEvents.size()>=1;
        Optional<Festival> toAdd = myEventConstructor.createFestival(pName, pEvents);
        if(toAdd.isPresent()){
            aHostedEvents.add(toAdd.get());
        }
    }


    /**
     * @return copy of aHostedEvents
     */
    public ArrayList<Event> getHostedEvents(){
        ArrayList<Event> copy = new ArrayList<>();
        for(Event e : aHostedEvents){
            copy.add(e);
        }
        return copy;
    }

    /**
     * @param filter
     * @param events
     * @pre filter != null
     * @pre !events.isEmpty();
     * @return FilterResult object filtered by the provided filter
     */
    public FilterResult filterEvents(AbstractFilter filter, ArrayList<Event> events){
        assert filter != null && !events.isEmpty();
        return new FilterResult(filter, events);
    }

    // field getters

    /**
     * @param e
     * @pre e != null
     * @return the name of provided event e
     */
    public String getEventName(Event e){
        assert e != null;
        return e.getName();
    }

    /**
     * @param e
     * @pre e != null
     * @return the date of the provided event
     */
    public LocalDate getEventDate(Event e){
        assert e != null;
        return e.getDate();
    }

    /**
     * @param e
     * @pre e.getLocation.isPresent()
     * @post Location l != Optional.empty()
     * @return the location of the provided event
     */
    public Location getEventLocation(Event e){
        assert e != null&& e.getLocation().isPresent();
        return e.getLocation().get();
    }

    /**
     * @param e
     * @pre e.getPrice.isPresent()
     * @post double price != Optional.empty()
     * @return the ticket price for the provided event
     */
    public double getEventTicketPrice(Event e){
        assert e != null && e.getPrice().isPresent();
        return e.getPrice().get();
    }

    /**
     * @param e
     * @pre e.getNumTickets().isPresent()
     * @post int numTickets != Optional.empty()
     * @return number of tickets for the provided event
     */
    public int getEventNumTickets(Event e){
        assert e!= null && e.getNumTickets().isPresent();
        return e.getNumTickets().get();
    }

    /**
     * @param e
     * @pre p.getClass().equals(Concert.class) || e.getClass().equals(Gala.class))
     * @return ArrayList of VIPs
     */
    public ArrayList<VIP> getEventVIPList(Event e){
        assert e!=null && (e.getClass().equals(Concert.class) || e.getClass().equals(Gala.class));
        if(e.getClass().equals(Concert.class)){
            return ((Concert) e).getVIPs();
        }
        else{
            return ((Gala) e).getVIPs();
        }
    }

    /**
     * @param c
     * @pre c!=null
     * @return Artist performing at concert
     */
    public String getConcertArtist(Concert c){
        assert c != null;
        return c.getArtist();
    }

    /**
     * @param f
     * @pre f != null
     * @return arrayList of events at the festival
     */
    public ArrayList<Event> getFestivalEvents(Festival f){
        assert f != null;
        return f.getEvents();
    }

    /**
     * @param s
     * @pre  s != null
     * @post rating of the screening
     */
    public Rating getScreeningRating(Screening s){
        assert s != null;
        return s.getRating();
    }

    /**
     * @param w
     * @pre w != null
     * @return ArrayList of workshops to be completed before attending w
     */
    public ArrayList<Workshop> getWorkshopPrerequisites(Workshop w){
        assert w != null;
        return w.getPrerequisites();
    }

    //field setters
    /**
     * calls the FlyweightEventConstructor to change the location of
     *      the event if it is safe to do so, otherwise the event remains unchanged
     * @param e
     * @param pLocation
     * @pre e != null && pLocation != null
     */
    public void setEventLocation(Event e, Location pLocation){
        assert e != null && pLocation != null;
        myEventConstructor.changeLocation(e, pLocation);
    }

    /**
     * calls teh FlyweighEventConstructor to change the date of the event
     *      if it is safe to do so, otherwise the event remains unchanged
     * @param e
     * @param pDate
     * @pre e != null && pDate.isAfter(LocalDate.now())
     */
    public void setEventDate(Event e, LocalDate pDate){
        assert e != null && pDate.isAfter(LocalDate.now());
        myEventConstructor.changeDate(e, pDate);
    }

    /**
     * @param e
     * @param pName
     * @post e.getName().equals(pName)
     */
    public void setEventName(Event e, String pName){
        assert e != null && pName != null;
        e.setName(pName);
    }

    /**
     * @param e
     * @param pPrice
     * @pre e != null && pName != null
     * @post e.getPrice() = pPrice
     */
    public void setEventPrice(Event e, Double pPrice){
        assert e != null && pPrice>=0;
        e.setPrice(pPrice);
    }

    /**
     * @param e
     * @param pNumTickets
     * @pre e != null && pNumTickets >0
     * @post e.getNumTickets() = pNumTickets
     */
    public void setEventNumTickets(Event e, int pNumTickets){
        assert e != null && pNumTickets>0;
        e.setNumTickets(pNumTickets);
    }

    /**
     * @param e
     * @param vip
     * @pre (e.getClass().equals(Concert.class) || e.getClass().equals(Gala.class)) && vip != null
     * @post e.getVIPs().contains(vip)
     */
    public void addVIPtoEvent(Event e, VIP vip){
        assert (e.getClass().equals(Concert.class) || e.getClass().equals(Gala.class)) && vip != null;
        if(e.getClass().equals(Concert.class)){
            ((Concert) e).addVIP(vip);
        }
        else if(e.getClass().equals(Gala.class)){
            ((Gala) e).addVIP(vip);
        }
    }

    /**
     * @param e
     * @param vip
     * @pre (e.getClass().equals(Concert.class) || e.getClass().equals(Gala.class)) && vip != null
     * @post !e.getVIPs().contains(vip)
     */
    public void removeVIPFromEvent(Event e, VIP vip){
        assert (e.getClass().equals(Concert.class) || e.getClass().equals(Gala.class)) && vip != null;
        if(e.getClass().equals(Concert.class)){
            ((Concert) e).removeVIP(vip);
        }
        else if(e.getClass().equals(Gala.class)){
            ((Gala) e).removeVIP(vip);
        }
    }

    /**
     * @param c
     * @param artist
     * @pre c!= null && artist != null
     * @post c.getArtist().equals(artist)
     */
    public void setConcertArtist(Concert c, String artist){
        assert c != null && artist != null;
        c.setArtist(artist);
    }

    /**
     * @param s
     * @param r
     * @pre s!=null && r!=null
     * @post s.getRating().equals(r)
     */
    public void setScreeningRating(Screening s, Rating r){
        assert s != null && r != null;
        s.setRating(r);
    }

    /**
     * @param w
     * @param prereq
     * @pre w != null && prereq != null && prereq.getDate().isBefore(w.getDate())
     * @post w.getPrerequisites().contains(prereq)
     */
    public void addWorkshopPrereq(Workshop w, Workshop prereq){
        assert w != null && prereq != null && prereq.getDate().isBefore(w.getDate());
        w.addPrerequisite(prereq);
    }

    /**
     * @param w
     * @param prereq
     * @pre w != null && w.getPrerequisites().contains(prereq)
     * @post !w.getPrerequisites().contains(prereq)
     */
    public void removeWorkshopPrereq(Workshop w, Workshop prereq){
        assert w != null && w.getPrerequisites().contains(prereq);
        w.removePrerequisite(prereq);
    }
}
