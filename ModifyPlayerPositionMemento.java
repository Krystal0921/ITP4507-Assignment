public class ModifyPlayerPositionMemento {
  Player player;
  private int state;

  public ModifyPlayerPositionMemento(Player player) {
    this.player = player;
    this.state = player.getPosition(); // Store the original position of the player
  }

  public Player getOrig() {
    return player;// Return the original player object
  }

  public void restore() {
    player.setPosition(state); // Restore the original position of the player
  }
}
