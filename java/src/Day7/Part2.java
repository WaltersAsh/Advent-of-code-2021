package Day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part2 {

  List<Integer> horizPositions = new ArrayList<>();

  public void readData() throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("inputs/day-seven-input.txt"));
    String line;

    while ((line = br.readLine()) != null) {
      String format = line.replaceAll(",", " ");
      Scanner sc = new Scanner(format);
      while (sc.hasNext()) {
        horizPositions.add(sc.nextInt());
      }
      sc.close();
    }
  }

  public void process() {

    int total = 0;
    for (int pos : horizPositions) {
      total += pos;
    }
    int mean = total / horizPositions.size();

    int result = 0;
    for (int pos : horizPositions) {
      int cost = Math.abs(pos - mean);
      result += cost * (cost + 1) / 2;
    }

    System.out.println(result);
  }

  public static void main(String[] args) throws IOException {
    Part2 chall = new Part2();
    chall.readData();
    chall.process();
  }
}
