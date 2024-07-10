public class ShowTeamCommand implements Command {
  private Team team;

  public ShowTeamCommand(Team currentTeam) {
    this.team = currentTeam;
  }

  public void execute() {
    team.displayTeam();
  }

  @Override
  public void undo() {
  }

  @Override
  public void redo() {
  }

  @Override
  public Team getCurrentTeam() {
    return null;
  }

  @Override
  public void getMessage() {
  };
}