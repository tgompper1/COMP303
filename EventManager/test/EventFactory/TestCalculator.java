package EventFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestCalculator {
    Calculator testCalculator;

    @BeforeEach
    void setUp(){
        testCalculator = new Calculator(10, 20, 30, 40);
    }

    @Test
    void getConcertPercentage() {
        assertEquals(10, testCalculator.getConcertPercentage());
    }

    @Test
    void getWorkshopPercentage() {
        assertEquals(20, testCalculator.getWorkshopPercentage());
    }

    @Test
    void getGalaPercentage() {
        assertEquals(30, testCalculator.getGalaPercentage());
    }

    @Test
    void getScreeningPercentage() {
        assertEquals(40, testCalculator.getScreeningPercentage());
    }

    @Test
    void getDefaultConcertPercentage() {
        Calculator c = new Calculator();
        assertEquals(50, c.getConcertPercentage());
    }

    @Test
    void getDefaultWorkshopPercentage() {
        Calculator c = new Calculator();
        assertEquals(50, c.getWorkshopPercentage());
    }

    @Test
    void getDefaultGalaPercentage() {
        Calculator c = new Calculator();
        assertEquals(50, c.getGalaPercentage());
    }

    @Test
    void getDefaultScreeningPercentage() {
        Calculator c = new Calculator();
        assertEquals(50, c.getScreeningPercentage());
    }

    @Test
    void setConcertPercentage() {
        testCalculator.setConcertPercentage(75);
        assertEquals(75, testCalculator.getConcertPercentage());
    }

    @Test
    void setWorkshopPercentage() {
        testCalculator.setWorkshopPercentage(80);
        assertEquals(80, testCalculator.getWorkshopPercentage());
    }

    @Test
    void setGalaPercentage() {
        testCalculator.setGalaPercentage(45);
        assertEquals(45, testCalculator.getGalaPercentage());
    }

    @Test
    void setScreeningPercentage() {
        testCalculator.setScreeningPercentage(80);
        assertEquals(80, testCalculator.getScreeningPercentage());
    }
}