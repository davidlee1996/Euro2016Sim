import java.util.stream.IntStream;

public class Tourney {

  public static void main(String[] args) {
    Team France = new Team(3, "France", 0);//0
    Team Germany = new Team(4, "Germany", 2);//2
    Team Spain = new Team(5, "Spain", 3);//3
    Team England = new Team(9, "England", 1);//1
    Team Belgium = new Team(10, "Belgium", 4);//4
    Team Italy = new Team(16, "Italy", 4);//4
    Team Portugal = new Team(18, "Portugal", 5);//5
    Team Croatia = new Team(25, "Croatia", 3);//3
    Team Austria = new Team(40, "Austria", 5);//5
    Team Switzerland = new Team(40, "Switzerland", 0);//0
    Team Poland = new Team(50, "Poland", 2);//2
    Team Ukraine = new Team(66, "Ukraine", 2);//2
    Team Russia = new Team(66, "Russia", 1);//1
    Team Turkey = new Team(80, "Turkey", 3);//3
    Team Sweden = new Team(80, "Sweden", 4);//4
    Team Wales = new Team(80, "Wales", 1);//1
    Team Czech = new Team(100, "Czech Republic", 3);//3
    Team Slovakia = new Team(100, "Slovakia", 1);//1
    Team Romania = new Team(100, "Romania", 0);//0
    Team Iceland = new Team(150, "Iceland", 5);//5
    Team Ireland = new Team(150, "Republic of Ireland", 4);//4
    Team NorthernIre = new Team(250, "Northern Ireland", 2);//2
    Team Albania = new Team(250, "Albania", 0);//0
    Team Hungary = new Team(250, "Hungary", 5);//5

    Group[] groups = new Group[6];
    groups[0] = new Group(France, Romania, Albania, Switzerland);
    groups[1] = new Group(England, Russia, Wales, Slovakia);
    groups[2] = new Group(Germany, Ukraine, Poland, NorthernIre);
    groups[3] = new Group(Spain, Czech, Turkey, Croatia);
    groups[4] = new Group(Belgium, Italy, Ireland, Sweden);
    groups[5] = new Group(Portugal, Iceland, Austria, Hungary);

    /* Group stages begin! */
    for (int i = 0; i < 6; i += 1) {
      groups[i].play();
      groups[i].standings();
    }

    /* Qualifying teams determined. */
    Team[] thirdPlace = new Team[6];
    int k = 0;
    Team[] qTeams = new Team[16];
    int q = 0;
    Team[] qThirds = new Team[4];
    int z = 0;

    for (int i = 0; i < 6; i += 1) {
      for (int j = 3; j >= 0; j -= 1) {
        if (groups[i].getTeams()[j].getRank() < 3) {
          groups[i].getTeams()[j].qualify();
          qTeams[q] = groups[i].getTeams()[j];
          q += 1;
        } else if (groups[i].getTeams()[j].getRank() == 3) {
          thirdPlace[k] = groups[i].getTeams()[j];
          k += 1;
        }
      }
    }

    Sort qThird = new Sort();
    qThird.bubbleSorter(thirdPlace, null);
    for (int i = 2; i < 6; i += 1) {
      thirdPlace[i].qualify();
      qTeams[q] = thirdPlace[i];
      qThirds[z] = thirdPlace[i];
      z += 1;
      q += 1;
    }

    for (int i = 0; i < 6; i += 1) {
      groups[i].displayStandings();
    }

    /* Knockout Rounds begin! */
    Match[] RoundOf16 = new Match[8];
    int[] groupThird = new int[4];
    for (int i = 0; i < 4; i += 1) {
      groupThird[i] = qThirds[i].getGroup();
    }
    RoundOf16[0] = new Match(groups[0].getTeamRanked(2), groups[2].getTeamRanked(2), false);
    RoundOf16[3] = new Match(groups[5].getTeamRanked(1), groups[4].getTeamRanked(2), false);
    RoundOf16[5] = new Match(groups[4].getTeamRanked(1), groups[3].getTeamRanked(2), false);
    RoundOf16[7] = new Match(groups[1].getTeamRanked(2), groups[5].getTeamRanked(2), false);
    boolean t_0 = IntStream.of(groupThird).anyMatch(x -> x == 0);
    boolean t_1 = IntStream.of(groupThird).anyMatch(x -> x == 1);
    boolean t_2 = IntStream.of(groupThird).anyMatch(x -> x == 2);
    boolean t_3 = IntStream.of(groupThird).anyMatch(x -> x == 3);
    boolean t_4 = IntStream.of(groupThird).anyMatch(x -> x == 4);
    boolean t_5 = IntStream.of(groupThird).anyMatch(x -> x == 5);
    if (t_0 && t_1 && t_2 && t_3) {
      RoundOf16[1] = new Match(groups[3].getTeamRanked(1), groups[1].getTeamRanked(3), false);
      RoundOf16[2] = new Match(groups[1].getTeamRanked(1), groups[3].getTeamRanked(3), false);
      RoundOf16[4] = new Match(groups[2].getTeamRanked(1), groups[0].getTeamRanked(3), false);
      RoundOf16[6] = new Match(groups[0].getTeamRanked(1), groups[2].getTeamRanked(3), false);
    } else if (t_0 && t_1 && t_2 && t_4) {
      RoundOf16[1] = new Match(groups[3].getTeamRanked(1), groups[4].getTeamRanked(3), false);
      RoundOf16[2] = new Match(groups[1].getTeamRanked(1), groups[0].getTeamRanked(3), false);
      RoundOf16[4] = new Match(groups[2].getTeamRanked(1), groups[1].getTeamRanked(3), false);
      RoundOf16[6] = new Match(groups[0].getTeamRanked(1), groups[2].getTeamRanked(3), false);
    } else if (t_0 && t_1 && t_2 && t_5) {
      RoundOf16[1] = new Match(groups[3].getTeamRanked(1), groups[5].getTeamRanked(3), false);
      RoundOf16[2] = new Match(groups[1].getTeamRanked(1), groups[0].getTeamRanked(3), false);
      RoundOf16[4] = new Match(groups[2].getTeamRanked(1), groups[1].getTeamRanked(3), false);
      RoundOf16[6] = new Match(groups[0].getTeamRanked(1), groups[2].getTeamRanked(3), false);
    } else if (t_0 && t_1 && t_3 && t_4) {
      RoundOf16[1] = new Match(groups[3].getTeamRanked(1), groups[4].getTeamRanked(3), false);
      RoundOf16[2] = new Match(groups[1].getTeamRanked(1), groups[0].getTeamRanked(3), false);
      RoundOf16[4] = new Match(groups[2].getTeamRanked(1), groups[1].getTeamRanked(3), false);
      RoundOf16[6] = new Match(groups[0].getTeamRanked(1), groups[3].getTeamRanked(3), false);
    } else if (t_0 && t_1 && t_3 && t_5) {
      RoundOf16[1] = new Match(groups[3].getTeamRanked(1), groups[5].getTeamRanked(3), false);
      RoundOf16[2] = new Match(groups[1].getTeamRanked(1), groups[0].getTeamRanked(3), false);
      RoundOf16[4] = new Match(groups[2].getTeamRanked(1), groups[1].getTeamRanked(3), false);
      RoundOf16[6] = new Match(groups[0].getTeamRanked(1), groups[3].getTeamRanked(3), false);
    } else if (t_0 && t_1 && t_4 && t_5) {
      RoundOf16[1] = new Match(groups[3].getTeamRanked(1), groups[5].getTeamRanked(3), false);
      RoundOf16[2] = new Match(groups[1].getTeamRanked(1), groups[0].getTeamRanked(3), false);
      RoundOf16[4] = new Match(groups[2].getTeamRanked(1), groups[1].getTeamRanked(3), false);
      RoundOf16[6] = new Match(groups[0].getTeamRanked(1), groups[4].getTeamRanked(3), false);
    } else if (t_0 && t_2 && t_3 && t_4) {
      RoundOf16[1] = new Match(groups[3].getTeamRanked(1), groups[4].getTeamRanked(3), false);
      RoundOf16[2] = new Match(groups[1].getTeamRanked(1), groups[3].getTeamRanked(3), false);
      RoundOf16[4] = new Match(groups[2].getTeamRanked(1), groups[0].getTeamRanked(3), false);
      RoundOf16[6] = new Match(groups[0].getTeamRanked(1), groups[2].getTeamRanked(3), false);
    } else if (t_0 && t_2 && t_3 && t_5) {
      RoundOf16[1] = new Match(groups[3].getTeamRanked(1), groups[5].getTeamRanked(3), false);
      RoundOf16[2] = new Match(groups[1].getTeamRanked(1), groups[3].getTeamRanked(3), false);
      RoundOf16[4] = new Match(groups[2].getTeamRanked(1), groups[0].getTeamRanked(3), false);
      RoundOf16[6] = new Match(groups[0].getTeamRanked(1), groups[2].getTeamRanked(3), false);
    } else if (t_0 && t_2 && t_4 && t_5) {
      RoundOf16[1] = new Match(groups[3].getTeamRanked(1), groups[4].getTeamRanked(3), false);
      RoundOf16[2] = new Match(groups[1].getTeamRanked(1), groups[0].getTeamRanked(3), false);
      RoundOf16[4] = new Match(groups[2].getTeamRanked(1), groups[5].getTeamRanked(3), false);
      RoundOf16[6] = new Match(groups[0].getTeamRanked(1), groups[2].getTeamRanked(3), false);
    } else if (t_0 && t_3 && t_4 && t_5) {
      RoundOf16[1] = new Match(groups[3].getTeamRanked(1), groups[4].getTeamRanked(3), false);
      RoundOf16[2] = new Match(groups[1].getTeamRanked(1), groups[0].getTeamRanked(3), false);
      RoundOf16[4] = new Match(groups[2].getTeamRanked(1), groups[5].getTeamRanked(3), false);
      RoundOf16[6] = new Match(groups[0].getTeamRanked(1), groups[3].getTeamRanked(3), false);
    } else if (t_1 && t_2 && t_3 && t_4) {
      RoundOf16[1] = new Match(groups[3].getTeamRanked(1), groups[4].getTeamRanked(3), false);
      RoundOf16[2] = new Match(groups[1].getTeamRanked(1), groups[3].getTeamRanked(3), false);
      RoundOf16[4] = new Match(groups[2].getTeamRanked(1), groups[1].getTeamRanked(3), false);
      RoundOf16[6] = new Match(groups[0].getTeamRanked(1), groups[2].getTeamRanked(3), false);
    } else if (t_1 && t_2 && t_3 && t_5) {
      RoundOf16[1] = new Match(groups[3].getTeamRanked(1), groups[5].getTeamRanked(3), false);
      RoundOf16[2] = new Match(groups[1].getTeamRanked(1), groups[3].getTeamRanked(3), false);
      RoundOf16[4] = new Match(groups[2].getTeamRanked(1), groups[1].getTeamRanked(3), false);
      RoundOf16[6] = new Match(groups[0].getTeamRanked(1), groups[2].getTeamRanked(3), false);
    } else if (t_1 && t_2 && t_4 && t_5) {
      RoundOf16[1] = new Match(groups[3].getTeamRanked(1), groups[5].getTeamRanked(3), false);
      RoundOf16[2] = new Match(groups[1].getTeamRanked(1), groups[2].getTeamRanked(3), false);
      RoundOf16[4] = new Match(groups[2].getTeamRanked(1), groups[1].getTeamRanked(3), false);
      RoundOf16[6] = new Match(groups[0].getTeamRanked(1), groups[4].getTeamRanked(3), false);
    } else if (t_1 && t_3 && t_4 && t_5) {
      RoundOf16[1] = new Match(groups[3].getTeamRanked(1), groups[5].getTeamRanked(3), false);
      RoundOf16[2] = new Match(groups[1].getTeamRanked(1), groups[3].getTeamRanked(3), false);
      RoundOf16[4] = new Match(groups[2].getTeamRanked(1), groups[1].getTeamRanked(3), false);
      RoundOf16[6] = new Match(groups[0].getTeamRanked(1), groups[4].getTeamRanked(3), false);
    } else if (t_2 && t_3 && t_4 && t_5) {
      RoundOf16[1] = new Match(groups[3].getTeamRanked(1), groups[4].getTeamRanked(3), false);
      RoundOf16[2] = new Match(groups[1].getTeamRanked(1), groups[3].getTeamRanked(3), false);
      RoundOf16[4] = new Match(groups[2].getTeamRanked(1), groups[5].getTeamRanked(3), false);
      RoundOf16[6] = new Match(groups[0].getTeamRanked(1), groups[2].getTeamRanked(3), false);
    }

    for (int i = 0; i < 8; i += 1) {
      RoundOf16[i].play();
    }
    System.out.println();

    /* Quarterfinals begin! */
    Match[] QuarterFinals = new Match[4];
    for (int i = 0, j = 0; i < 4; i += 1) {
      QuarterFinals[i] = new Match(RoundOf16[j].getWinner(), RoundOf16[j + 1].getWinner(), false);
      QuarterFinals[i].play();
      j += 2;
    }
    System.out.println();

    /* Semifinals begin! */
    Match[] SemiFinals = new Match[2];
    for (int i = 0, j = 0; i < 2; i += 1) {
      SemiFinals[i] = new Match(QuarterFinals[j].getWinner(), QuarterFinals[j + 1].getWinner(), false);
      SemiFinals[i].play();
      j += 2;
    }
    System.out.println();

    /* Third place match! */
    Match ThirdPlaceMatch = new Match(SemiFinals[0].getLoser(), SemiFinals[1].getLoser(), false);
    ThirdPlaceMatch.play();
    System.out.println();

    /* Final match! */
    System.out.println("Final match!");
    Match FinalMatch = new Match(SemiFinals[0].getWinner(), SemiFinals[1].getWinner(), false);
    FinalMatch.play();
    System.out.println();
  }
}
