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
  private List<Bingo> bestBingos;

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
    int hasNum = 0;
    for (int row = 0; row < bingo.board.length; row++) {
      if (hasNum == bingo.board.length) {
        bingo.hasWon = true;
        return true;
      }
      for (int j = 0; j < bingo.board[row].length; j++) {
        if (bingo.board[row][j] == -1) {
          hasNum++;
        }
      }
    }

    //check col
    hasNum = 0;
    for (int col = 0; col < bingo.board[0].length; col++) {
      if (hasNum == bingo.board[0].length) {
        bingo.hasWon = true;
        return true;
      }
      for (int row = 0; row < bingo.board[col].length; row++) {
        if (bingo.board[row][col] == -1) {
          hasNum++;
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

  public void process() {
    int best = 0;
    for (int calledNum : calledNums) {
      for (Bingo bingo : bingos) {
        if (bingo.hasWon) {
          break;
        }
        mark(bingo, calledNum);
      }
      for (Bingo bingo : bingos) {
        if (bingo.hasWon) {
          break;
        }
        if (hasWon(bingo)) {
          int score = calculateScore(bingo, calledNum);
          System.out.println(score);
          if (score > best) {
            best = score;
          }
        }
      }
    }
    System.out.println(best);
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

  public static void main(String[] args) throws IOException {
    Part1 chall = new Part1();
    chall.readData();
    chall.process();
  }

}

class Bingo {
  int[][] board;
  boolean hasWon;

  public Bingo(int[][] board, boolean hasWon) {
    this.board = board;
    this.hasWon = hasWon;
  }
}
