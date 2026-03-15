// package src-AI;

// import java.util.ArrayList;
// import java.util.List;

// public class Game {
//     private Board board;
//     private List<Player> players;
//     private int currentPlayer;
//     private Dice dice;

//     public Game() {
//         board = new Board();
//         players = new ArrayList<>();
//         dice = new Dice(2);
//         currentPlayer = 0;
//     }

//     public void startGame() {
//         // setup logic
//     }

//     public void nextTurn() {
//         currentPlayer = (currentPlayer + 1) % players.size();
//     }

//     public boolean checkWin() {
//         for (Player p : players) {
//             if (p.getScore() >= 10) return true;
//         }
//         return false;
//     }
// }
