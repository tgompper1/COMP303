package EventFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class Gala extends AbstractEvent {
    private String aName; // name of the gala -required
    private Optional<Location> aLocation; // location of the gala if provided
    private LocalDate aDate; // date of gala- required
    private Optional<Double> aPrice; // price per ticket for gala if provided
    private Optional<Integer> aNumTickets; // number of tickets for gala if provided

    private final ArrayList<VIP> aVIPs = new ArrayList<>(); // vips attending event, can be empty

    protected Gala(String pName, Optional<Location> pLocation, LocalDate pDate, Optional<Double> pPrice, Optional<Integer> pNumTickets, ArrayList<VIP> pVIPs){
        super(pName, pLocation, pDate, pPrice, pNumTickets);
        aName = pName;
        aLocation = pLocation;
        aDate = pDate;
        aPrice = pPrice;
        aNumTickets = pNumTickets;
        for(VIP v : pVIPs){
            aVIPs.add(v);
        }
    }

    //getters
    @Override
    public int getNumVIPS() {
        return aVIPs.size();
    }

    public ArrayList<VIP> getVIPs(){
        ArrayList<VIP> toReturn = new ArrayList<>();
        for(VIP v: aVIPs){
            toReturn.add(v);
        }
        return toReturn;
    }

    @Override
    public double getSpecificExpectedProfit(Calculator c) {
        return ((aPrice.get()*aNumTickets.get())*c.getGalaPercentage())/100;
    }
    //setters
    public void addVIP(VIP pVIP){
        aVIPs.add(pVIP);
    }

    public void removeVIP(VIP pVIP){
        aVIPs.remove(pVIP);
    }

}
