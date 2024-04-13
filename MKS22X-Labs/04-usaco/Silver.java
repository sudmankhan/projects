import java.util.*;
import java.io.*;
public class Silver {

  public static long solve(String filename) {
    int[][] field;
    int row, col, time;
    int r1, c1, r2, c2;
    try {
        File x = new File(filename);
        Scanner s = new Scanner(x);
        while (s.hasNext()) {
          row = s.nextInt();
          col = s.nextInt();
          time = s.nextInt();
          field = new int[row][col];
          for (int i = 0; i < row; i++){
            String temp = s.next();
            for (int j = 0; j < col; j++) {
              if (temp.charAt(j) == '.') {
                field[i][j] = 0;
              }
              else {
                field[i][j] = -1;
              }
            }
          }
          r1 = s.nextInt() - 1;
          c1 = s.nextInt() - 1;
          r2 = s.nextInt() - 1;
          c2 = s.nextInt() - 1;
          field[r1][c1] = 1;
          for (int count = 0; count < time; count++){
            int[][] temp = new int[row][col];
            for (int i = 0; i < row; i++){
              for (int j = 0; j < col; j++) {
                temp[i][j] = field[i][j];
              }
            }
            field = sHelper(field,temp,r1,c1,row,col);
          }
          return field[r2][c2];
        }
      }
      catch (FileNotFoundException e) {
        System.out.println("file not found");
      }
      return -1;
  }

  public static int[][] sHelper(int[][] field, int[][] temp, int startrow, int startcol, int row, int col) {
    for (int i = 0; i < row; i++){
      for (int j = 0; j < col; j++) {
        int sumToBeAdded = 0;
        if (i > 0){
          if (field[i-1][j] >= 0) {
            sumToBeAdded += field[i-1][j];
          }
        }
        if (i < field.length - 1) {
          if (field[i+1][j] >= 0) {
            sumToBeAdded += field[i+1][j];
          }
        }
        if (j > 0){
          if (field[i][j-1] >= 0) {
            sumToBeAdded += field[i][j-1];
          }
        }
        if (j < field[i].length - 1) {
          if (field[i][j+1] >= 0) {
            sumToBeAdded += field[i][j+1];
          }
        }
        if (temp[i][j] >= 0) {
          temp[i][j] = sumToBeAdded;
        }
      }
    }
    return temp;
  }

  public static void main(String[] args) {
    System.out.println(Silver.solve(args[0]));
  }
}
