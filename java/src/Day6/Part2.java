package Day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Part2 {

  private Map<Integer, Integer> freq = new HashMap<>(); //timer, frequency pair
  private int days = 256; //80

  public void readData() throws IOException {
    for (int i = 0; i < 9; i++) {
      freq.put(i, 0);
    }

    BufferedReader br = new BufferedReader(new FileReader("inputs/day-six-input.txt"));
    String line;

    while ((line = br.readLine()) != null) {
      String format = line.replaceAll(",", " ");
      Scanner sc = new Scanner(format);
      while (sc.hasNext()) {
        freq.put(sc.nextInt(), freq.get(sc.nextInt()) + 1);
      }
      sc.close();
    }
  }

  public void test() {
    for (int i = 0; i < 9; i++) {
      freq.put(i, 0);
    }

    freq.put(3, freq.get(3) + 1);
    freq.put(4, freq.get(4) + 1);
    freq.put(3, freq.get(3) + 1);
    freq.put(1, freq.get(1) + 1);
    freq.put(2, freq.get(2) + 1);
  }

  public void process() {
    System.out.println("Initial state: " + freq);
    for (int day = 0; day < days; day++) {
      if (day != 0) {
        System.out.println("After day " + day + ": " + freq);
      }
      for (int timer : freq.keySet()) {
        if (timer == 0 && freq.get(0) != 0) {
          freq.put(8, freq.get(8) + freq.get(0)); //new fish has a timer of 8
          freq.put(6, freq.get(6) + freq.get(0)); //fish with a timer of 0 goes to 6
          freq.put(0, 0); //fish with a timer of 0, gets removed from 0
          //not supposed to decrement until next day
        }
        if (timer != 0 && freq.get(timer) != 0) { //remove from current timer by decrementing
          freq.put(timer - 1, freq.get(timer - 1) + freq.get(timer));
          freq.put(timer, 0);
        }
      }
    }

    int total = 0;
    for (int timer : freq.keySet()) {
      total += freq.get(timer);
    }
    System.out.println("\nNumber of lanternfish after " + days + " days: " + total);
  }

  public static void main(String[] args) throws IOException {
    Part2 chall = new Part2();
    chall.readData();
    //chall.test();
    chall.process();
  }
}





