import java.lang.Math;
import java.util.Random;

public class Match {
  public Team A;
  public Team B;
  public Team winner;
  public boolean group;
  public boolean played;
  public int A_goal;
  public int B_goal;
  public int result;

  public Match(Team A1, Team B1, boolean b) {
    A = A1;
    B = B1;
    winner = null;
    played = false;
    group = b;
    A_goal = 0;
    B_goal = 0;
  }

  public int goalDifference() {
    if (!played) {
      System.err.println("The match has not been played yet.");
      return 0;
    }
    return Math.abs(A_goal - B_goal);
  }

  public int goalsScoredTeam(Team t) {
    if (t.equals(A)) {
      return A_goal;
    } else if (t.equals(B)) {
      return B_goal;
    } else {
      System.err.println(t.toString() + " did not play this match.");
      return 0;
    }
  }

  public Team[] getTeams() {
    Team[] teams = {A, B};
    return teams;
  }

  public boolean contains(Team A1, Team B1) {
    return (A1.equals(A) && B1.equals(B)) || (A1.equals(B) && B1.equals(A));
  }

  public void play() {
    result = randInt(1, 3);
    if (result == 1) {
      A_goal = randInt(0, 3);
      B_goal = A_goal;
      A.score(A_goal);
      B.score(B_goal);
      A.concede(B_goal);
      B.concede(A_goal);
      if (!group) {
        int A_goalsET = randInt(0, 3);
        int B_goalsET = randInt(0, 3);
        A_goal += A_goalsET;
        B_goal += B_goalsET;
        A.score(A_goalsET);
        B.score(A_goalsET);
        A.concede(A_goalsET);
        B.concede(A_goalsET);
        if (A_goalsET > B_goalsET) {
          A.change(3);
          B.change(0);
          winner = A;
          System.out.println(A.toString() + " (" + A_goal + ") has won over "
                            + B.toString() + " (" + B_goal + ") in extra time.");
        } else if (A_goalsET < B_goalsET) {
          A.change(0);
          B.change(3);
          winner = B;
          System.out.println(B.toString() + " (" + B_goal + ") has won over "
                            + A.toString() + " (" + A_goal + ") in extra time.");
        } else {
          int penResult = randInt(0, 1);
          if (penResult == 1) {
            A.change(3);
            B.change(0);
            winner = A;
            System.out.println(A.toString() + " (" + A_goal + ") has won over "
                              + B.toString() + " (" + B_goal + ") in penalties!");
          } else {
            A.change(0);
            B.change(3);
            winner = B;
            System.out.println(B.toString() + " (" + B_goal + ") has won over "
                              + A.toString() + " (" + A_goal + ") in penalties!");
          }
        }
      } else {
        A.change(1);
        B.change(1);
        System.out.println("This match was a draw between " + A.toString() + " (" + A_goal + ")"
                          + " and " + B.toString() + " (" + B_goal + ")" + ".");
      }
    } else if (result == 2) {
      A_goal = randInt(2, 4);
      B_goal = randInt(0, 1);
      A.change(3);
      B.change(0);
      A.score(A_goal);
      B.score(B_goal);
      A.concede(B_goal);
      B.concede(A_goal);
      winner = A;
      System.out.println(A.toString() + " (" + A_goal + ") has won over "
                        + B.toString() + " (" + B_goal + ").");
    } else {
      B_goal = randInt(2, 4);
      A_goal = randInt(0, 1);
      A.change(0);
      B.change(3);
      A.score(A_goal);
      B.score(B_goal);
      A.concede(B_goal);
      B.concede(A_goal);
      winner = B;
      System.out.println(B.toString() + " (" + B_goal + ") has won over "
                        + A.toString() + " (" + A_goal + ").");
    }
    played = true;
  }

  public Team getWinner() {
    if (!played) {
      System.err.println("The match has not been played yet.");
      return null;
    }
    return winner;
  }

  public Team getLoser() {
    if (!played) {
      System.err.println("The match has not been played yet.");
      return null;
    }
    if (winner != null) {
      if (winner.equals(A)) {
        return B;
      } else {
        return A;
      }
    }
    return null;
  }

  public void setScore(int aScore, int bScore) {
    A_goal = aScore;
    B_goal = bScore;
    if (A_goal > B_goal) {
      winner = A;
      A.change(3);
      B.change(0);
      A.score(A_goal);
      B.score(B_goal);
      A.concede(B_goal);
      B.concede(A_goal);
      System.out.println(A.toString() + " (" + A_goal + ") has won over "
                        + B.toString() + " (" + B_goal + ").");
    } else if (B_goal > A_goal) {
      winner = B;
      A.change(0);
      B.change(3);
      A.score(A_goal);
      B.score(B_goal);
      A.concede(B_goal);
      B.concede(A_goal);
      System.out.println(B.toString() + " (" + B_goal + ") has won over "
                        + A.toString() + " (" + A_goal + ").");
    } else {
      A.change(1);
      B.change(1);
      A.score(A_goal);
      B.score(B_goal);
      A.concede(B_goal);
      B.concede(A_goal);
      System.out.println("This match was a draw between " + A.toString() + " (" + A_goal + ")"
                        + " and " + B.toString() + " (" + B_goal + ")" + ".");
    }
    played = true;
  }

  public static int randInt(int min, int max) {
    Random rn = new Random();
    int randomNum = rn.nextInt((max - min) + 1) + min;
    return randomNum;
  }
}
