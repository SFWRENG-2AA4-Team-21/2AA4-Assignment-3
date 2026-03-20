

package catan;

import java.util.Scanner;

public class HumanPlayer extends Player {
    Scanner scanner = new Scanner(System.in);
    RegexTester r = new RegexTester();

    public HumanPlayer(int playerID){
        super(playerID);

    }

    public void showResources(){
<<<<<<< Updated upstream
        System.out.println("YOUR RESOURCES ARE");
        for (String resource : resources.keySet()) {
            int amount = resources.get(resource);
=======
        logger.info("YOUR RESOURCES ARE");
        for (Map.Entry<String, Integer> entry : resources.entrySet()) {
            String resource = entry.getKey();
            int amount = entry.getValue(resource);
>>>>>>> Stashed changes
            logger.info(resource + ": " + amount);
        }
    }
    public int askForaction(){
        logger.info("Choose action:");

        logger.info("Build Settlement");
        logger.info("Build Road");
        logger.info("Pass");


        String action = scanner.nextLine();
        int readAction = r.parse(action);

        return readAction;
    }
    public int askForLoc(){
        logger.info("Choose a node (1-6): ");
        return scanner.nextInt();
    }
}




