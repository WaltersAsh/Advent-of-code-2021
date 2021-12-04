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

  public List<Pair> findColumnDigits(List<String> numbers, int pos) {
    List<Pair> pairs = new ArrayList<>();
    for (String num : numbers) {
      pairs.add(new Pair(Character.getNumericValue(num.charAt(pos)), num));
    }
    return pairs;
  }

  public int findRating(boolean findOxy) {
    int pos = 0;

    List<Pair> pairs = findColumnDigits(inputs, pos);

    while (pairs.size() > 1) {
      System.out.println(pairs);

      List<Pair> ones = new ArrayList<>();
      List<Pair> zeros = new ArrayList<>();
      for (Pair t : pairs) {
        if (t.digit == 1) {
          ones.add(t);
        } else {
          zeros.add(t);
        }
      }

      if (findOxy) {
        if (ones.size() >= zeros.size()) {
          pairs = ones;
        } else {
          pairs = zeros;
        }
      } else {
        if (zeros.size() <= ones.size()) {
          pairs = zeros;
        } else {
          pairs = ones;
        }
      }

      if (pairs.size() == 1) {
        return Integer.parseInt(pairs.get(0).binNum, 2);
      }
      pos++;

      List<String> inputs = new ArrayList<>();
      for (Pair t : pairs) {
        inputs.add(t.binNum);
      }
      pairs = findColumnDigits(inputs, pos);
    }

    return Integer.parseInt(pairs.get(0).binNum, 2);
  }


  public static void main(String[] args) throws IOException {
    Part2 chall = new Part2();
    chall.sortData();
    int oxyRating =  chall.findRating(true);
    System.out.println("\nOxygen generator rating: " + oxyRating + "\n");
    int carbRating =  chall.findRating(false);
    System.out.println("\nCarbon scrubber rating: " + carbRating);
    System.out.println("\nFinal multiplied result: " + oxyRating * carbRating);
  }
}

class Pair {

  int digit;
  String binNum;

  public Pair(int digit, String binNum) {
    this.digit = digit;
    this.binNum = binNum;
  }

  @Override
  public String toString() {
    return "Pair{" +
            "digit=" + digit +
            ", binNum='" + binNum + '\'' +
            '}';
  }
}
