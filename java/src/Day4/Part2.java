package Day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Part2 {

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

  public void process() {
    Map<Integer, Integer> map = new LinkedHashMap<>();

    for (int num : calledNums) {
      for (Bingo bingo : bingos) {
        if (bingo.hasWon) {
          continue;
        }
        mark(bingo, num);
      }
      for (Bingo bingo : bingos) {
        if (bingo.hasWon) {
          continue;
        }
        if (hasWon(bingo)) {
          int score = calculateScore(bingo, num);
          map.put(score, num);
        }
      }
    }

    Set<Integer> keys = map.keySet();
    Iterator<Integer> it = keys.iterator();
    Integer last = 0;
    while (it.hasNext()) {
      last = it.next();
    }
    System.out.println("Last board to win score: " + last);
  }


  public static void main(String[] args) throws IOException {
    Part2 chall = new Part2();
    chall.readData();
    chall.process();
  }
}

