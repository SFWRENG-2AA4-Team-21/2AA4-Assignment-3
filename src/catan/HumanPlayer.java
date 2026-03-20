

package catan;
import java.util.Scanner;
import java.util.Map;
import java.util.logging.Logger;

public class HumanPlayer extends Player {
    Scanner scanner = new Scanner(System.in);
    RegexTester r = new RegexTester();
    private static final Logger LOGGER = Logger.getLogger(HumanPlayer.class.getName());
    public HumanPlayer(int playerID){
        super(playerID);

    }

    public void showResources(){

        LOGGER.info("YOUR RESOURCES ARE");
        for (Map.Entry<String, Integer> entry : resources.entrySet()) {
            String resource = entry.getKey();
            int amount = entry.getValue();
            LOGGER.info(String.format("%s: %d", resource, amount));
        }
    }
    public int askForaction(){
        LOGGER.info("Choose action:");
        LOGGER.info("Build Settlement");
        LOGGER.info("Build Road");
        LOGGER.info("Pass");


        String action = scanner.nextLine();
        return r.parse(action);

    }
    public int askForLoc(){
        LOGGER.info("Choose a node (1-6): ");
        return scanner.nextInt();
    }
}




