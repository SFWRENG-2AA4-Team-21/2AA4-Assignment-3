package src-AI;

import java.util.Random;

public class Dice {
    private int lastRoll;
    private int numDice;
    private Random rand = new Random();

    public Dice(int numDice) {
        this.numDice = numDice;
    }

    public int roll() {
        lastRoll = 0;
        for (int i = 0; i < numDice; i++) {
            lastRoll += rand.nextInt(6) + 1;
        }
        return lastRoll;
    }

    public int getLastRoll() {
        return lastRoll;
    }
}

