import java.util.Scanner;

public class TeamFactory {
    public static Team createTeam(String type, Scanner sc) {
        Team t;
        System.out.print("Team ID:- ");
        String id = sc.next();
        System.out.print("Team Name:-");
        String name = sc.next();

        if (type.equals("v")) {
            t = new VolleyballTeam(id);// Create a VolleyballTeam object
            System.out.println("Volleyball team is created.");
        } else {
            t = new FootballTeam(id); // Create a FootballTeam object
            System.out.println("Football team is created.");
        }
        t.setName(name);// Set the name of the team
        return t;
    }
}
