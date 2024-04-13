public class QueenBoard {
  private int[][]board;
  private boolean animated = false;
  private int delay = 1000;
  private int solutions = 0;

  public QueenBoard(int size){
    board = new int[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++){
        board[i][j] = 0;
      }
    }
  }

  public String toString(){
    char queen = '\u265B';
    String result = "";
    result += "\n";
    int counter = 0;
    for (int i = 0; i < board.length; i++){
      for(int j = 0; j < board.length; j++){
        if (board[i][j] >= 0) {
          if (board.length % 2 == 0) {
            if(i % 2 == 0) {
              if (counter % 2 == 0){
                result += Text.colorize("  ", Text.WHITE+Text.BACKGROUND);
                counter++;
              }
              else {
                result += Text.colorize("  ", Text.BLACK+Text.BACKGROUND);
                counter++;
              }
            }
            else {
              if (counter % 2 == 0){
                result += Text.colorize("  ", Text.BLACK+Text.BACKGROUND);
                counter++;
              }
              else {
                result += Text.colorize("  ", Text.WHITE+Text.BACKGROUND);
                counter++;
              }
            }
          }
          else {
            if(i % 2 == 0) {
              if (counter % 2 == 0){
                result += Text.colorize("  ", Text.WHITE+Text.BACKGROUND);
                counter++;
              }
              else {
                result += Text.colorize("  ", Text.BLACK+Text.BACKGROUND);
                counter++;
              }
            }
            else {
              if (counter % 2 == 0){
                result += Text.colorize("  ", Text.WHITE+Text.BACKGROUND);
                counter++;
              }
              else {
                result += Text.colorize("  ", Text.BLACK+Text.BACKGROUND);
                counter++;
              }
            }
          }
        }
        else {
          if (board.length % 2 == 0) {
            if (i % 2 == 0) {
              if(counter % 2 == 0) {
                result += Text.colorize(queen + " ", Text.RED, Text.WHITE + Text.BACKGROUND);
                counter++;
              }
              else {
                result += Text.colorize(queen + " ", Text.RED, Text.BLACK + Text.BACKGROUND);
                counter++;
              }
            }
            else {
              if(counter % 2 == 0) {
                result += Text.colorize(queen + " ", Text.RED, Text.BLACK + Text.BACKGROUND);
                counter++;
              }
              else {
                result += Text.colorize(queen + " ", Text.RED, Text.WHITE + Text.BACKGROUND);
                counter++;
              }
            }
          }
          else {
            if (i % 2 == 0) {
              if(counter % 2 == 0) {
                result += Text.colorize(queen + " ", Text.RED, Text.WHITE + Text.BACKGROUND);
                counter++;
              }
              else {
                result += Text.colorize(queen + " ", Text.RED, Text.BLACK + Text.BACKGROUND);
                counter++;
              }
            }
            else {
              if(counter % 2 == 0) {
                result += Text.colorize(queen + " ", Text.RED, Text.WHITE + Text.BACKGROUND);
                counter++;
              }
              else {
                result += Text.colorize(queen + " ", Text.RED, Text.BLACK + Text.BACKGROUND);
                counter++;
              }
            }
          }
        }
      }
      result += "\n";
    }
    return result;
  }

  public String toStringDebug(){
    String result = "";
    result += "\n";
    for (int i = 0; i < board.length; i++){
      for(int j = 0; j < board.length; j++){
        if (board[i][j] >= 0) {
          result += board[i][j] + " ";
        }
        else {
          result += "Q" + " ";
        }
      }
      result += "\n";
    }
    return result;
  }

  public void setAnimate(boolean newValue) {
    this.animated = newValue;
  }

  public void setDelay(int newValue) {
    this.delay = newValue;
  }

  public boolean addQueen(int r, int c){
    if (board[r][c] == 0){
      for(int i = 0; i < board.length; i++){
        if (i != c) {
          board[r][i] += 1;
        }
      }
      for(int i = r + 1; i < board.length; i++){
        board[i][c] += 1;
      }
      for(int i = 1; i < board.length - r; i++){
        if (c - i >= 0) {
          board[r+i][c-i] += 1;
        }
        if (c + i < board.length) {
          board[r+i][c+i] += 1;
        }
      }
      board[r][c] = -1;
      return true;
    }
    return false;
  }

  public void removeQueen(int r, int c){
    if (board[r][c] == -1){
      for(int i = 0; i < board.length; i++){
        if (i != c) {
          board[r][i] -= 1;
        }
      }
      for(int i = r + 1; i < board.length; i++){
        board[i][c] -= 1;
      }
      for(int i = 1; i < board.length - r; i++){
        if (c - i >= 0) {
          board[r+i][c-i] -= 1;
        }
        if (c + i < board.length) {
          board[r+i][c+i] -= 1;
        }
      }
      board[r][c] = 0;
    }
  }

  public boolean solve(){
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++){
        if (board[i][j] != 0) {
          throw new IllegalStateException("Board not empty");
        }
      }
    }
    return solve(0);
  }

  public boolean solve(int row) {
    if (row >= board.length) {
      return true;
    }
    else {
      for (int c = 0; c < board.length; c++) {
        if(addQueen(row,c)) {
          if(animated){
            System.out.println(Text.go(1,1));
            System.out.println(this);//can modify here
            Text.wait(delay);
          }
          if (solve(row + 1)) {
            return true;
          }
          removeQueen(row,c);
          if(animated){
            System.out.println(Text.go(1,1));
            System.out.println(this);//can modify here
            Text.wait(delay);
          }
        }
      }
      return false;
    }
  }

  public int countSolutions() {
    return countSolutions(0);
  }

  public int countSolutions(int row){
    if (row >= board.length) {
      this.solutions += 1;
    }
    else {
      for (int c = 0; c < board.length; c++) {
        if(addQueen(row,c)) {
          if(animated){
            System.out.println(Text.go(1,1));
            System.out.println(this);//can modify here
            Text.wait(delay);
          }
          countSolutions(row + 1);
          removeQueen(row,c);
          if(animated){
            System.out.println(Text.go(1,1));
            System.out.println(this);//can modify here
            Text.wait(delay);
          }
        }
      }
    }
    return solutions;
  }

}
