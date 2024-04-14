import java.util.*;
import java.io.*;

public class Non {

  public static void main(String[] args) {
    String filename = args[0];
    int num = Integer.parseInt(args[1]);
    if (num == 1) {
      System.out.println(non(filename));
    }
    if (num == 2) {
      System.out.println(non2(filename));
    }
  }

  public static int non(String filename) {
    try {
      File data = new File(filename);
      Scanner input = new Scanner(data);
      int num = 0;
      while (input.hasNextLine()) {
        String line = input.nextLine();
        int vowels = 0;
        for (int i = 0; i < line.length(); i++) {
          if (line.charAt(i) == ('a')
          || line.charAt(i) == ('e')
          || line.charAt(i) == ('i')
          || line.charAt(i) == ('o')
          || line.charAt(i) == ('u')) {
            vowels++;
          }
        }
        int next = 0;
        for (int i = 0; i < line.length()-1; i++) {
          if (line.charAt(i) == line.charAt(i+1)) {
            next++;
          }
        }
        boolean no = false;
        if (line.indexOf("ab") == -1 &&
        line.indexOf("cd") == -1 &&
        line.indexOf("pq") == -1 &&
        line.indexOf("xy") == -1) {
          no = true;
        }
        if (vowels >= 3 && next >= 1 && no){
          num++;
        }
      }
      return num;
    }
    catch (FileNotFoundException e) {
      System.out.println("ehrur: file not found");
      return -1;
    }
  }

  public static int non2(String filename) {
    try {
      File data = new File(filename);
      Scanner input = new Scanner(data);
      int num = 0;
      while (input.hasNextLine()) {
        String line = input.nextLine();
        int between = 0;
        for (int i = 0; i < line.length()-2; i++) {
          if (line.charAt(i) == line.charAt(i+2)) {
            between++;
          }
        }
        int count = 0;
        for (int i = 0; i < line.length()-1; i++) {
          String temp = line.substring(i, i+2);
          if (line.indexOf(temp) != line.lastIndexOf(temp) && (line.lastIndexOf(temp) - line.indexOf(temp) > 1)) {
            count++;
          }
        }
        if (count >= 2 && between >= 1){
          num++;
        }
      }
      return num;
    }
    catch (FileNotFoundException e) {
      System.out.println("ehrur: file not found");
      return -1;
    }
  }

}
