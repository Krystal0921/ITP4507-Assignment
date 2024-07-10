import java.util.*;

public class DisplayAllTeamCommand implements Command {
  private List<Team> teamsList;
  private Team team;

  public DisplayAllTeamCommand(List<Team> teams, Team currentTeam) {
    this.teamsList = teams;
    this.team = currentTeam;
  }

  public void execute() {
    StringBuilder volleyball = new StringBuilder("Volleyball Team ");
    StringBuilder football = new StringBuilder("Football Team ");

   
    for (Team team : teamsList) {//Loop the team list
      if (team instanceof VolleyballTeam) {
         // Append the volleyball team's name and ID to the volleyball StringBuilder
        volleyball.append(team.getName()).append(" (").append(team.getTeamID()).append(") ");
      } else {
          // Append the football team's name and ID to the football StringBuilder
        football.append(team.getName()).append(" (").append(team.getTeamID()).append(") ");
      }
    }
    System.out.println(volleyball + "\n" + football);
  }

  @Override
  public void undo() {
  }

  @Override
  public void redo() {
  }

  @Override
  public Team getCurrentTeam() {
    return team;
  }

  @Override
  public void getMessage() {
  }
}
