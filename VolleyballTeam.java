import java.util.Enumeration;

public class VolleyballTeam extends Team {
  private static final int ATTACKER_POSITION = 1;
  private static final int DEFENDER_POSITION = 2;

  public VolleyballTeam(String teamID) {
    super(teamID);
  }

  public void updatePlayerPosition() {
    System.out.print("Position (1 = attacker | 2 = defender):- ");
  };

  public void displayTeam() {
    Enumeration<Player> playerEnumeration = super.getAllPlayers();//
    String attackerString, defenderString;
    int attackerIndex = 0, defenderIndex = 0;
    attackerString = "Attacker:\n";
    defenderString = "Defender:\n";

    while (playerEnumeration.hasMoreElements()) {
      Player player = playerEnumeration.nextElement();
      if (player.getPosition() == 1) {
        attackerString += player.getPlayerID() + ", " + player.getName() + "\n";
        attackerIndex++;
      } else {
        defenderString += player.getPlayerID() + "," + player.getName() + "\n";
        defenderIndex++;
      }
    }

    if (attackerIndex == 0) {
      attackerString += "NIL" + "\n";
    }
    if (defenderIndex == 0) {
      defenderString += "NIL" + "\n";
    }

    System.out.println(
        "Volleyball Team " + super.getName() + " (" + super.getTeamID() + ") \n" + attackerString + defenderString);
  }
}
