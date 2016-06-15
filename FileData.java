import java.io.IOException;

public class FileData {

  public static void main(String[] args) throws IOException {
    String file_name = "predict.txt";

    try {
      ReadFile file = new ReadFile(file_name);
      String[] lines = file.OpenFile();

      for (int i = 0; i < lines.length; i += 1) {
        System.out.println(lines[i]);
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

}
