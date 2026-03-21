//implementing command design pattern
//implementation of GameHistory UML into code
package catan;
import java.util.Deque;
import java.util.ArrayDeque;

public class GameHistory {

    private Stack<Command> undoStack = new ArrayDeque<>();
    private Stack<Command> redoStack = new ArrayDeque<>();

    public void executeCommand(Command command) {
        command.execute();
        undoStack.push(command);
        redoStack.clear();

    public void undo() {
        if(!undoStack.isEmpty()) {
            Command command = undoStack.pop();
            command.undo();
            redoStack.push(command);
        }
    }

}
