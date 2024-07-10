import java.util.*;

public class PlayerFactory {

  public Player addPlayer(Team currentTeam, Scanner sc) {
    System.out.print("Please input player information (id, name):- ");
    sc.nextLine();
    String playerInfo = sc.nextLine();
    String[] playerDetails = playerInfo.split(",", 2);

    String playerId = playerDetails[0];// Extract player ID and name from the input
    String playerName = playerDetails[1];
    int position;

    currentTeam.updatePlayerPosition();  //Ask the user input the position
    position = sc.nextInt();

    Player p = new Player(playerId, playerName);// Create a new Player object 
    p.setPosition(position);
    return p; //return a new player
  }
}
