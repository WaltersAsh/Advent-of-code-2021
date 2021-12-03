package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part2 {

  public static void main(String[] args) throws FileNotFoundException {
    File file = new File("inputs/day-two-input.txt");
    Scanner sc = new Scanner(file);

    int horiz = 0;
    int depth = 0;
    int aim = 0;

    while (sc.hasNext()) {
      switch (sc.next()) {
        case "forward":
          int x = sc.nextInt();
          horiz += x;
          depth += aim * x;
          break;
        case "up":
          aim -= sc.nextInt();
          break;
        case "down":
          aim += sc.nextInt();
        default:
          break;
      }
    }
    System.out.println("Final horizontal position: " + horiz);
    System.out.println("Final depth: " + depth);
    System.out.println("Final aim: " + aim);
    System.out.println("Final result (Multiplied): " + horiz * depth);
  }
}
