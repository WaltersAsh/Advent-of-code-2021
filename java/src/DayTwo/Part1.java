package DayTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1 {

  public static void main(String[] args) throws FileNotFoundException {
    List<String> inputs = new ArrayList<>();
    File file = new File("inputs/day-two-input.txt");
    Scanner sc = new Scanner(file);

    int horiz = 0;
    int depth = 0;

    while (sc.hasNext()) {
      switch (sc.next()) {
        case "forward":
          horiz += sc.nextInt();
          break;
        case "up":
          depth -= sc.nextInt();
          break;
        case "down":
          depth += sc.nextInt();
        default:
          break;
      }
    }
    System.out.println("Final horizontal position: " + horiz);
    System.out.println("Final depth: " + depth);
    System.out.println("Final result (Multiplied): " + horiz * depth);
  }
}
