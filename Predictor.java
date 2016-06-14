import java.util.Scanner;

public class Predictor {

  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    Tourney Euro2016 = new Tourney();
    Euro2016.createTeams();
    Euro2016.createGroups();
    Group[] groups = Euro2016.getGroups();
    for (int i = 0; i < 6; i += 1) {
      for (int j = 0; j < 6; j += 1) {
        Match match = groups[i].getMatches()[j];
        Team A = match.getTeams()[0];
        Team B = match.getTeams()[1];
        System.out.println("This match is between " + A.toString() + " and " + B.toString());
        System.out.print("Enter the score for " + A.toString() + ": ");
        int aScore = reader.nextInt();
        System.out.print("Enter the score for " + B.toString() + ": ");
        int bScore = reader.nextInt();
        match.setScore(aScore, bScore);
        System.out.println();
      }
    }
    Euro2016.setPlayGroups();
    Euro2016.qualifyTeams();
    //Euro2016.playRoundOf16();
    //Euro2016.playQuarterFinals();
    //Euro2016.playSemiFinals();
    //Euro2016.playThirdPlaceMatch();
    //Euro2016.playFinal();
  }

}
