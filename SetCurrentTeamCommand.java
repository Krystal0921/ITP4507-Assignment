import java.util.*;

public class SetCurrentTeamCommand implements Command {
  private List<Team> teamsList;
  private Scanner sc;
  private Team team;
  private Team oldCurrTeam;
  private Team newCurrTeam;

  public SetCurrentTeamCommand(List<Team> teams, Team currentTeam, Scanner sc) {
    this.sc = sc;
    this.teamsList = teams;
    this.oldCurrTeam = currentTeam;
  }

  public void execute() {
    System.out.print("Please input team ID:- ");
    String teamID = sc.next();

    for (Team team : teamsList) {//Loop the teamsList
      if (team.getTeamID().equals(teamID)) {//If the user input TeamID = teamList's TeamID
        newCurrTeam = team;
        this.team = team;
        break;
      } else {
        newCurrTeam = null;
      }
    }

    if (newCurrTeam == null) {
      System.out.println("Team " + teamID + " is not found!!!");
      return;
    }
    System.out.println("Changed current team to " + this.team.getTeamID() + ".");
  }

  @Override
  public void undo() {
    this.team = oldCurrTeam;
  }

  @Override
  public void redo() {
    this.team = newCurrTeam;
  }

  @Override
  public Team getCurrentTeam() {
    return team;
  }

  public void getMessage() {
  }
}
