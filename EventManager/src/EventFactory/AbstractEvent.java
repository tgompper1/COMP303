package EventFactory;

import java.time.LocalDate;
import java.util.Optional;

public abstract class AbstractEvent implements Event{
    private String aName; // name of Concert - required
    private Optional<Location> aLocation; // location of concert if assigned yet
    private LocalDate aDate; // date of concert - required
    private Optional<Double> aPrice; // price per ticket for concert if assigned yet
    private Optional<Integer> aNumTickets; // number of tickets for the concert if assigned yet

    public AbstractEvent(String pName, Optional<Location> pLocation, LocalDate pDate, Optional<Double> pPrice, Optional<Integer> pNumTickets){
        aName = pName;
        aLocation = pLocation;
        aDate = pDate;
        aPrice = pPrice;
        aNumTickets = pNumTickets;
    }

    @Override
    public String getName() {
        return aName;
    }

    @Override
    public Optional<Location> getLocation() {
        return aLocation;
    }

    @Override
    public LocalDate getDate() {
        return aDate;
    }

    @Override
    public Optional<Double> getPrice() {
        return aPrice;
    }

    @Override
    public Optional<Integer> getNumTickets() {
        return aNumTickets;
    }

    /**
     * @returns price per ticket * number of tickets * percentage provided by calculator
     */
    @Override
    public double getExpectedProfit(Calculator c) {
        if(aPrice.isEmpty() || aNumTickets.isEmpty()){
            return 0;
        }
        return getSpecificExpectedProfit(c);
    }

    public abstract double getSpecificExpectedProfit(Calculator c);

    @Override
    public int getNumVIPS() {
        return 0;
    }

    @Override
    public void setName(String pName){
        aName = pName;
    }

    @Override
    public void setLocation(Location pLocation){
        aLocation = Optional.of(pLocation);
    }

    @Override
    public void setDate(LocalDate pDate){
        aDate = pDate;
    }

    @Override
    public void setPrice(double pPrice){
        aPrice = Optional.of(pPrice);
    }

    @Override
    public void setNumTickets(int pNumTickets){
        aNumTickets = Optional.of(pNumTickets);
    }
}
