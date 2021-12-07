package Day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Part2 {

  private long[] freq = new long[9]; //index = timer, value = frequency
  private int days = 256; //80

  public void readData() throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("inputs/day-six-input.txt"));
    String line;

    while ((line = br.readLine()) != null) {
      String format = line.replaceAll(",", " ");
      Scanner sc = new Scanner(format);
      while (sc.hasNext()) {
        freq[sc.nextInt()]++;
      }
      sc.close();
    }
    System.out.println(Arrays.toString(freq));
  }

  public void test() {
    freq = new long[]{
            0, 1, 1, 2, 1, 0, 0, 0, 0
    };
  }

  public void process() {
    //keep counts of lanternfish instead of actual objects
    System.out.println("Initial state: " + Arrays.toString(freq));

    long[] temp;
    Long tot = 0L;

    for (int day = 0; day < days + 1; day++) {
      temp = new long[9];

      //at lanternfish 0, spawn new laternfish at 8, and reset original lanternfish to 6
      if (freq[0] != 0) {
        temp[6] += freq[0];
        temp[8] += freq[0];
        temp[0] = 0;
        freq[0] = 0;
      }

      //decrement
      for (int i = 0; i < freq.length - 1; i++) {
        if (freq[i + 1] != 0) {
          freq[i] += freq[i + 1];
          freq[i + 1] = 0;
        }
      }

      //add decremented lanternfish back to temp
      for (int i = 0; i < freq.length - 1; i++) {
        temp[i] += freq[i];
      }
      freq = temp;
      System.out.println("After day " + day + ": " + Arrays.toString(freq));
    }

    //total answer
    for (int i = 0; i < freq.length - 1; i++) {
      tot += freq[i];
    }
    System.out.println("\nNumber of lanternfish after " + days + " days: " + tot);
  }

  public static void main(String[] args) throws IOException {
    Part2 chall = new Part2();
    //chall.test();
    chall.readData();
    chall.process();
  }
}





