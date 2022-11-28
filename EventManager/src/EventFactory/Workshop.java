package EventFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class Workshop extends AbstractEvent {
    private String aName; // name of workshop - required
    private Optional<Location> aLocation; // location of workshop if provided
    private LocalDate aDate; // date of workshop - required
    private Optional<Double> aPrice; // price per ticket if provided
    private Optional<Integer> aNumTickets; // number of tickets for workshop if provided

    private final ArrayList<Workshop> aPrerequisites = new ArrayList<>(); // prereqs for the workshop, can be empty

    //prereqs only added if they happen before this workshop
    protected Workshop(String pName, Optional<Location> pLocation, LocalDate pDate, Optional<Double> pPrice, Optional<Integer> pNumTickets, ArrayList<Workshop> pPrerequisites){
        super(pName, pLocation, pDate, pPrice, pNumTickets);
        aName = pName;
        aLocation = pLocation;
        aDate = pDate;
        aPrice = pPrice;
        aNumTickets = pNumTickets;
        for(Workshop w : pPrerequisites){
            if(w.getDate().isBefore(aDate)) {
                aPrerequisites.add(w);
            }
        }
    }

    //getters
    /**
     * @returns price per ticket * number of tickets * percentage provided by calculator
     */
    @Override
    public double getSpecificExpectedProfit(Calculator c) {
        return ((aPrice.get()*aNumTickets.get())*c.getWorkshopPercentage())/100;
    }

    public ArrayList<Workshop> getPrerequisites(){
        ArrayList<Workshop> toReturn = new ArrayList<>();
        for(Workshop w : aPrerequisites){
            if(w.getDate().isBefore(aDate)) {
                toReturn.add(w);
            }
        }
        return toReturn;
    }

    //setters
    public void addPrerequisite(Workshop pPrereq){
        aPrerequisites.add(pPrereq);
    }

    public void removePrerequisite(Workshop pPrereq){
        aPrerequisites.remove(pPrereq);
    }

}
