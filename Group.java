import java.lang.Math;

public class Group {
  public Team[] teams;
  public Match[] fixtures;
  public boolean played;
  String FORMAT_LINE = new String(new char[85]).replace("\0", "=");

  public Group(Team A, Team B, Team C, Team D) {
    teams = new Team[4];
    fixtures = new Match[6];
    played = false;
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
    System.out.println(FORMAT_LINE);
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
    this.standings();
    System.out.println();
    System.out.println(FORMAT_LINE);
  }

  public void displayStandings() {
    String LINE_TEMPLATE_f = "%s \t%s \t%22s \t%s \t%s \t%s \t%s \t%s \t%s";
    String LINE_TEMPLATE = "%d \t%-20s \t%d \t%d \t%d \t%d \t%d \t%d \t%d";
    String teamName;
    System.out.println(FORMAT_LINE);
    System.out.println(String.format(LINE_TEMPLATE_f, "Rank", "Name", "Points",
                                    "Win", "Draw", "Loss", "GD", "GF", "GA"));
    for (int j = 3; j >=0 ; j -= 1) {
      if (teams[j].qualified()) {
        teamName = teams[j].toString() + "*";
      } else {
        teamName = teams[j].toString();
      }
      System.out.println(String.format(LINE_TEMPLATE, teams[j].getRank(),
                  teamName, teams[j].getPoints(), teams[j].getWins(),
                  teams[j].getDraws(), teams[j].getLosses(),
                  teams[j].goalDifference(), teams[j].getGoalsScored(),
                  teams[j].getGoalsAllowed()));
    }
    System.out.println(FORMAT_LINE);
    System.out.println();
  }

  public void standings() {
    Sort thing = new Sort();
    thing.bubbleSorter(teams, fixtures);
    for (int j = 3; j >= 0; j -= 1) {
      for (int i = 0; i < 4; i += 1) {
        teams[i].changeRank(4 - i);
      }
    }
    played = true;
  }

  public Team[] getStandings() {
    if (!played) {
      System.err.println("The final standings have not yet been formulated.");
      return null;
    }
    return teams;
  }

  public Team getTeamRanked(int n) {
    Team[] stuff = this.getStandings();
    return stuff[4 - n];
  }

}
