import java.util.Scanner;
import java.lang.Integer;
import java.io.IOException;

public class Predictor {

  public static void main(String[] args) {
    try {
    Scanner reader = new Scanner(System.in);
    Tourney Euro2016 = new Tourney();
    Euro2016.createTeams();
    Euro2016.createGroups();
    String FORMAT_LINE = new String(new char[85]).replace("\0", "=");
    Group[] groups = Euro2016.getGroups();
    String file_name = "predict.txt";
    ReadFile fr = new ReadFile(file_name);
    String[] lines = fr.OpenFile();
    int k = 0;
    for (int i = 0; i < 6; i += 1) {
      for (int j = 0; j < 6; j += 1) {
        Match match = groups[i].getMatches()[j];
        Team A = match.getTeams()[0];
        Team B = match.getTeams()[1];
        System.out.println("This match is between " + A.toString() + " and " + B.toString());
        if (args[0].equals("a")) {
          System.out.println("Enter the score for " + A.toString() + ": ");
          int aScore = Integer.parseInt(lines[k]);
          System.out.println("Enter the score for " + B.toString() + ": ");
          int bScore = Integer.parseInt(lines[k + 1]);
          match.setScore(aScore, bScore);
          k += 2;
        } else {
          System.out.print("Enter the score for " + A.toString() + ": ");
          int aScore = reader.nextInt();
          System.out.print("Enter the score for " + B.toString() + ": ");
          int bScore = reader.nextInt();
          match.setScore(aScore, bScore);
        }
        System.out.println();
      }
      System.out.println(FORMAT_LINE);
      System.out.println();
    }
    Euro2016.setPlayGroups();
    //Euro2016.qualifyTeams();
    //Euro2016.playRoundOf16();
    //Euro2016.playQuarterFinals();
    //Euro2016.playSemiFinals();
    //Euro2016.playThirdPlaceMatch();
    //Euro2016.playFinal();
    } catch(IOException e){
      System.err.println("File cannot be opened.");
    }
  }

}
