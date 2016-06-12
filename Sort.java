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
        } /*else if (teams[j].getPoints() ==  teams[temp].getPoints()) {
          if (fixtures != null) {

          } else {

          }
        }*/
      }
    }
  }
}
