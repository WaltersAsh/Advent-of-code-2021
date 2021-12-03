package Day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Part2 {

  private static List<String> inputs;

  public void sortData() throws IOException {
    inputs = new ArrayList<>();
    BufferedReader br = new BufferedReader(new FileReader("inputs/day-three-input.txt"));
    String line;
    while ((line = br.readLine()) != null) {
      inputs.add(line);
    }
  }

  public List<Tuple> findColumnDigits(List<String> numbers, int pos) {
    List<Tuple> tuples = new ArrayList<>();
    for (String num : numbers) {
      tuples.add(new Tuple(Character.getNumericValue(num.charAt(pos)), num));
    }
    return tuples;
  }

  public int findOxyGenRating() {
    int pos = 0;

    List<Tuple> tuples = findColumnDigits(inputs, pos);
    while (tuples.size() > 1) {
      List<Tuple> ones = new ArrayList<>();
      List<Tuple> zeros = new ArrayList<>();
      for (Tuple t : tuples) {
        if (t.digit == 1) {
          ones.add(t);
        } else {
          zeros.add(t);
        }
      }
      if (ones.size() > zeros.size()) {
        tuples = ones;
      } else if (ones.size() == zeros.size()) {
        tuples = ones;
      } else {
        tuples = zeros;
      }
      if (tuples.size() == 1) {
        return Integer.parseInt(tuples.get(0).binNum, 2);
      }
      pos++;
      List<String> inputs = new ArrayList<>();
      for (Tuple t : tuples) {
        inputs.add(t.binNum);
      }
      tuples = findColumnDigits(inputs, pos);
    }
    System.out.println(tuples);
    return Integer.parseInt(tuples.get(0).binNum, 2);
  }

  public int findCarbScrubRating() {
    int pos = 0;

    List<Tuple> tuples = findColumnDigits(inputs, pos);
    while (tuples.size() > 1) {
      System.out.println(tuples);
      List<Tuple> ones = new ArrayList<>();
      List<Tuple> zeros = new ArrayList<>();
      for (Tuple t : tuples) {
        if (t.digit == 1) {
          ones.add(t);
        } else {
          zeros.add(t);
        }
      }
      if (zeros.size() < ones.size()) {
        tuples = zeros;
      } else if (zeros.size() == ones.size()) {
        tuples = zeros;
      } else {
        tuples = ones;
      }
      if (tuples.size() == 1) {
        return Integer.parseInt(tuples.get(0).binNum, 2);
      }
      pos++;
      List<String> inputs = new ArrayList<>();
      for (Tuple t : tuples) {
        inputs.add(t.binNum);
      }
      tuples = findColumnDigits(inputs, pos);
    }
    System.out.println(tuples);
    return Integer.parseInt(tuples.get(0).binNum, 2);
  }

  public static void main(String[] args) throws IOException {
    Part2 chall = new Part2();
    chall.sortData();
    System.out.println("Oxygen generator rating: " + chall.findOxyGenRating());
    System.out.println("\nCarbon scrubber rating: " + chall.findCarbScrubRating());
    System.out.println("\nFinal multiplied result: " + chall.findOxyGenRating() * chall.findCarbScrubRating());
  }
}

class Tuple {

  int digit;
  String binNum;

  public Tuple(int digit, String binNum) {
    this.digit = digit;
    this.binNum = binNum;
  }

  @Override
  public String toString() {
    return "Tuple{" +
            "digit=" + digit +
            ", binNum='" + binNum + '\'' +
            '}';
  }
}
