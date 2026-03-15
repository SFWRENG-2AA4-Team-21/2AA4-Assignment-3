

package catan;

import java.util.Scanner;

public class HumanPlayer extends Player {
    Scanner scanner = new Scanner(System.in);
    RegexTester r = new RegexTester();

    public HumanPlayer(int playerID){
        super(playerID);

    }

    public void showResources(){
        System.out.println("YOUR RESOURCES ARE");
        for (String resource : resources.keySet()) {
            int amount = resources.get(resource);
            System.out.println(resource + ": " + amount);
        }
    }
    public int askForaction(){
        System.out.println("Choose action:");

        System.out.println("Build Settlement");
        System.out.println("Build Road");
        System.out.println("Pass");


        String action = scanner.nextLine();
        int read_Action = r.parse(action);

        return read_Action;
    }
    public int askForLoc(){
        System.out.println("Choose a node (1-6): ");
        int nodeId = scanner.nextInt();
        return nodeId;
    }
}




