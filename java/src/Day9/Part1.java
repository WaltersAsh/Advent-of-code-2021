package Day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Part1 {
  int[][] heights = new int[100][100];
  List<Integer> lowPoints = new ArrayList<>();

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

  public void process() {
    for (int row = 0; row < heights.length; row++) {
      for (int col = 0; col < heights[row].length; col++) {

        int below = 10;
        int above = 10;
        int rightside = 10;
        int leftside = 10;
        int current = heights[row][col];

        try {
          above = heights[row - 1][col];
        } catch (ArrayIndexOutOfBoundsException ignore) {
        }
        try {
          below = heights[row + 1][col];
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

        if (current < above && current < below && current < rightside && current < leftside) {
          System.out.println(current);
          lowPoints.add(current + 1);
        }
      }
    }

    int sum = 0;
    for (int lowPoint : lowPoints) {
      sum += lowPoint;
    }
    System.out.println("Low point risk levels sum: " + sum);
  }

  public static void main(String[] args) throws IOException {
    Part1 chall = new Part1();
    chall.readData();
    //chall.test();
    chall.process();
  }
}
