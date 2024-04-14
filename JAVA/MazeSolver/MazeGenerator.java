import java.util.ArrayList;

public class MazeGenerator {

  public static void generate(char[][] maze, int startrow, int startcol){
    carve(maze, startrow, startcol);
    
    maze[startrow][startcol] = 'S';

    int eRow = Math.abs(maze.length - 1 - startrow);
    int eCol = Math.abs(maze[startrow].length - 1 - startcol);
    maze[eRow][eCol] = 'E';
  }


  public static void carve(char[][] maze,int row, int col){
      //can carve: not on border, not a space, fewer than 2 neighboring spaces
    if(canCarve(maze,row,col)){
      //change to a space
      maze[row][col] = ' ';
      //make an arrayList of directions i made the directions: [row offset , col offset]
      ArrayList<int[]>directions = new ArrayList<int[]>();
      //fill up the arrayList Here
      directions.add(new int[]{0, -1});
      directions.add(new int[]{0, 1});
      directions.add(new int[]{-1, 0});
      directions.add(new int[]{1, 0});

      while(directions.size() > 0){
        //choose a direction randomly:
        int randDirection = (int)(Math.random() * (directions.size()));
        int[] direction = directions.remove(randDirection);
        carve(maze, row + direction[0], col + direction[1]);
      }
    }

  }

  public static boolean canCarve(char[][] maze, int row, int col) {
    if (row <= 0 || col <= 0 || row >= maze.length - 1 || col >= maze[row].length - 1) {
      return false;
    }

    int neighbors = 0;
    if (maze[row+1][col] == ' '){
      neighbors++;
    }
    if (maze[row-1][col] == ' '){
      neighbors++;
    }
    if (maze[row][col-1] == ' '){
      neighbors++;
    }
    if (maze[row][col+1] == ' '){
      neighbors++;
    }

    if (neighbors >= 2) {
      return false;
    }

    if (maze[row][col] == ' ') {
      return false;
    }

    return true;
  }

}
