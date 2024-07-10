import java.util.*;

public class ModifyPlayersPositionCommand implements Command {
  private ModifyPlayerPositionMemento undomemento;
  private ModifyPlayerPositionMemento redomemento;
  private Scanner sc;
  private Team team;
  private String message;

  public ModifyPlayersPositionCommand(Team currentTeam, Scanner sc) {
    this.sc = sc;
    this.team = currentTeam;
  }

  public void execute() {
    System.out.print("Please input player ID:- ");
    String playerID = sc.next();
    int position;

    team.updatePlayerPosition();
    position = sc.nextInt();

    Enumeration<Player> playerEnumeration = team.getAllPlayers();
    Player foundPlayer = null;

    
    while (playerEnumeration.hasMoreElements()) {//Loop all player of the team
      Player player = playerEnumeration.nextElement();
      if (player.getPlayerID().equals(playerID)) {// Find the player with the specified ID
        foundPlayer = player;
      }
    }
    if (foundPlayer != null) {
      undomemento = new ModifyPlayerPositionMemento(foundPlayer); //Create memento with the current state of the player's position
      foundPlayer.setPosition(position);//Set the player position
      System.out.println("Position is updated.");
    } else {
      System.out.println("Player not found.");
    }

    String positionName;
    if (team instanceof VolleyballTeam) {//Find the player position name
      positionName = (foundPlayer.getPosition() == 1) ? "attacker" : "defender";
    } else {
      if (foundPlayer.getPosition() == 1) {
        positionName = "goal keeper";
      } else if (foundPlayer.getPosition() == 2) {
        positionName = "defender";
      } else if (foundPlayer.getPosition() == 3) {
        positionName = "midfielder ";
      } else {
        positionName = "forward ";
      }
    }
    message = "Modify player’s position," + foundPlayer.getPlayerID() + ", " + positionName;
  }

  @Override
  public void undo() {
    redomemento = new ModifyPlayerPositionMemento(undomemento.getOrig());//Create memento with the current state of the player's position before undoing
    undomemento.restore();  // Restore the player's position to its previous state
    System.out.println("Command (" + message + ") is undone.");
  }

  @Override
  public void redo() {
    redomemento.restore(); // Restore the player's position to the state captured by the redo memento
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