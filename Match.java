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

  public boolean contains(Team A1, Team B1) {
    return (A1.equals(A) && B1.equals(B)) || (A1.equals(B) && B1.equals(A));
  }

  public void play() {
    Random rn = new Random();
    result = rn.nextInt(3) + 1;
    if (result == 1) {
      A_goal = rn.nextInt(3) + 1;
      B_goal = A_goal;
      A.change(1);
      B.change(1);
      A.score(A_goal);
      B.score(B_goal);
      A.concede(B_goal);
      B.concede(A_goal);
      System.out.println("This match was a draw between " + A.toString() + " (" + A_goal + ")"
                        + " and " + B.toString() + " (" + B_goal + ")" + ".");
    } else if (result == 2) {
      A_goal = rn.nextInt(4) + 2;
      B_goal = rn.nextInt(1) + 0;
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
      B_goal = rn.nextInt(4) + 2;
      A_goal = rn.nextInt(1) + 0;
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
      winner = null;
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
}
