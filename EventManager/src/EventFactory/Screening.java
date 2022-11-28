package EventFactory;

import java.time.LocalDate;
import java.util.Optional;

public class Screening extends AbstractEvent {
    private String aName; // name of movie - required
    private Optional<Location> aLocation; // location of screening if provided
    private LocalDate aDate; // date of screening - required
    private Optional<Double> aPrice; // price per ticket if provided
    private Optional<Integer> aNumTickets; // number fo tickets for screening if provided

    private Rating aRating; // rating of movie - required

    protected Screening(String pName, Optional<Location> pLocation, LocalDate pDate, Optional<Double> pPrice, Optional<Integer> pNumTickets, Rating pRating){
        super(pName, pLocation, pDate, pPrice, pNumTickets);
        aName = pName;
        aLocation = pLocation;
        aDate = pDate;
        aPrice = pPrice;
        aNumTickets = pNumTickets;
        aRating = pRating;
    }

    //getters
       /**
     * @returns price per ticket * number of tickets * percentage provided by calculator
     */
    @Override
    public double getSpecificExpectedProfit(Calculator c) {
        return ((aPrice.get()*aNumTickets.get())*c.getScreeningPercentage())/100;
    }

    public Rating getRating(){
        return aRating;
    }


    //setters
    public void setRating(Rating pRating){
        aRating = pRating;
    }

}
