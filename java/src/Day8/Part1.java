package Day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1 {

  private List<Pair> pairs = new ArrayList<>();

  public void readData() throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("inputs/day-eight-input.txt"));
    String line;

    while ((line = br.readLine()) != null) {
      List<String> signalPatterns = new ArrayList<>();
      List<String> outputValues = new ArrayList<>();
      Scanner sc = new Scanner(line);
      for (int i = 0; i < 10; i++) {
        signalPatterns.add(sc.next());
      }
      sc.next(); //throw away delimiter
      for (int j = 0; j < 4; j++) {
        outputValues.add(sc.next());
      }
      pairs.add(new Pair(signalPatterns, outputValues));
    }
  }

  public void process() {
    int total = 0;
    for (Pair p : pairs) {
      for (String output : p.outputValues) {
        switch (output.length()) {
          case 2:
          case 3:
          case 4:
          case 7:
            total++;
            break;
          default:
            break;
        }
      }
    }
    System.out.println("Number of times 1, 4, 7, and 8 appear: " + total);
  }

  public static void main(String[] args) throws IOException {
    Part1 chall = new Part1();
    chall.readData();
    chall.process();
  }
}

class Pair {
  List<String> signalPatterns;
  List<String> outputValues;

  public Pair(List<String> signalPatterns, List<String> outputValues) {
    this.signalPatterns = signalPatterns;
    this.outputValues = outputValues;
  }

  @Override
  public String toString() {
    return "Pair{" +
            "signalPatterns=" + signalPatterns +
            ", outputValues=" + outputValues +
            '}';
  }
}

