import java.io.*;
import java.util.*;

public class Maze {
//char[][]
  public static char[][] readMaze(String filename) {
    int col = 0;
    int row = 0;
    ArrayList<String> temp = new ArrayList<String>();
    try {
      File maze = new File(filename);
      Scanner x = new Scanner(maze);
      String columns = x.nextLine();
      temp.add(columns);
      col += columns.length();
      while (x.hasNextLine()) {
        row++;
        temp.add(x.nextLine());
      }
    }
    catch (FileNotFoundException e){
      System.out.println("No such file");
      System.exit(1);
    }
    char[][] arr = new char[row + 1][col];
    for (int i = 0; i < arr.length; i++){
      arr[i] = temp.get(i).toCharArray();
    }
    return arr;
  }

  public static void main(String[] args) {
    System.out.println();
    char[][] x = readMaze("Maze1.txt");
    for (int i = 0; i < x.length; i++){
      for (int j = 0; j < x[i].length; j++){
        System.out.print(x[i][j]);
      }
      System.out.println(" ");
    }
    System.out.println();
  }
}
