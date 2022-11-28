package EventFactory;

import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class TestVIP {
    @Test
    void getNameTest(){
        VIP testVIP = new VIP("Kim Kardashian", Optional.of("Skims"));
        assertEquals("Kim Kardashian", testVIP.getName());
    }

    @Test
    void getCompanyTest(){
        VIP testVIP = new VIP("Kim Kardashian", Optional.of("Skims"));
        assertEquals("Skims", testVIP.getCompany());
    }

    @Test
    void getCompanyNoneProvidedTest(){
        VIP testVIP = new VIP("Kim Kardashian", Optional.empty());
        assertEquals("Kim Kardashian", testVIP.getCompany());
    }
}
