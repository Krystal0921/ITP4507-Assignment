import java.util.*;

public class UndoRedoListCommand implements Command {
  private Stack<Command> undos;
  private Stack<Command> redos;

  public UndoRedoListCommand(Stack<Command> undos, Stack<Command> redos) {
    this.undos = undos;
    this.redos = redos;
  }

  @Override
  public void execute() {
    System.out.println("Undo List");
    for (int i = 0; i < undos.size(); i++) {//Loop the undos stack
      undos.get(i).getMessage();
    }

    System.out.println("-- End of undo list --");

    System.out.println("Redo List");

    for (int i = 0; i < redos.size(); i++) {//Loop the redos stack
      redos.get(i).getMessage();
    }
    System.out.println("-- End of redo list --");
  }

  @Override
  public void redo() {
  }

  @Override
  public Team getCurrentTeam() {
    return null;
  }

  @Override
  public void undo() {
  }

  @Override
  public void getMessage() {
  }
}
