import java.util.*;

public class RedoCommand implements Command {
  Stack<Command> undos;
  Stack<Command> redos;
  private Team currentTeam;

  public RedoCommand(Stack<Command> redos, Stack<Command> undos) {
    this.redos = redos;
    this.undos = undos;
  }

  public void execute() {
    if (!redos.isEmpty()) { 
      if (redos.elementAt(0) instanceof SetCurrentTeamCommand) {// If the next redo command is SetCurrentTeamCommand, execute it and push it to undos stack
        Command com = (Command) redos.pop(); // Execute the next redo command 
        com.redo();
        undos.push(com);//Push it to undos stack
        currentTeam = com.getCurrentTeam();//Get the current team
      }
      if (!redos.isEmpty()) {
        Command com = (Command) redos.pop();
        com.redo();
        undos.push(com);
        currentTeam = com.getCurrentTeam();
      }
    } else {
      System.out.println("Nothing to redo!");
    }
  }

  @Override
  public void undo() {
  }

  @Override
  public void redo() {
  }

  @Override
  public Team getCurrentTeam() {
    return currentTeam;
  }

  public void getMessage() {
  };
}