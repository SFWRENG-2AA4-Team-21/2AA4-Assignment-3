package test;
import catan.Dice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
public class DiceTest {
    private Dice dice;
    @BeforeEach
   public void setUp(){
       dice = new Dice();
    }
    @Test
    public void testrollandlastroll(){
        assertEquals(dice.roll(),dice.getLastRoll());
    }
    @Test
    public void testDiceisnotnull(){
        assertNotNull(dice);
    }

}
