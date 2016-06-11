public class Team {
  public double odds;
  public int points;
  public String name;
  public int goalsScored;
  public int goalsAllowed;
  public boolean qual;
  public int rank;

  public Team(double d, String n) {
    odds = d;
    name = n;
    points = 0;
    qual = false;
    goalsScored = 0;
    goalsAllowed = 0;
    rank = 0;
  }

  public int getPoints() {
    return points;
  }

  public String toString() {
    return name;
  }

  public boolean isEmpty() {
    return name == null;
  }

  public void change(int d) {
    points += d;
  }

  public void qualify() {
    qual = true;
  }

  public void score(int n) {
    goalsScored += n;
  }

  public void concede(int n) {
    goalsAllowed += n;
  }

  public void changeRank(int n) {
    rank = n;
  }

  public int getRank() {
    return rank;
  }
}
