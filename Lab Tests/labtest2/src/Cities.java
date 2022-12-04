import java.util.ArrayList;

public class Cities {
    ArrayList<City> cities = new ArrayList<>();

    public void addCity(City city){
        for(City c : cities){
            if(c.getName().equals(city)){
                return;
            }
        }
        cities.add(city);
    }

    public void getCities(){
        for(City c : cities){
            System.out.println(c.getName());
        }
    }

}
