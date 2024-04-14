import java.util.*;
import java.io.*;

public class MazeTester {

  public static void main(String[] args) {
    // try {
    //   Maze x = new Maze("maze4.txt");
    //   x.setAnimate(true);
    //   System.out.println(x.solve());
    // }
    // catch (FileNotFoundException e){
    //   System.out.println("No such file");
    //   System.exit(1);
    // }
    char[][] maze = new char[10][30];
    MazeGenerator.generate(maze,5,4);
  }

}
