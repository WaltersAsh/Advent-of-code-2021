package Day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Part1 {
  int[][] heights = new int[100][100];

  public void readData() throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("inputs/day-nine-input.txt"));
    String line;

    int row = 0;
    while ((line = br.readLine()) != null) {
      char[] nums = line.toCharArray();
      int col = 0;
      while (col < 100) {
        heights[row][col] = nums[col] - '0'; //convert char to its actual int value
        col++;
      }
      row++;
    }
    System.out.println(Arrays.deepToString(heights).replace("], ", "]\n").replace("[[",
            "[").replace("]]", "]"));
  }

  public void test() {
    heights = new int[][]{
            {2, 1, 9, 9, 9, 4, 3, 2, 1, 0},
            {3, 9, 8, 7, 8, 9, 4, 9, 2, 1},
            {9, 8, 5, 6, 7, 8, 9, 8, 9, 2},
            {8, 7, 6, 7, 8, 9, 6, 7, 8, 9},
            {9, 8, 9, 9, 9, 6, 5, 6, 7, 8}
    };
  }

  public boolean checkAdjacentCells(int row, int col, String pos) {
    int current = heights[row][col];

    int below = -1;
    int above = -1;
    int rightside = -1;
    int leftside = -1;

    try {
      below = heights[row + 1][col];
    } catch (ArrayIndexOutOfBoundsException ignore) {
    }
    try {
      above = heights[row - 1][col];
    } catch (ArrayIndexOutOfBoundsException ignore) {
    }
    try {
      rightside = heights[row][col + 1];
    } catch (ArrayIndexOutOfBoundsException ignore) {
    }
    try {
      leftside = heights[row][col - 1];
    } catch (ArrayIndexOutOfBoundsException ignore) {
    }

    switch (pos) {
      case "TL":
        return current < below && current < rightside;

      case "TR":
        return current < leftside && current < below;

      case "BL":
        return current < above && current < rightside;

      case "BR":
        return current < leftside && current < above;

      case "TM":
        return current < below && current < leftside && current < rightside;

      case "BM":
        return current < above && current < leftside && current < rightside;

      default:
        return current < above && current < below && current < rightside && current < leftside;
    }
  }

  public void process() {
    int riskLvls = 0;

    for (int row = 0; row < heights.length; row++) {
      for (int col = 0; col < heights[row].length; col++) {

        int current = heights[row][col];

        if (row == 0) {
          if (col == 0) {
            if (checkAdjacentCells(row, col, "TL")) {
              riskLvls += current + 1;
            }

          } else if (col == heights[row].length - 1) {
            if (checkAdjacentCells(row, col, "TR")) {
              riskLvls += current + 1;
            }

          } else {
            if (checkAdjacentCells(row, col, "TM")) {
              riskLvls += current + 1;
            }
          }
        } else if (row == heights.length - 1) {
          if (col == 0) {
            if (checkAdjacentCells(row, col, "BL")) {
              riskLvls += current + 1;
            }

          } else if (col == heights[row].length - 1) {
            if (checkAdjacentCells(row, col, "BR")) {
              riskLvls += current + 1;
            }

          } else {
            if (checkAdjacentCells(row, col, "BM")) {
              riskLvls += current + 1;
            }
          }
        } else {
          if (checkAdjacentCells(row, col, "wub")) {
            riskLvls += current + 1;
          }
        }
      }
      //System.out.println(riskLvls);
    }
    System.out.println("\nSum of risk levels of all low points: " + riskLvls);
  }

  public static void main(String[] args) throws IOException {
    Part1 chall = new Part1();
    chall.readData();
    //chall.test();
    chall.process();
  }

}
