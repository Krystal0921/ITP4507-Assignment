public interface Command {

  abstract public void execute();

  abstract public void undo();

  abstract public void redo();

  abstract public Team getCurrentTeam();

  abstract public void getMessage();
}
