public class Tourney {

  public static void main(String[] args) {
    Team France = new Team(3, "France");
    Team Germany = new Team(4, "Germany");
    Team Spain = new Team(5, "Spain");
    Team England = new Team(9, "England");
    Team Belgium = new Team(10, "Belgium");
    Team Italy = new Team(16, "Italy");
    Team Portugal = new Team(18, "Portugal");
    Team Croatia = new Team(25, "Croatia");
    Team Austria = new Team(40, "Austria");
    Team Switzerland = new Team(40, "Switzerland");
    Team Poland = new Team(50, "Poland");
    Team Ukraine = new Team(66, "Ukraine");
    Team Russia = new Team(66, "Russia");
    Team Turkey = new Team(80, "Turkey");
    Team Sweden = new Team(80, "Sweden");
    Team Wales = new Team(80, "Wales");
    Team Czech = new Team(100, "Czech Republic");
    Team Slovakia = new Team(100, "Slovakia");
    Team Romania = new Team(100, "Romania");
    Team Iceland = new Team(150, "Iceland");
    Team Ireland = new Team(150, "Republic of Ireland");
    Team NorthernIre = new Team(250, "Northern Ireland");
    Team Albania = new Team(250, "Albania");
    Team Hungary = new Team(250, "Hungary");

    Group[] groups = new Group[6];
    groups[0] = new Group(France, Romania, Albania, Switzerland);
    groups[1] = new Group(England, Russia, Wales, Slovakia);
    groups[2] = new Group(Germany, Ukraine, Poland, NorthernIre);
    groups[3] = new Group(Spain, Czech, Turkey, Croatia);
    groups[4] = new Group(Belgium, Italy, Ireland, Sweden);
    groups[5] = new Group(Portugal, Iceland, Austria, Hungary);

    for (int i = 0; i < 6; i += 1) {
      groups[i].play();
      groups[i].standings();
    }
  }
}
