import java.lang.Math;

public class Group {
  public Team[] teams;
  public Match[] fixtures;

  public Group(Team A, Team B, Team C, Team D) {
    teams = new Team[4];
    fixtures = new Match[6];
    teams[0] = A;
    teams[1] = B;
    teams[2] = C;
    teams[3] = D;
    fixtures[0] = new Match(A, B, true);
    fixtures[1] = new Match(C, D, true);
    fixtures[2] = new Match(A, C, true);
    fixtures[3] = new Match(B, D, true);
    fixtures[4] = new Match(A, D, true);
    fixtures[5] = new Match(B, C, true);
  }

  public Match findMatch(Team a, Team b) {
    for (int i = 0; i < 6; i += 1) {
      if (fixtures[i].contains(a, b)) {
        return fixtures[i];
      }
    }
    System.out.println("No match was found between these two.");
    return null;
  }

  public Team[] getTeams() {
    return teams;
  }

  public Match[] getMatches() {
    return fixtures;
  }

  public void play() {
    System.out.println();
    System.out.println("=====================================================");
    System.out.println();
    System.out.println("In this group are: " + teams[0].toString() + ", "
                      + teams[1].toString() + ", " + teams[2].toString() + ", "
                      + teams[3].toString() + ".");
    System.out.println();
    for (int i = 0; i < 6; i += 1) {
      if (((i % 2) == 0) && (i != 0)) {
        System.out.println();
      }
      fixtures[i].play();
    }
    System.out.println();
  }

  public void displayStandings() {
    Team[] teams = this.standings();
    for (int j = 3; j >=0 ; j -= 1) {
      System.out.println(teams[j].getRank() + "." + teams[j]
                        + " (Points: " + teams[j].getPoints()
                        + " | Wins: " + teams[j].getWins()
                        + " | Draws: " + teams[j].getDraws()
                        + " | Losses: " + teams[j].getLosses()
                        + " | GD: " + teams[j].goalDifference()
                        + " | GF: " + teams[j].getGoalsScored()
                        + " | GA: " + teams[j].getGoalsAllowed() + ")");
    }
    System.out.println();
    System.out.println("=====================================================");
  }

  public Team[] standings() {
    Sort thing = new Sort();
    thing.bubbleSorter(teams, fixtures);
    for (int j = 3; j >= 0; j -= 1) {
      for (int i = 0; i < 4; i += 1) {
        teams[i].changeRank(4 - i);
      }
    }
    return teams;
  }

}
