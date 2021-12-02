package DayOne;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Part2 {

  private List<Integer> inputs;

  public Part2(List<Integer> inputs) {
    this.inputs = inputs;
  }

  public List<List<Integer>> splitSlidingWindows() {
    List<List<Integer>> windows = new ArrayList<>();
    for (int i = 2; i < inputs.size(); i++) {
      List<Integer> list = new ArrayList<>();
      list.add(inputs.get(i - 2));
      list.add(inputs.get(i - 1));
      list.add(inputs.get(i));
      windows.add(list);
    }
    System.out.println("wub");
    System.out.println(Arrays.toString(windows.toArray()));
    return windows;
  }

  public void process() {
    List<Integer> derivedInputs = new ArrayList<>();

    //sum windows
    for (List<Integer> list : splitSlidingWindows()) {
      int sum = list.stream().reduce(0, Integer::sum);
      derivedInputs.add(sum);
    }

    int inc = 0;
    int dec = 0;
    int na = 0;

    System.out.println(derivedInputs.get(0) + " (N/A - no previous measurement)");
    for (int i = 1; i < derivedInputs.size(); i++) {
      if (derivedInputs.get(i) > derivedInputs.get(i - 1)) {
        inc++;
        System.out.println(derivedInputs.get(i) + " (increased)");
      } else if (derivedInputs.get(i) < derivedInputs.get(i - 1)) {
        System.out.println(derivedInputs.get(i) + " (decreased)");
        dec++;
      } else {
        System.out.println(derivedInputs.get(i) + " (no change)");
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


  public static void main(String[] args) throws FileNotFoundException {
    List<Integer> testInputs = Arrays.asList(199, 200, 208, 210, 200, 207, 240, 269, 260, 263);
    Part2 test = new Part2(testInputs);
    test.process();

    System.out.println("------------------------------------------------------------------------");
    Part2 chall = new Part2(readInputs());
    chall.process();
  }

}
