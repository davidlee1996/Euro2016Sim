import java.lang.Math;

public class Group {
  public Team A;
  public Team B;
  public Team C;
  public Team D;
  public Match[] fixtures;

  public Group(Team a1, Team b1, Team c1, Team d1) {
    A = a1;
    B = b1;
    C = c1;
    D = d1;
    makeFix();
  }

  public Team[] getTeams() {
    return new Team[] {A, B, C, D};
  }

  public void makeFix() {
    fixtures = new Match[6];
    fixtures[0] = new Match(A, B, true);
    fixtures[1] = new Match(C, D, true);
    fixtures[2] = new Match(A, C, true);
    fixtures[3] = new Match(B, D, true);
    fixtures[4] = new Match(A, D, true);
    fixtures[5] = new Match(B, C, true);
  }

  public void play() {
    System.out.println();
    System.out.println("=====================================================");
    System.out.println();
    System.out.println("In this group are: " + A.toString() + ", "
                      + B.toString() + ", " + C.toString() + ", "
                      + D.toString() + ".");
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
      System.out.println(teams[j].getRank() + "." + teams[j] + " (" + teams[j].getPoints() + ")");
    }
    System.out.println();
    System.out.println("=====================================================");
  }

  public Team[] standings() {
    Team[] teams = this.getTeams();
    sorter(teams);
    for (int j = 3; j >= 0; j -= 1) {
      for (int i = 0; i < 4; i += 1) {
        teams[i].changeRank(4 - i);
      }
    }
    return teams;
  }

  private void sorter(Team[] teams) {
    /* Bubble sorts in ascending order. */
    int len = teams.length;
    int temp;
    for (int i = len; i >= 0; i -= 1) {
      for (int j = 0; j < len - 1; j += 1) {
        temp = j + 1;
        if (teams[j].getPoints() > teams[temp].getPoints()) {
          Team t;
          t = teams[j];
          teams[j] = teams[temp];
          teams[temp] = t;
        }
      }
    }
  }
}
