import java.util.Random;

public class Sort {

  public Sort() {
  }

  public void bubbleSorter(Team[] teams, Match[] fixtures) {
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
        } else if (teams[j].getPoints() ==  teams[temp].getPoints()) {
          if (fixtures != null) {
            Match game = null;
            for (int f = 0; f < 6; f += 1) {
              if (fixtures[f].contains(teams[j], teams[temp])) {
                game = fixtures[f];
              }
            }
            if (game.getWinner() == null) {
              Team t1 = teams[j];
              Team u1 = teams[temp];
              int t_GD = t1.goalDifference();
              int u_GD = u1.goalDifference();
              if (t_GD > u_GD) {
                Team t;
                t = teams[j];
                teams[j] = teams[temp];
                teams[temp] = t;
              } else if (t_GD == u_GD) {
                int t_GS = t1.getGoalsScored();
                int u_GS = u1.getGoalsScored();
                if (t_GS > u_GS) {
                  Team t;
                  t = teams[j];
                  teams[j] = teams[temp];
                  teams[temp] = t;
                } else if (t_GS == u_GS) {
                  Random rn = new Random();
                  int result = rn.nextInt(2) + 1;
                  if (result == 2) {
                    Team t;
                    t = teams[j];
                    teams[j] = teams[temp];
                    teams[temp] = t;
                  }
                }
              }
            } else if (game.getWinner().equals(teams[j])) {
              Team t;
              t = teams[j];
              teams[j] = teams[temp];
              teams[temp] = t;
            }
          } else {
            Team t1 = teams[j];
            Team u1 = teams[temp];
            int t_GD = t1.goalDifference();
            int u_GD = u1.goalDifference();
            if (t_GD > u_GD) {
              Team t;
              t = teams[j];
              teams[j] = teams[temp];
              teams[temp] = t;
            } else if (t_GD == u_GD) {
              int t_GS = t1.getGoalsScored();
              int u_GS = u1.getGoalsScored();
              if (t_GS > u_GS) {
                Team t;
                t = teams[j];
                teams[j] = teams[temp];
                teams[temp] = t;
              } else if (t_GS == u_GS) {
                Random rn = new Random();
                int result = rn.nextInt(2) + 1;
                if (result == 2) {
                  Team t;
                  t = teams[j];
                  teams[j] = teams[temp];
                  teams[temp] = t;
                }
              }
            }
          }
        }
      }
    }
  }
}
