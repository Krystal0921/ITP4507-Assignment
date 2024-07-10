import java.util.*;

public class Assignment {
  public static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    List<Team> teams = new ArrayList<Team>(); // Create team list
    Team currentTeam = null;
    Stack<Command> undos = new Stack(); //Create undo stack
    Stack<Command> redos = new Stack(); //Create redo stack
    String command;

    while (true) {
      System.out.println("\nSport Teams Management System (STMS)\n");
      System.out.println(
          "c = create team, g = set current team, a = add player, m = modify player’s position, d = delete player,\ns = show team, p = display all teams, t = change team’s name, u = undo, r = redo, l = list undo/redo, x = exit system");
      if (currentTeam != null) {
        System.out.println("\nThe current team is " + currentTeam.getTeamID() + " " + currentTeam.getName() + ".");
      }
      System.out.print("Please enter command [ c | g | a | m | d | s | p | t | u | r | l | x ] :-");

      command = sc.next();
      Command com = createCommand(command, undos, teams, currentTeam, redos, sc);

      switch (command) {
        case "c":
        case "a":
        case "d":
        case "t":
        case "m":
          redos.clear();  // Clear redo stack if a new command is executed after undo
        case "g":
          undos.push(com);  // Push the command to the undo stack
      }
      if (com != null) {
        com.execute();

        if (com.getCurrentTeam() != null){ // Get current team 
          currentTeam = com.getCurrentTeam();
      }
      System.out.println("------------------------------------------------------");
    }
  }
  }
  public static Command createCommand(String command, Stack<Command> undos, List<Team> teams, Team currentTeam,
      Stack<Command> redos, Scanner sc) {
    Command com;
    switch (command) {
      case "c":
        com = new CreateTeamCommand(teams, currentTeam, sc);
        break;
      case "g":
        com = new SetCurrentTeamCommand(teams, currentTeam, sc);
        break;
      case "a":
        com = new AddPlayerCommand(currentTeam, sc);
        break;
      case "m":
        com = new ModifyPlayersPositionCommand(currentTeam, sc);
        break;
      case "d":
        com = new DeletePlayerCommand(currentTeam, sc);
        break;
      case "s":
        com = new ShowTeamCommand(currentTeam);
        break;
      case "p":
        com = new DisplayAllTeamCommand(teams, currentTeam);
        break;
      case "t":
        com = new ChangeTeamsNameCommand(currentTeam, sc);
        break;
      case "u":
        com = new UndoCommand(redos, undos);
        break;
      case "r":
        com = new RedoCommand(redos, undos);
        break;
      case "l":
        com = new UndoRedoListCommand(undos, redos);
        break;
      case "x":
        System.exit(0);
      default:
        com = null;
    }
    return com;
  }
}
