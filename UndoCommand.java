import java.util.*;

public class UndoCommand implements Command {
  Stack <Command> undos;
  Stack <Command> redos;
  private Team currentTeam;

  public UndoCommand(Stack <Command> redos, Stack  <Command>undos) {
    this.undos = undos;
    this.redos = redos;
  }

  public void execute() {
    if (!undos.isEmpty()) {// Check if there are commands in the undos stack
      if (undos.elementAt(undos.size() - 1) instanceof SetCurrentTeamCommand) {  // Check if the topmost command in the undos stack is an instance of SetCurrentTeamCommand
        Command com = (Command) undos.pop(); // Retrieve the command from the stack
        com.undo();// Undo the command
        redos.push(com);// Push the command to the redos stack
        currentTeam = com.getCurrentTeam();// Update the current team with the command's current team
      }
    }
    if (!undos.isEmpty()) {
      Command com = (Command) undos.pop();// Retrieve the command from the stack
      com.undo();// Undo the command
      redos.push(com); // Push the command to the redos stack
      currentTeam = com.getCurrentTeam();// Update the current team with the command's current team
    } else {
      System.out.println("Nothing to undo!");
    }
  }

  @Override
  public void undo() {}

  @Override
  public void redo() {}

  @Override
  public Team getCurrentTeam() {
    return currentTeam;
  }

  public void getMessage(){};
}