import java.util.*;
import java.io.*;

public class Bronze {

  public static long solve(String filename) {
    long ans;
    long depth = 0;
    int[][] field;
    int row, col, finalElevation, numberOfStomps;
    try {
        File x = new File(filename);
        Scanner s = new Scanner(x);
        while (s.hasNextInt()) {
          row = s.nextInt();
          col = s.nextInt();
          field = new int[row][col];
          finalElevation = s.nextInt();
          numberOfStomps = s.nextInt();
          for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++) {
              field[i][j] = s.nextInt();
            }
          }
          for (int i = 0; i < numberOfStomps; i++) {
            stomp(field, s.nextInt() - 1, s.nextInt() - 1, s.nextInt());
          }
          for (int i = 0; i < field.length; i++){
            for (int j = 0; j < field[i].length; j++){
              field[i][j] = finalElevation - field[i][j];
              if (field[i][j] >= 0) {
                depth += field[i][j];
              }
            }
          }
          return depth * 72 * 72;
        }
      }
      catch (FileNotFoundException e) {
        System.out.println("file not found");
      }
      return -1;
    }

  public static void stomp(int[][] field, int startrow, int startcol, int down) {
    int max = field[startrow][startcol];
    for (int i = startrow; i <= startrow + 2; i++){
      for (int j = startcol; j <= startcol + 2; j++){
        if (field[i][j] > max) {
          max = field[i][j];
        }
      }
    }
    for (int x = 0; x < down; x++) {
      for (int i = startrow; i <= startrow + 2; i++){
        for (int j = startcol; j <= startcol + 2; j++){
          if (field[i][j] == max) {
            field[i][j]--;
          }
        }
      }
      max--;
    }
  }

  public static void main(String[] args) {
   System.out.println(Bronze.solve(args[0]));
  }
}
