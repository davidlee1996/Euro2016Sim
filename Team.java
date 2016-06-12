public class Team {
  public double odds;
  public int points;
  public String name;
  public int groupName;
  public int goalsScored;
  public int goalsAllowed;
  public int numWins;
  public int numLosses;
  public int numDraws;
  public boolean qual;
  public int rank;

  public Team(double d, String n, int g) {
    odds = d;
    name = n;
    groupName = g;
    numWins = 0;
    numDraws = 0;
    numLosses = 0;
    points = 0;
    qual = false;
    goalsScored = 0;
    goalsAllowed = 0;
    rank = 0;
  }

  public int getPoints() {
    return points;
  }

  public int getGroup() {
    return groupName;
  }

  public String toString() {
    return name;
  }

  public boolean isEmpty() {
    return name == null;
  }

  public void change(int d) {
    points += d;
    if (d == 3) {
      numWins += 1;
    } else if (d == 1) {
      numDraws += 1;
    } else {
      numLosses += 1;
    }
  }

  public void qualify() {
    qual = true;
  }

  public boolean qualified() {
    return qual;
  }

  public void score(int n) {
    goalsScored += n;
  }

  public void concede(int n) {
    goalsAllowed += n;
  }

  public int getWins() {
    return numWins;
  }

  public int getLosses() {
    return numLosses;
  }

  public int getDraws() {
    return numDraws;
  }

  public int goalDifference() {
    return goalsScored - goalsAllowed;
  }

  public int getGoalsScored() {
    return goalsScored;
  }

  public int getGoalsAllowed() {
    return goalsAllowed;
  }

  public void changeRank(int n) {
    rank = n;
  }

  public int getRank() {
    return rank;
  }
}
