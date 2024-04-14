import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception
public class WordSearch{
    private char[][]data;
    private int seed; //the random seed used to produce this WordSearch
    private Random randgen; //a random Object to unify your random calls
    private ArrayList<String>wordsAdded; //all words that were successfully added get moved into wordsAdded.

    /*New Constructors:  Both will read in the word text file, then run addAllWords().
     *Do not fill in random letters after.*/

    public WordSearch(int rows, int cols, String filename){
         //Choose a randSeed using the clock random
         addAllWords(filename);
         System.out.println(wordsAdded.get(1));
    }
    //
    // public WordSearch( int rows, int cols, String fileName, int randSeed){
    //     //Use the random seed specified.
    // }

    /**Attempts to add a given word to the specified position of the WordGrid.
    *The word is added in the direction rowIncrement,colIncrement
    *Words must have a corresponding letter to match any letters that it overlaps.
    *
    *@param word is any text to be added to the word grid.
    *@param row is the vertical locaiton of where you want the word to start.
    *@param col is the horizontal location of where you want the word to start.
    *@param rowInc is -1,0, or 1 and represents the displacement of each letter in the row direction
    *@param colInc is -1,0, or 1 and represents the displacement of each letter in the col direction
    *@return true when: the word is added successfully.
    *        false (and do not change the board at all) when any of the following happen:
    *        a) rowInc and colInc are both 0,
    *        b) the word doesn't fit,
    *        c) there are overlapping letters that do not match
    */
    private boolean addWord(String word,int row, int col, int rowInc, int colInc) {
      if ((data.length-1 - (row*rowInc) >= word.length()-1) && (data.length-1 - (col*colInc) >= word.length()-1)) {
        for (int i = 0; i < word.length(); i++) {
          if (data[row + (i * rowInc)][col+ (i * colInc)] != word.charAt(i) && data[row + (i * rowInc)][col+ (i * colInc)] != '_') {
            return false;
          }
        }
        data[row][col] = word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
          data[row + (i * rowInc)][col+ (i * colInc)] = word.charAt(i);
        }
        return true;
      } else {
        return false;
      }
    }


    private void addAllWords(String filename) {
      wordsAdded = new ArrayList<String>();
      try {
        File data = new File(filename);
        Scanner input = new Scanner(data);
        while (input.hasNext()) {
          String word = input.next();
          wordsAdded.add(word);
         }
         
       }
       catch (FileNotFoundException e) {
         System.out.println("ehrur: file not found");
       }
    }

    /* THE REST OF YOUR METHODS HERE*/
    public WordSearch(int rows, int cols) {
      data = new char[rows][cols];
      for(int i = 0; i < rows; i++){
        for(int x = 0; x < cols; x++) {
          data[i][x] = '_';
        }
      }
    }

    private void clear(){
      for(int i = 0; i < data.length; i++){
        for(int x = 0; x < data[i].length; x++) {
          data[i][x] = '_';
        }
      }
    }

    /**Each row is a new line, there is a space between each letter
     *@return a String with each character separated by spaces, and rows
     *separated by newlines.
     */
    public String toString() {
      String puzzle = "";
      for (int i = 0; i < data.length; i++) {
        for(int x = 0; x < data[i].length; x++) {
          puzzle += data[i][x];
          puzzle += " ";
        }
        puzzle += "\n";
      }
      return puzzle;
    }

     /**Attempts to add a given word to the specified position of the WordGrid.
      *The word is added from left to right, must fit on the WordGrid, and must
      *have a corresponding letter to match any letters that it overlaps.
      *
      *@param word is any text to be added to the word grid.
      *@param row is the vertical locaiton of where you want the word to start.
      *@param col is the horizontal location of where you want the word to start.
      *@return true when the word is added successfully. When the word doesn't fit,
      * or there are overlapping letters that do not match, then false is returned
      * and the board is NOT modified.
      */
    // public boolean addWordHorizontal(String word,int row, int col) {
    //   if (data.length-1 - col >= word.length()-1) {
    //     for (int i = 0; i < word.length(); i++) {
    //       if (data[row][col+i] != word.charAt(i) && data[row][col+i] != '_') {
    //         return false;
    //       }
    //     }
    //     data[row][col] = word.charAt(0);
    //     for (int i = 1; i < word.length(); i++) {
    //       data[row][col+i] = word.charAt(i);
    //     }
    //     return true;
    //   } else {
    //     return false;
    //   }
    // }

    /**Attempts to add a given word to the specified position of the WordGrid.
      *The word is added from top to bottom, must fit on the WordGrid, and must
      *have a corresponding letter to match any letters that it overlaps.
      *
      *@param word is any text to be added to the word grid.
      *@param row is the vertical locaiton of where you want the word to start.
      *@param col is the horizontal location of where you want the word to start.
      *@return true when the word is added successfully. When the word doesn't fit,
      *or there are overlapping letters that do not match, then false is returned.
      *and the board is NOT modified.
      */
    // public boolean addWordVertical(String word,int row, int col) {
    //   if (data.length-1 - row >= word.length()-1) {
    //     for (int i = 0; i < word.length(); i++) {
    //       if (data[row+i][col] != word.charAt(i) && data[row+i][col] != '_') {
    //         return false;
    //       }
    //     }
    //     data[row][col] = word.charAt(0);
    //     for (int i = 1; i < word.length(); i++) {
    //         data[row+i][col] = word.charAt(i);
    //     }
    //     return true;
    //   } else {
    //     return false;
    //   }
    //
    //
    // }

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top left towards the bottom right, it must fit on the board,
     *and must have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned
     *and the board is not modified.
     */
    // public boolean addWordDiagonal(String word,int row, int col) {
    //   if ((data.length-1 - row >= word.length()-1) && (data.length-1 - col >= word.length()-1)) {
    //     for (int i = 0; i < word.length(); i++) {
    //       if (data[row+i][col+i] != word.charAt(i) && data[row+i][col+i] != '_') {
    //         return false;
    //       }
    //     }
    //     data[row][col] = word.charAt(0);
    //     for (int i = 1; i < word.length(); i++) {
    //       if (data[row+i][col+i] == '_' || data[row+i][col+i] == word.charAt(i)) {
    //           data[row+i][col+i] = word.charAt(i);
    //         } else {
    //             return false;
    //         }
    //     }
    //     return true;
    //   } else {
    //     return false;
    //   }
    // }

}
