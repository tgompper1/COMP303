import EventFactory.Calculator;
import EventFactory.Event;
import EventFactory.Location;

import java.time.LocalDate;
import java.util.Optional;

public class EventStub implements Event {
    Optional<Double> aPrice;
    Optional<Location> aLocation;

    public EventStub(double pPrice, Location pLocation){
        aPrice = Optional.of(pPrice);
        aLocation = Optional.of(pLocation);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Optional<Location> getLocation() {
        return aLocation;
    }

    @Override
    public LocalDate getDate() {
        return null;
    }

    @Override
    public Optional<Double> getPrice() {
        return aPrice;
    }

    @Override
    public Optional<Integer> getNumTickets() {
        return Optional.empty();
    }

    @Override
    public double getExpectedProfit(Calculator c) {
        return 0;
    }

    @Override
    public int getNumVIPS() {
        return 0;
    }

    @Override
    public void setName(String pName) {

    }

    @Override
    public void setLocation(Location pLocation) {

    }

    @Override
    public void setDate(LocalDate pDate) {

    }

    @Override
    public void setPrice(double pPrice) {

    }

    @Override
    public void setNumTickets(int pNumTickets) {

    }
}