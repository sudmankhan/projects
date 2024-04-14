import java.util.*;
import java.io.*;

public class Wrapping {

  public static void main(String[] args) {
    String filename = args[0];
    int num = Integer.parseInt(args[1]);
    if (num == 1) {
      System.out.println(surfaceArea(filename));
    }
    if (num == 2) {
      System.out.println(perimeter(filename));
    }
  }

  public static int surfaceArea(String filename) {
    try {
      File data = new File(filename);
      Scanner input = new Scanner(data);
      int num = 0;
      while (input.hasNextLine()) {
        String line = input.nextLine();
        String[] nums = line.split("x");
        int length = Integer.parseInt(nums[0]);
        int width = Integer.parseInt(nums[1]);
        int height = Integer.parseInt(nums[2]);
        int a = length*width;
        int b = width*height;
        int c = height*length;
        num += (2*a+2*b+2*c);
        num += Math.min(Math.min(a, b), c);
      }
      return num;
    }
    catch (FileNotFoundException e) {
      System.out.println("ehrur: file not found");
      return -1;
    }
  }

  public static int perimeter(String filename) {
    try {
      File data = new File(filename);
      Scanner input = new Scanner(data);
      int num = 0;
      while (input.hasNextLine()) {
        String line = input.nextLine();
        String[] nums = line.split("x");
        int length = Integer.parseInt(nums[0]);
        int width = Integer.parseInt(nums[1]);
        int height = Integer.parseInt(nums[2]);
        int a = 2 * (length + width);
        int b = 2 * (length + height);
        int c = 2 * (height + width);
        num += Math.min(Math.min(a, b), c);
        num += length * width * height;
      }
      return num;
    }
    catch (FileNotFoundException e) {
      System.out.println("ehrur: file not found");
      return -1;
    }
  }

}
