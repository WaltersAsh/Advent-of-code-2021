package Day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Part1 {

  private List<List<Point>> segments = new ArrayList<>();
  private int[][] plot = new int[1000][1000];

  public void readData() throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("inputs/day-five-input.txt"));
    String line;

    while ((line = br.readLine()) != null) {
      String format = line.replaceAll("\\s", " ").replaceAll("-", "")
              .replaceAll(">", "").replaceAll(",", " ");
      Scanner sc = new Scanner(format);
      Point p1 = new Point(sc.nextInt(), sc.nextInt());
      Point p2 = new Point(sc.nextInt(), sc.nextInt());
      List<Point> segment = Arrays.asList(p1, p2);
      segments.add(segment);
      sc.close();
    }

    //strip non-horizontal and non-vertical segments
    List<List<Point>> temp = new ArrayList<>();
    for (List<Point> segment : segments) {
      Point p1 = segment.get(0);
      Point p2 = segment.get(1);
      if (p1.x == p2.x || p1.y == p2.y) {
        temp.add(segment);
        System.out.println(segment);
      }
    }
    segments = temp;
  }

  public void findOtherPoints() {
    for (List<Point> segment : segments) {
      Point p1 = segment.get(0);
      Point p2 = segment.get(1);
      if (p1.x == p2.x) {
        int min = Math.min(p1.y, p2.y);
        int max = Math.max(p1.y, p2.y);
        for (int i = min + 1; i < max; i++) {
          segment.add(new Point(p1.x, i));
        }
      }
      if (p1.y == p2.y) {
        int min = Math.min(p1.x, p2.x);
        int max = Math.max(p1.x, p2.x);
        for (int i = min + 1; i < max; i++) {
          segment.add(new Point(i, p1.y));
        }
      }
      System.out.println(segment);
    }
  }

  public void process() {

  }


  public static void main(String[] args) throws IOException {
    Part1 chall = new Part1();
    chall.readData();
  }

  class Point {
    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public String toString() {
      return "Point{" +
              "x=" + x +
              ", y=" + y +
              '}';
    }
  }
}
