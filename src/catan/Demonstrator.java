package catan;

import java.util.Scanner;
import java.util.logging.Logger;
/**
 * Demonstrates functionality of the Catan simulator.
 */
public class Demonstrator {

    public static void main(String[] args) {
        /**
         * scanner object used to read user input from the command line 
         * Supports requirment R2.1
        */
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getLogger(Demonstrator.class.getName());

        logger.info("choose a mode"); //prompts user to select game mode
        logger.info("1 COMP VS COMP"); //automated simulation of computer players
        logger.info("2 HUMAN VS COMP"); // simulation of human and computer player

        int move=scanner.nextInt(); //reads user input 

        Game game = new Game(move); //new game object based selected game mode
        game.startGame(); //starts the game simulation
    }
}
