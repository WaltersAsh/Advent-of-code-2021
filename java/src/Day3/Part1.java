package Day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Part1 {

  private List<List<Integer>> sorted;

  public void sortData() throws IOException {
    List<String> inputs = new ArrayList<>();
    sorted = Arrays.asList(
            new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
            new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
            new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
            new ArrayList<>(), new ArrayList<>(), new ArrayList<>()
    );

    BufferedReader br = new BufferedReader(new FileReader("inputs/day-three-input.txt"));
    String line;
    while ((line = br.readLine()) != null) {
      inputs.add(line);
    }

    for (String in : inputs) {
      char[] split = in.toCharArray();
      for (int i = 0; i < 12; i++) {
        sorted.get(i).add(Integer.parseInt(String.valueOf(split[i])));
      }
    }
  }

  public void process() {
    StringBuilder gamma = new StringBuilder();
    StringBuilder epsilon = new StringBuilder();

    for (List<Integer> list : sorted) {
      Collections.sort(list);
      int one = 0;
      int zero = 0;
      for (int i : list) {
        if (i == 1) {
          one++;
        } else {
          zero++;
        }
      }
      if (one >= zero) {
        gamma.append("1");
        epsilon.append("0");
      } else {
        gamma.append("0");
        epsilon.append("1");
      }
    }
    int gammaNum = Integer.parseInt(gamma.toString(), 2);
    int epsilonNum = Integer.parseInt(epsilon.toString(), 2);
    int multipliedResult = gammaNum * epsilonNum;

    System.out.println("Gamma binary: " + gamma);
    System.out.println("Gamma decimal: " + gammaNum);
    System.out.println("Epsilon binary: " + epsilon);
    System.out.println("Epsilon decimal: " + epsilonNum);
    System.out.println("Multiplied result: " + multipliedResult);
  }

  public static void main(String[] args) throws IOException {
    Part1 chall = new Part1();
    chall.sortData();
    chall.process();
  }

}
