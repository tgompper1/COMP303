package EventFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
//add setters
public class Concert extends AbstractEvent {
    private String aName; // name of Concert - required
    private Optional<Location> aLocation; // location of concert if assigned yet
    private LocalDate aDate; // date of concert - required
    private Optional<Double> aPrice; // price per ticket for concert if assigned yet
    private Optional<Integer> aNumTickets; // number of tickets for the concert if assigned yet

    private String aArtist; // artist performing at concert -required
    private ArrayList<VIP> aVIPs = new ArrayList<>(); // list of VIPs attending event, can be empty

    //concert constructor, protected so it can only be used by FlyweightEventConstructor
    protected Concert(String pName, Optional<Location> pLocation, LocalDate pDate, Optional<Double> pPrice, Optional<Integer> pNumTickets, String pArtist, ArrayList<VIP> pVIPs){
        super(pName, pLocation, pDate, pPrice, pNumTickets);
        aName = pName;
        aLocation = pLocation;
        aDate = pDate;
        aPrice = pPrice;
        aNumTickets = pNumTickets;
        aArtist = pArtist;
        for(VIP v : pVIPs){
            aVIPs.add(v);
        }
    }

    //getters
    @Override
    public int getNumVIPS() {
        return aVIPs.size();
    }

    public String getArtist(){
        return aArtist;
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
        return ((aPrice.get()*aNumTickets.get())*c.getConcertPercentage())/100;
    }

    // setters
    public void addVIP(VIP pVIP){
        aVIPs.add(pVIP);
    }

    public void removeVIP(VIP pVIP){
        aVIPs.remove(pVIP);
    }

    public void setArtist(String pArtist){
        aArtist = pArtist;
    }

}
