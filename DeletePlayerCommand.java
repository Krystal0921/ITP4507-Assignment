import java.util.*;

public class DeletePlayerCommand implements Command {
  private Scanner sc;
  private Team team;
  private Player player;
  private String message;
  private int index;

  public DeletePlayerCommand(Team currentTeam, Scanner sc) {
    this.sc = sc;
    this.team = currentTeam;
  }

  public void execute() {
    System.out.print("Please input player ID:- ");
    String playerID = sc.next();

    Enumeration<Player> playerEnumeration = team.getAllPlayers();
    Player foundPlayer = null;

    while (playerEnumeration.hasMoreElements()) {//Loop the player of the team
      Player player = playerEnumeration.nextElement();
      if (player.getPlayerID().equals(playerID)) {//Find the player with the specified ID
        foundPlayer = player;
        this.player = foundPlayer;
        break;
      }
      index++;
    }

    if (foundPlayer != null) {
      team.remove(foundPlayer);// Remove the found player from the team
      System.out.println("Player is deleted.");
    } else {
      System.out.println("Player not found.");
    }
    message = "Delete player," + foundPlayer.getPlayerID();// Create the message for the command
  }

  @Override
  public void undo() {
    team.players.insertElementAt(player, index);// Insert the player back into the team at the original index
    System.out.println("Command (" + message + ") is undone.");
  }

  @Override
  public void redo() {
    team.players.remove(player);//Remove the player
    System.out.println("Command (" + message + ") is redone.");
  }

  @Override
  public Team getCurrentTeam() {
    return null;
  }

  public void getMessage() {
    System.out.println(message);
  }
}
