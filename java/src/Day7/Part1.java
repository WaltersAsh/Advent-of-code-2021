package Day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Part1 {

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

  public void test() {
    horizPositions = Arrays.asList(16, 1, 2, 0, 4, 2, 7, 1, 2, 14);
  }

  public void process() {
    Collections.sort(horizPositions);
    System.out.println(horizPositions);
    int median = horizPositions.get(horizPositions.size() / 2);
    System.out.println("Median: " + median + "\n");
    //most minimum fuel cost would probably be the median

    int total = 0;
    for (int pos : horizPositions) {
      total += pos;
    }
    double average = total / horizPositions.size();

    int tot = 0;
    for (int horizPos : horizPositions) {
      tot += Math.abs(horizPos - median);
    }
    System.out.println(tot);
  }

  public static void main(String[] args) throws IOException {
    Part1 chall = new Part1();
    //chall.test();
    chall.readData();
    chall.process();
  }
}
