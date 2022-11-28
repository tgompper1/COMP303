package EventFactory;

import java.time.LocalDate;
import java.util.Optional;

/*
Representation of a type of EventFactory.Event that can exist
 */
public interface Event {
    public String getName();
    public Optional<Location> getLocation();
    public LocalDate getDate();
    public Optional<Double> getPrice();
    public Optional<Integer> getNumTickets();

    public double getExpectedProfit(Calculator c);
    public int getNumVIPS();

    void setName(String pName);
    void setLocation(Location pLocation);
    void setDate(LocalDate pDate);
    void setPrice(double pPrice);
    void setNumTickets(int pNumTickets);
}
