package Day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1 {

  private List<Lanternfish> lanternfishes = new ArrayList<>();
  private int days = 80;

  public void readData() throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("inputs/day-six-input.txt"));
    String line;

    while ((line = br.readLine()) != null) {
      String format = line.replaceAll(",", " ");
      Scanner sc = new Scanner(format);
      while (sc.hasNext()) {
        lanternfishes.add(new Lanternfish(sc.nextInt()));
      }
      sc.close();
    }
  }

  public void test() {
    lanternfishes.add(new Lanternfish(3));
    lanternfishes.add(new Lanternfish(4));
    lanternfishes.add(new Lanternfish(3));
    lanternfishes.add(new Lanternfish(1));
    lanternfishes.add(new Lanternfish(2));
  }

  public void process() {
    System.out.println("Initial state: " + lanternfishes);
    for (int day = 0; day < days; day++) {
      List<Lanternfish> temp = new ArrayList<>();
      for (Lanternfish lan : lanternfishes) {
        if (lan.getInternalTimer() == 0) {
          temp.add(new Lanternfish(6));
          temp.add(new Lanternfish(8));
        } else {
          temp.add(lan);
        }
        lan.decrementTimer();
      }
      if (!temp.isEmpty()) {
        lanternfishes = new ArrayList<>(temp);
      }
      System.out.println("After day " + (day + 1) + ": " + lanternfishes);
    }
    System.out.println("\nNumber of lanternfish after " + days + " days: " + lanternfishes.size());
  }

  public static void main(String[] args) throws IOException {
    Part1 chall = new Part1();
    //chall.readData();
    chall.test();
    chall.process();
  }

  class Lanternfish {
    private int internalTimer;

    public Lanternfish(int internalTimer) {
      this.internalTimer = internalTimer;
    }

    public void decrementTimer() {
      this.internalTimer--;
    }

    public int getInternalTimer() {
      return internalTimer;
    }

    @Override
    public String toString() {
      return String.valueOf(internalTimer);
    }
  }
}





