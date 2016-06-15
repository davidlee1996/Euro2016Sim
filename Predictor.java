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
    boolean auto = args[0].equals("a");
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
        if (auto) {
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
    Euro2016.qualifyTeams();

    Match[] RoundOf16 = Euro2016.getRoundOf16();
    for (int i = 0; i < RoundOf16.length; i += 1) {
      Match match = RoundOf16[i];
      Team A = match.getTeams()[0];
      Team B = match.getTeams()[1];
      System.out.println("This match is between " + A.toString() + " and " + B.toString());
      if (auto) {
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
    Euro2016.setRoundOf16Played();

    Match[] QuarterFinals = Euro2016.createQuarterFinals();
    for (int i = 0; i < QuarterFinals.length; i += 1) {
      Match match = QuarterFinals[i];
      Team A = match.getTeams()[0];
      Team B = match.getTeams()[1];
      System.out.println("This match is between " + A.toString() + " and " + B.toString());
      if (auto) {
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
    Euro2016.setQuarterFinalsPlayed();

    Match[] SemiFinals = Euro2016.createSemiFinals();
    for (int i = 0; i < SemiFinals.length; i += 1) {
      Match match = SemiFinals[i];
      Team A = match.getTeams()[0];
      Team B = match.getTeams()[1];
      System.out.println("This match is between " + A.toString() + " and " + B.toString());
      if (auto) {
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
    Euro2016.setSemiFinalsPlayed();
    System.out.println(FORMAT_LINE);
    Euro2016.createFinalsAndThird();

    Match ThirdPlaceMatch = Euro2016.getThirdPlaceMatch();
    Match FinalMatch = Euro2016.getFinalMatch();

    Team C = ThirdPlaceMatch.getTeams()[0];
    Team D = ThirdPlaceMatch.getTeams()[1];
    System.out.println("This match is between " + C.toString() + " and " + D.toString());
    if (auto) {
      System.out.println("Enter the score for " + C.toString() + ": ");
      int cScore = Integer.parseInt(lines[k]);
      System.out.println("Enter the score for " + D.toString() + ": ");
      int dScore = Integer.parseInt(lines[k + 1]);
      ThirdPlaceMatch.setScore(cScore, dScore);
      k += 2;
    } else {
      System.out.print("Enter the score for " + C.toString() + ": ");
      int cScore = reader.nextInt();
      System.out.print("Enter the score for " + D.toString() + ": ");
      int dScore = reader.nextInt();
      ThirdPlaceMatch.setScore(cScore, dScore);
    }
    Euro2016.setThirdPlacePlayed();
    System.out.println();
    System.out.println(FORMAT_LINE);

    Team A = FinalMatch.getTeams()[0];
    Team B = FinalMatch.getTeams()[1];
    System.out.println("This match is between " + A.toString() + " and " + B.toString());
    if (auto) {
      System.out.println("Enter the score for " + A.toString() + ": ");
      int aScore = Integer.parseInt(lines[k]);
      System.out.println("Enter the score for " + B.toString() + ": ");
      int bScore = Integer.parseInt(lines[k + 1]);
      FinalMatch.setScore(aScore, bScore);
      k += 2;
    } else {
      System.out.print("Enter the score for " + A.toString() + ": ");
      int aScore = reader.nextInt();
      System.out.print("Enter the score for " + B.toString() + ": ");
      int bScore = reader.nextInt();
      FinalMatch.setScore(aScore, bScore);
    }
    System.out.println();

    } catch(IOException e){
      System.err.println("File cannot be opened.");
    }
  }

}
