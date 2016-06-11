import java.lang.Math;
import java.util.Random;

public class Match {
  public Team A;
  public Team B;
  public Team winner;
  public boolean group;
  int result;

  public Match(Team A1, Team B1, boolean b) {
    A = A1;
    B = B1;
    winner = null;
    group = b;
  }

  public void play() {
    Random rn = new Random();
    result = rn.nextInt(3) + 1;
    if (result == 1) {
      A.change(1);
      B.change(1);
      System.out.println("This match was a draw between " + A.toString() + " (" + A.getPoints() + ")"
                        + " and " + B.toString() + " (" + B.getPoints() + ")" + ".");
    } else if (result == 2) {
      A.change(3);
      winner = A;
      System.out.println(A.toString() + " (" + A.getPoints() + ") has won over "
                        + B.toString() + " (" + B.getPoints() + ").");
    } else {
      B.change(3);
      winner = B;
      System.out.println(B.toString() + " (" + B.getPoints() + ") has won over "
                        + A.toString() + " (" + A.getPoints() + ").");
    }
  }

  public Team getWinner() {
    return winner;
  }
}
