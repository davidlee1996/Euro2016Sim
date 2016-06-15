import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class ReadFile {

  private String path;

  public ReadFile(String file_path) {
    path = file_path;
  }

  public String[] OpenFile() throws IOException {
    FileReader fr = new FileReader(path);
    BufferedReader tr = new BufferedReader(fr);

    int numLines = readLines();
    String[] dataText = new String[numLines];

    for (int i = 0; i < numLines; i += 1) {
      dataText[i] = tr.readLine();
    }

    tr.close();
    return dataText;
  }

  public int readLines() throws IOException {
    FileReader fr = new FileReader(path);
    BufferedReader br = new BufferedReader(fr);

    String line;
    int numLines = 0;

    while ((line = br.readLine()) != null) {
      numLines += 1;
    }
    br.close();

    return numLines;
  }

}
