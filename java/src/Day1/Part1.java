package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Part1 {

  private List<Integer> inputs;

  public Part1(List<Integer> inputs) {
    this.inputs = inputs;
  }

  public void process() {
    int inc = 0;
    int dec = 0;
    int na = 0;

    System.out.println(inputs.get(0) + " (N/A - no previous measurement)");
    for (int i = 1; i < inputs.size(); i++) {
      if (inputs.get(i) > inputs.get(i - 1)) {
        inc++;
        System.out.println(inputs.get(i) + " (increased)");
      } else if (inputs.get(i) < inputs.get(i - 1)) {
        System.out.println(inputs.get(i) + " (decreased)");
        dec++;
      } else {
        System.out.println(inputs.get(i) + " (no change)");
        na++;
      }
    }
    System.out.println("\nNumber of increased measurements: " + inc);
    System.out.println("Number of decreased measurements: " + dec);
    System.out.println("Number of stationary measurements: " + na);
  }

  public static List<Integer> readInputs() throws FileNotFoundException {
    File input = new File("inputs/day-one-input.txt");
    Scanner sc = new Scanner(input);
    List<Integer> inputs = new ArrayList<>();
    while (sc.hasNext()) {
      inputs.add(sc.nextInt());
    }
    return inputs;
  }

  public static void main(String[] args) throws IOException {
    List<Integer> testInputs = Arrays.asList(199, 200, 208, 210, 200, 207, 240, 269, 260, 263);
    Part1 test = new Part1(testInputs);
    test.process();

    System.out.println("------------------------------------------------------------------------");
    Part1 chall = new Part1(readInputs());
    chall.process();
  }
}



