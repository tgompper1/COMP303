package EventFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestFlyweightEventConstructor {
    FlyweightEventConstructor constructor;

    @BeforeEach
    void reset(){
        constructor = new FlyweightEventConstructor();
    }

    //18 tests
    @Test
    void createConcertSafeTest() {
        Optional<Concert> c = constructor.createConcert("Safe Concert", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(55.00), Optional.of(100), "GVF", new ArrayList<VIP>());
        if(c.isEmpty()){
            fail();
        }
    }

    @Test
    void createConcertUnsafeTest(){
        Optional<Concert> c = constructor.createConcert("Safe Concert", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(55.00), Optional.of(100), "GVF", new ArrayList<VIP>());
        Optional<Concert> c2 = constructor.createConcert("unSafe Concert", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(55.00), Optional.of(100), "GVF", new ArrayList<VIP>());
        if(c2.isPresent()){
            fail();
        }
    }

    @Test
    void createConcertComingSoonTest(){
        Optional<Concert> c = constructor.createConcert("Safe Concert", Optional.empty(), LocalDate.of(2022, 5, 12), Optional.empty(), Optional.empty(), "GVF", new ArrayList<VIP>());
        if(c.isEmpty()){
            fail();
        }
    }

    @Test
    void createGalaSafeTest(){
        Optional<Gala> g = constructor.createGala("Safe Gala", Optional.of(Location.BellCentre), LocalDate.of(2022, 7, 8), Optional.of(45.00), Optional.of(200), new ArrayList<VIP>());
        if(g.isEmpty()){
            fail();
        }
    }

    @Test
    void createGalaUnsafeTest(){
        Optional<Gala> g = constructor.createGala("Safe Gala", Optional.of(Location.BellCentre), LocalDate.of(2022, 7, 8), Optional.of(45.00), Optional.of(200), new ArrayList<VIP>());
        Optional<Gala> g2 = constructor.createGala("UnSafe Gala", Optional.of(Location.BellCentre), LocalDate.of(2022, 7, 8), Optional.of(45.00), Optional.of(200), new ArrayList<VIP>());
        if(g2.isPresent()){
            fail();
        }
    }

    @Test
    void createGalaComingSoonTest(){
        Optional<Gala> g = constructor.createGala("Safe Gala", Optional.empty(), LocalDate.of(2022, 7, 8), Optional.empty(), Optional.empty(), new ArrayList<VIP>());
        if(g.isEmpty()){
            fail();
        }
    }

    @Test
    void createScreeningSafeTest(){
        Optional<Screening> s = constructor.createScreening("Safe screening", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 7, 3), Optional.of(60.00), Optional.of(200), Rating.R);
        if(s.isEmpty()){
            fail();
        }
    }

    @Test
    void createScreeningUnsafeTest(){
        Optional<Screening> s = constructor.createScreening("Safe screening", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 7, 3), Optional.of(60.00), Optional.of(200), Rating.R);
        Optional<Screening> s2 = constructor.createScreening("UnSafe screening", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 7, 3), Optional.of(60.00), Optional.of(200), Rating.R);
        if(s2.isPresent()){
            fail();
        }
    }

    @Test
    void createScreeningComingSoonTest(){
        Optional<Screening> s = constructor.createScreening("Safe screening", Optional.empty(), LocalDate.of(2022, 7, 3), Optional.empty(), Optional.empty(), Rating.R);
        if(s.isEmpty()){
            fail();
        }
    }

    @Test
    void createWorkshopSafeTest(){
        Optional<Workshop> w = constructor.createWorkshop("Safe Workshop", Optional.of(Location.BellCentre), LocalDate.of(2022, 7, 7), Optional.of(67.00), Optional.of(200), new ArrayList<Workshop>());
        if(w.isEmpty()){
            fail();
        }
    }

    @Test
    void createWorkshopUnsafeTest(){
        Optional<Workshop> w = constructor.createWorkshop("Safe Workshop", Optional.of(Location.BellCentre), LocalDate.of(2022, 7, 7), Optional.of(67.00), Optional.of(200), new ArrayList<Workshop>());
        Optional<Workshop> w2 = constructor.createWorkshop("UnSafe Workshop", Optional.of(Location.BellCentre), LocalDate.of(2022, 7, 7), Optional.of(67.00), Optional.of(200), new ArrayList<Workshop>());
        if(w2.isPresent()){
            fail();
        }
    }

    @Test
    void createWorkshopComingSoonTest(){
        Optional<Workshop> w = constructor.createWorkshop("Safe Workshop", Optional.empty(), LocalDate.of(2022, 7, 7), Optional.empty(), Optional.empty(), new ArrayList<Workshop>());
        if(w.isEmpty()){
            fail();
        }
    }

    @Test
    void createFestivalTest(){
        Screening myTestScreening = new Screening("Screening", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 7, 1), Optional.of(10.00), Optional.of(100), Rating.G);
        Gala myTestGala = new Gala("Movie", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 7, 3), Optional.of(3.00), Optional.of(500), new ArrayList<VIP>());
        Concert myTestConcert = new Concert("Concert", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 7, 4), Optional.of(55.00), Optional.of(200), "Stromae", new ArrayList<VIP>());
        Workshop myTestWorkshop = new Workshop("Workshop", Optional.of(Location.PlaceDesArts), LocalDate.of(2022, 7, 5), Optional.of(25.00), Optional.of(25), new ArrayList<Workshop>());
        ArrayList<Event> events = new ArrayList<>();
        events.add(myTestConcert); events.add(myTestGala); events.add(myTestWorkshop); events.add(myTestScreening);

        Optional<Festival> f = constructor.createFestival("Festival", events);
        if(f.isEmpty()){
            fail();
        }
    }

    @Test
    void changeLocationSafeTest(){
        Optional<Workshop> w = constructor.createWorkshop("Safe Workshop", Optional.of(Location.BellCentre), LocalDate.of(2022, 7, 7), Optional.of(67.00), Optional.of(200), new ArrayList<Workshop>());
        Optional<Workshop> w2 = constructor.createWorkshop("UnSafe Workshop", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 7, 7), Optional.of(67.00), Optional.of(200), new ArrayList<Workshop>());
        constructor.changeLocation(w.get(), Location.PlaceDesArts);
        assertEquals(Location.PlaceDesArts, w.get().getLocation().get());
    }

    @Test
    void changeLocationUnsafeTest(){
        Optional<Workshop> w = constructor.createWorkshop("Safe Workshop", Optional.of(Location.BellCentre), LocalDate.of(2022, 7, 7), Optional.of(67.00), Optional.of(200), new ArrayList<Workshop>());
        Optional<Workshop> w2 = constructor.createWorkshop("UnSafe Workshop", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 7, 7), Optional.of(67.00), Optional.of(200), new ArrayList<Workshop>());
        constructor.changeLocation(w.get(), Location.ParcJeanDrapeau);
        assertEquals(Location.BellCentre, w.get().getLocation().get());
    }

    @Test
    void changeDateSafeTest(){
        Optional<Workshop> w = constructor.createWorkshop("Safe Workshop", Optional.of(Location.BellCentre), LocalDate.of(2022, 7, 7), Optional.of(67.00), Optional.of(200), new ArrayList<Workshop>());
        Optional<Workshop> w2 = constructor.createWorkshop("UnSafe Workshop", Optional.of(Location.BellCentre), LocalDate.of(2022, 7, 8), Optional.of(67.00), Optional.of(200), new ArrayList<Workshop>());
        constructor.changeDate(w.get(), LocalDate.of(2022, 7, 9));
        assertEquals(LocalDate.of(2022, 7, 9), w.get().getDate());
    }

    @Test
    void changeDateUnsafeTest(){
        Optional<Workshop> w = constructor.createWorkshop("Safe Workshop", Optional.of(Location.BellCentre), LocalDate.of(2022, 7, 7), Optional.of(67.00), Optional.of(200), new ArrayList<Workshop>());
        Optional<Workshop> w2 = constructor.createWorkshop("UnSafe Workshop", Optional.of(Location.BellCentre), LocalDate.of(2022, 7, 8), Optional.of(67.00), Optional.of(200), new ArrayList<Workshop>());
        constructor.changeDate(w.get(), LocalDate.of(2022, 7, 8));
        assertEquals(LocalDate.of(2022, 7, 7), w.get().getDate());
    }

    @Test
    void changeDateNoLocationTest(){
        Optional<Workshop> w = constructor.createWorkshop("Safe Workshop", Optional.empty(), LocalDate.of(2022, 7, 7), Optional.of(67.00), Optional.of(200), new ArrayList<Workshop>());
        Optional<Workshop> w2 = constructor.createWorkshop("UnSafe Workshop", Optional.of(Location.BellCentre), LocalDate.of(2022, 7, 8), Optional.of(67.00), Optional.of(200), new ArrayList<Workshop>());
        constructor.changeDate(w.get(), LocalDate.of(2022, 7, 9));
        assertEquals(LocalDate.of(2022, 7, 9), w.get().getDate());
    }

    @Test
    void checkSafeTestFalseWithReflection() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Optional<Concert> c = constructor.createConcert("Safe Concert", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(55.00), Optional.of(100), "GVF", new ArrayList<VIP>());
        Optional<Concert> c2 = constructor.createConcert("Safe Concert2", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 13), Optional.of(55.00), Optional.of(100), "GVF", new ArrayList<VIP>());
        Method privateCheckSafe = FlyweightEventConstructor.class.getDeclaredMethod("checkSafe", Location.class, LocalDate.class);
        privateCheckSafe.setAccessible(true);
        assertEquals(false, privateCheckSafe.invoke(constructor, Location.ParcJeanDrapeau, LocalDate.of(2022, 5, 13)));
    }

    @Test
    void checkSafeTestTrueWithReflection() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Optional<Concert> c = constructor.createConcert("Safe Concert", Optional.of(Location.ParcJeanDrapeau), LocalDate.of(2022, 5, 12), Optional.of(55.00), Optional.of(100), "GVF", new ArrayList<VIP>());
        Method privateCheckSafe = FlyweightEventConstructor.class.getDeclaredMethod("checkSafe", Location.class, LocalDate.class);
        privateCheckSafe.setAccessible(true);
        assertEquals(true, privateCheckSafe.invoke(constructor, Location.ParcJeanDrapeau, LocalDate.of(2022, 5, 13)));
    }
}
