import java.util.Enumeration;

public class FootballTeam extends Team {
  private static final int GOALKEEPER_POSITION = 1;
  private static final int DEFENDER_POSITION = 2;
  private static final int MIDFIELDER_POSITION = 3;
  private static final int FORWARD_POSITION = 4;

  public FootballTeam(String teamID) {
    super(teamID);
  }

  public void updatePlayerPosition() {
    System.out.print("Position (1 = goal keeper | 2 = defender | 3 = midfielder | 4 = forward):- ");
  };

  public void displayTeam() {
    Enumeration<Player> playerEnumeration = super.getAllPlayers();
    String goalkeeper, defender, midfielder, forward;
    int goalkeeperIndex = 0, defenderIndex = 0, midfielderIndex = 0, forwardIndex = 0;
    goalkeeper = "Goal keeper:\n";
    defender = "Defender:\n";
    midfielder = "Midfielder: \n";
    forward = "Forward: \n";

    while (playerEnumeration.hasMoreElements()) {
      Player player = playerEnumeration.nextElement();

      if (player.getPosition() == 1) {
        goalkeeper += player.getPlayerID() + ", " + player.getName() + "\n";
        goalkeeperIndex++;
      } else if (player.getPosition() == 2) {
        defender += player.getPlayerID() + ", " + player.getName() + "\n";
        defenderIndex++;
      } else if (player.getPosition() == 3) {
        midfielder += player.getPlayerID() + ", " + player.getName() + "\n";
        midfielderIndex++;
      } else {
        forward += player.getPlayerID() + ", " + player.getName() + "\n";
        forwardIndex++;
      }
    }

    if (goalkeeperIndex == 0) {
      goalkeeper += "NIL" + "\n";
    }
    if (defenderIndex == 0) {
      defender += "NIL" + "\n";
    }
    if (midfielderIndex == 0) {
      midfielder += "NIL" + "\n";
    }
    if (forwardIndex == 0) {
      forward += "NIL" + "\n";
    }

    System.out.println("Football Team " + super.getName() + " (" + super.getTeamID() + ") \n" + goalkeeper + defender
        + midfielder + forward);
  }

}
