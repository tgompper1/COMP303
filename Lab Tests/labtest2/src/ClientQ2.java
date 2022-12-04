public class ClientQ2 {
    public static void main(String args[]){
        City m = new City("Montreal");
        City t = new City("Toronto");
        AirCanada TMS = new AirCanada();
        TMS.cities.addCity(m);
        TMS.cities.addCity(t);
        TMS.cities.addCity(m);
        TMS.cities.getCities();

        TMS.addFlight(234, null, m, t);
        System.out.println(TMS.getFlights(0).getCapacity());
    }

}