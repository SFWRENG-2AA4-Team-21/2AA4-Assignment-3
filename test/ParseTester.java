import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ParseTester {

    @Test
    void testRoll(){
        RegexTester r = new RegexTester();
        assertEquals("Dice Rolled", r.parse("Roll"));
    }

    @Test
    void testRollFail(){
        RegexTester r = new RegexTester();
        assertEquals("Failed Result", r.parse("No"));
    }

    @Test
    void testGo(){
        RegexTester r = new RegexTester();
        assertEquals("Movement Enacted\nTurn Ended", r.parse("Go"));
    }

    @Test
    void testGoFail(){
        RegexTester r = new RegexTester();
        assertEquals("Failed Result", r.parse("Gooo"));
    }

    @Test
    void testList(){
        RegexTester r = new RegexTester();
        assertEquals("Here's a list of your cards on hand", r.parse("List"));
    }

    @Test
    void testListFail(){
        RegexTester r = new RegexTester();
        assertEquals("Failed Result", r.parse("list"));
    }

    @Test
    void testBuildSettlement(){
        RegexTester r = new RegexTester();
        assertEquals("Building your card", r.parse("Build settlement 2"));
    }

    @Test
    void testBuildSettlementFail(){
        RegexTester r = new RegexTester();
        assertEquals("Failed Result", r.parse("Build settlement 2,4"));
    }

    @Test
    void testBuildRoad(){
        RegexTester r = new RegexTester();
        assertEquals("Building your card", r.parse("Build road 2,3"));
    }

    @Test
    void testBuildRoadFail(){
        RegexTester r = new RegexTester();
        assertEquals("Failed Result", r.parse("Build road 2-3"));
    }
}