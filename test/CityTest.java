
import catan.City;
import catan.Building;
import catan.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CityTest {
    private City city;
    @BeforeEach
    void setCity(){
        city = new City(new Player(1));
    }
    @Test
    void cityCorrectVictoryPoints(){
        assertEquals(2, city.getVictoryPoints());
    }
    @Test
    void cityIsNotNull() {

        assertNotNull(city);
    }

}
