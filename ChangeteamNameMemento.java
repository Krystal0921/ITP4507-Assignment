public class ChangeteamNameMemento {
  Team team;
  private String state;

  public ChangeteamNameMemento(Team team) {
    this.team = team;
    this.state = team.getName(); // Store the original name of the team
  }

  public Team getOrig() {
    return team;// Return the original team object
  }

  public void restore() {
    team.setName(state); // Restore the original name of the team
  }
}
