package Day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

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
    System.out.println(Arrays.deepToString(heights).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
  }

  public void process() {

    /*
    Edge cases

    Top left busta - [0][0], check for [1][0] and [0][1]
    Top right corner - [0][col.length - 1], check for [0][col.length - 2] and [1][col.length - 1]
    Bottom left corner - [row.length - 1][0], check for [row.length - 2][0] and [row.length - 1][0]
    Bottom right corner - [row.length - 1][col.length - 1], check for [row.length - 1][col.length - 2] and
    [row.length - 2][col.length - 1]
    Top row (excl corners) - [0][col...col - 2], check for: left, right, and below
    Bottom row (excl corners) - [row.length - 1][col...col - 2], check for: left, right, and above

    everything else - check for [n - 1][n], [n][n + 1], [n + 1][n], [n][n - 1]
     */

    for (int row = 0; row < heights.length; row++) {
      for (int col = 0; col < heights[row].length; col++) {
        if (row == 0) {
          if (col == 0) {

          } else if (col == heights[row].length - 1) { //top left

          } else {

          }
        } else if (row == heights.length - 1) {
          if (col == 0) {

          } else if (col == heights[row].length - 1) {

          } else {

          }
        } else {

        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    Part1 chall = new Part1();
    chall.readData();
  }

}
