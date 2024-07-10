import java.util.*;

public class AddPlayerCommand implements Command {
  private Scanner sc;
  private Team team;
  private Player player;
  private int index;
  private String message;

  public AddPlayerCommand(Team currentTeam, Scanner sc) {
    this.sc = sc;
    this.team = currentTeam;
  }

  public void execute() {
    PlayerFactory playerFactory = new PlayerFactory(); // Create PlayerFactory object
    Player Player = playerFactory.addPlayer(team, sc);// create a new player
    team.addPlayer(Player); // Add the player to the team
    index = team.players.size() - 1; // Set the player index of team list
    this.player = Player;
    System.out.println("Player is added.");
    String positionName;

    // Determine the position name based on the player's position
    if (team instanceof VolleyballTeam) {
      positionName = (Player.getPosition() == 1) ? "attacker" : "defender";
    } else {
      if (Player.getPosition() == 1) {
        positionName = "goal keeper";
      } else if (Player.getPosition() == 2) {
        positionName = "defender";
      } else if (Player.getPosition() == 3) {
        positionName = "midfielder ";
      } else {
        positionName = "forward ";
      }
    }
    message = "Add player," + Player.getPlayerID() + "," + Player.getName() + ", " + positionName;// Create the message for the command
  }

  @Override
 
  public void undo() {
    team.players.remove(player);  // Remove the player from the team
    System.out.println("Command (" + message + ") is undone.");
  }

  @Override
  public void redo() {
    team.players.insertElementAt(player, index); // Insert the player back into the team at the original index
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
