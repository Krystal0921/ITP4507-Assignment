import java.util.*;

public class CreateTeamCommand implements Command {
  private List<Team> teamsList;
  private Scanner sc;
  private String message;
  private Team team;
  private Team oldCurrTeam;
  private Team newCurrTeam;

  public CreateTeamCommand(List<Team> teams, Team currentTeam, Scanner sc) {
    this.sc = sc;
    this.teamsList = teams;
    this.oldCurrTeam = currentTeam;
  }

  public void execute() {
    System.out.print("Enter sport type (v = volleyball | f = football):- ");
    String sportType = sc.next();

    Team team = TeamFactory.createTeam(sportType, sc);// Create a new team using the TeamFactory 
    newCurrTeam = team;
    System.out.println("Current team is changed to " + team.getTeamID() + ".");

    String sportTypeName = "";

    if (sportType.equalsIgnoreCase("v")) {// Determine the sport type name based on the user input
      sportTypeName = "volleyball";
    } else if (sportType.equalsIgnoreCase("f")) {
      sportTypeName = "football";
    }
    message = "Create " + sportTypeName + " team, " + team.getTeamID() + ", " + team.getName();// Create the message for the command

    teamsList.add(team);// Add the new team to the teams list
    this.team = newCurrTeam;//Set the current team
  }

  @Override
  public void undo() {
    teamsList.remove(team);//Remove the team
    this.team = oldCurrTeam;
    System.out.println("Command (" + message + ") is undone.");
  }

  @Override
  public void redo() {
    teamsList.add(newCurrTeam);//Add the team
    this.team = newCurrTeam;
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
