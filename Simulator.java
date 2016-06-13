public class Simulator {

  public static void main(String[] args) {
    Tourney Euro2016 = new Tourney();
    Euro2016.createTeams();
    Euro2016.createGroups();
    Euro2016.playGroups();
    Euro2016.qualifyTeams();
    Euro2016.playRoundOf16();
    Euro2016.playQuarterFinals();
    Euro2016.playSemiFinals();
    Euro2016.playThirdPlaceMatch();
    Euro2016.playFinal();
  }

}
