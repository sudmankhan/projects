import java.util.*;
import java.io.*;

public class Triangles {

  public static void main(String[] args) {
    String filename = args[0];
    int mode = Integer.parseInt(args[1]);
    if (mode == 1) {
      part1(filename);
    }
    if (mode == 2) {
      part2(filename);
    }
  }

  public static void part1(String filename) {
    try {
      File data = new File(filename);
      Scanner input = new Scanner(data);
      int num = 0;
      while (input.hasNextInt()) {
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        if (a + b > c && a + c > b && b + c > a) {
          num++;
        }
      }
      System.out.println(num);
      input.close();
    }
    catch (FileNotFoundException e) {
      System.out.println("ehrur: file not found");
    }
  }

  public static void part2(String filename) {
    try {
      File data = new File(filename);
      Scanner input = new Scanner(data);
      int num = 0;
      while (input.hasNextInt()) {
        int a = input.nextInt();
        int d = input.nextInt();
        int g = input.nextInt();

        int b = input.nextInt();
        int e = input.nextInt();
        int h = input.nextInt();

        int c = input.nextInt();
        int f = input.nextInt();
        int i = input.nextInt();

        if (a + b > c && a + c > b && b + c > a) {
          num++;
        }
        if (d + e > f && d + f > e && e + f > d) {
          num++;
        }
        if (g + h > i && g + i > h && h + i > g) {
          num++;
        }
      }
      System.out.println(num);
      input.close();
    }
    catch (FileNotFoundException e) {

    }
  }

}
