import java.util.*;

public class ChangeTeamsNameCommand implements Command {

  private ChangeteamNameMemento undomemento; 
  private ChangeteamNameMemento redomemento;
  private Scanner sc;
  private Team team;
  private String message;

  public ChangeTeamsNameCommand( Team currentTeam, Scanner sc) {
    this.sc = sc;
    this.team = currentTeam;
  }

  public void execute() {
    undomemento = new ChangeteamNameMemento(team);// Create a memento with the current state of the team's name
    System.out.print("Please input new name of the current team:");
    String teamName = sc.next();
    team.setName(teamName);// Set the team's name

    System.out.println("Team’s name is updated.");

    message = "Change team’s name," + team.getTeamID() + ", " + teamName;
  }

  @Override
  public void undo() {
    redomemento = new ChangeteamNameMemento(undomemento.getOrig());//Create memento with the current state of the team's name before undoing
    undomemento.restore();// Restore the team's name to its previous state
    System.out.println("Command (" + message + ") is undone.");
  }

  @Override
  public void redo() {
    redomemento.restore();// Restore the team's name to the state captured by the redo memento
    System.out.println("Command (" + message + ") is redone.");
  }

  @Override
  public Team getCurrentTeam() {
    return team;
  }

  public void getMessage() {
    System.out.println(message);
  }
}