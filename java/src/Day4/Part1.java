package Day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Part1 {

  private List<Integer> calledNums;
  private List<Bingo> bingos;

  public void readData() throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("inputs/day-four-input.txt"));
    String line;

    calledNums = new ArrayList<>();
    String nums = br.readLine().replaceAll("\\s*,\\s*", " ");
    Scanner sca = new Scanner(nums);

    while (sca.hasNext()) {
      calledNums.add(sca.nextInt());
    }
    System.out.println("Called numbers:\n" + calledNums);
    br.readLine();
    bingos = new ArrayList<>();

    System.out.println("\nBoards Loaded:");
    while ((line = br.readLine()) != null) {
      int[][] board = new int[5][5];
      Scanner sc = new Scanner(line);
      for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
          if (!sc.hasNext()) {
            sc.close();
            sc = new Scanner(br.readLine());
          }
          board[i][j] = sc.nextInt();
        }
      }
      System.out.println(Arrays.deepToString(board).replace("], ", "]\n") + "\n");
      bingos.add(new Bingo(board, false));
      br.readLine();
    }
    System.out.println("------------------------------------------------------------------------------");
  }

  public void mark(Bingo bingo, int calledNum) {
    for (int row = 0; row < bingo.board.length; row++) {
      for (int col = 0; col < bingo.board[row].length; col++) {
        if (bingo.board[row][col] == calledNum) {
          bingo.board[row][col] = -1;
        }
      }
    }
  }

  public boolean hasWon(Bingo bingo) {

    //check row
    int hasRow;
    for (int row = 0; row < bingo.board.length; row++) {
      hasRow = 0;
      for (int j = 0; j < bingo.board[row].length; j++) {
        if (bingo.board[row][j] == -1) {
          hasRow++;
          if (hasRow == bingo.board.length) {
            bingo.hasWon = true;
            return true;
          }
        }
      }
    }

    //check col
    int hasCol;
    for (int col = 0; col < bingo.board[0].length; col++) {
      hasCol = 0;
      for (int row = 0; row < bingo.board[col].length; row++) {
        if (bingo.board[row][col] == -1) {
          hasCol++;
          if (hasCol == bingo.board[0].length) {
            bingo.hasWon = true;
            return true;
          }
        }
      }
    }

    return false;
  }

  public int calculateScore(Bingo bingo, int lastNumCalled) {
    int unmarkedScore = 0;
    for (int row = 0; row < bingo.board.length; row++) {
      for (int col = 0; col < bingo.board[row].length; col++) {
        if (bingo.board[row][col] != -1) {
          unmarkedScore += bingo.board[row][col];
        }
      }
    }
    return unmarkedScore * lastNumCalled;
  }

  public int process() {
    for (int num : calledNums) {
      for (Bingo bingo : bingos) {
        mark(bingo, num);
      }
      for (Bingo bingo : bingos) {
        if (hasWon(bingo)) {
          return calculateScore(bingo, num);
        }
      }
    }
    return -1;
  }

  public void test() {

    int[][] wub = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
    };

    for (int col = 0; col < wub[0].length; col++) {
      for (int row = 0; row < wub.length; row++) {
        System.out.print(wub[row][col] + " ");
      }
    }
    System.out.println(" ");
    for (int row = 0; row < wub.length; row++) {
      for (int col = 0; col < wub[0].length; col++) {
        System.out.print(wub[row][col] + " ");
      }
    }
  }

  public void testerino() {
    calledNums = Arrays.asList(7, 4, 9, 5, 11, 17, 23, 2, 0, 14, 21, 24, 10, 16, 13, 6, 15, 25, 12, 22, 18, 20, 8, 19,
            3, 26, 1);
    bingos = new ArrayList<>();

    int[][] one = new int[][]{
            {22, 13, 17, 11, 0},
            {8, 2, 23, 4, 24},
            {21, 9, 14, 16, 7},
            {6, 10, 3, 18, 5},
            {1, 12, 20, 15, 19}
    };

    int[][] two = new int[][]{
            {3, 15, 0, 2, 22},
            {9, 18, 13, 17, 5},
            {19, 8, 7, 25, 23},
            {20, 11, 10, 24, 4},
            {14, 21, 16, 12, 6}

    };

    int[][] three = new int[][]{
            {14, 21, 17, 24, 4},
            {10, 16, 15, 9, 19},
            {18, 8, 23, 26, 20},
            {22, 11, 13, 6, 5},
            {2, 0, 12, 3, 7}

    };
    bingos.add(new Bingo(one, false));
    bingos.add(new Bingo(two, false));
    bingos.add(new Bingo(three, false));
  }

  public static void main(String[] args) throws IOException {
    Part1 chall = new Part1();
    chall.readData();
    //chall.testerino();
    System.out.println("First board to win score: " + chall.process());
  }
}

class Bingo {
  int[][] board;
  int[][] originalBoard;
  boolean hasWon;

  public Bingo(int[][] board, boolean hasWon) {
    this.board = board;
    this.hasWon = hasWon;
  }
}
