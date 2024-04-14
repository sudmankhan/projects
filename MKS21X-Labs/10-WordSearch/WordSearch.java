import java.util.*;
import java.io.*;
public class WordSearch{
  private char[][] grid;
  private ArrayList<String> wordsAdded;
  private Random rng;
  private int seed;

  public static void main(String[] args) {
    int row = Integer.parseInt(args[0]);
    int cols = Integer.parseInt(args[1]);
    String file = args[2];
    int mode = Integer.parseInt(args[3]);
    if (args.length == 5) {
      int seed = Integer.parseInt(args[4]);
      WordSearch x = new WordSearch(row, cols, file, seed);
      if (mode == 0) {
        x.fillInRandomLetters();
      }
      System.out.println(x);
    } else {
      WordSearch x = new WordSearch(row, cols, file);
      if (mode == 0) {
        x.fillInRandomLetters();
      }
      System.out.println(x);
    }
  }

  //assume a rectangular grid
  private void addAllWords(String filename){
    ArrayList<String> wordsToAdd = loadWordsFromFile(filename);
    //System.out.println(wordsToAdd);
    Random rng = new Random(seed);
    while (wordsToAdd.size() > 0) {
      int j = Math.abs((rng.nextInt() % (wordsToAdd.size())));
      String current = wordsToAdd.remove(j);
      for (int x = 0; x <= 100; x++) {
        int row = Math.abs((rng.nextInt() % (grid.length)));
        int col = Math.abs((rng.nextInt() % (grid[0].length)));
        int r = rng.nextInt() % 2;
        int c = rng.nextInt() % 2;
        if(addWord(current, row, col, r, c)) {
          x = 101;
        }
      }
    }
  }

  public void fillInRandomLetters() {
    Random rng = new Random(seed);
    for(int r = 0; r < grid.length; r++){
      for(int c = 0; c < grid[r].length; c++) {
        if (grid[r][c] == '_') {
          grid[r][c] = (char) ('A' + (rng.nextInt(25)));
        }
      }
    }
  }

  public WordSearch(int rows,int cols, String fileName){
    rng = new Random();
    seed = rng.nextInt();
    rng = new Random(seed);
    grid = new char[rows][cols];
    clear();
    wordsAdded = new ArrayList<String>();
    addAllWords(fileName);
  }

  public WordSearch(int rows,int cols, String fileName, int s){
    seed = s;
    rng = new Random(seed);
    grid = new char[rows][cols];
    clear();
    wordsAdded = new ArrayList<String>();
    addAllWords(fileName);
  }

  public static ArrayList<String> loadWordsFromFile(String fileName){
    ArrayList<String>words = new ArrayList<String>();
    try{
      Scanner input = new Scanner(new File(fileName));
      while(input.hasNextLine()){
        String line = input.nextLine();
        if(! line.equals("")){
          words.add(line.toUpperCase());
        }
      }
    }catch(FileNotFoundException e){
      System.out.println(e);
      System.exit(1);
    }
    return words;
  }



  private void clear(){
    for(int r = 0; r < grid.length; r++){
      for(int c = 0; c < grid[r].length; c++){
        grid[r][c]='_';
      }
    }
  }


  //precondition word grids are rectangular
  private boolean inBounds(int r, int c){
    return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
  }
  public boolean addWord(String word,int row, int col, int dr, int dc){
    //make sure there is some non 0 vector for direction
    if(dr == 0 && dc == 0){
      return false;
    }
    //check endpoints of word
    if(!inBounds(row,col) || !inBounds(row + dr * (word.length() - 1), col + dc * (word.length() - 1 ))){
      return false;
    }
    //check for conflicting letters
    for(int i = 0; i < word.length(); i++){
      char c = grid[row + i * dr][col + i * dc];
      if(c != '_' && c != word.charAt(i)){
        return false;
      }
    }
    //change
    for(int i = 0; i < word.length(); i++){
      grid[row + i * dr][col + i * dc] = word.charAt(i);
    }
    wordsAdded.add(word);
    return true;
  }

  public String toString(){
    String ans = "";
    for(int r = 0; r < grid.length; r++){
      for(int c = 0; c < grid[r].length; c++){
        ans += grid[r][c]+" ";
      }
      ans+="\n";
    }
    ans += "words: ";
    for(String word:wordsAdded){
      ans+= word+" ";
    }
    ans += "\nseed: "+seed;
    return ans;
  }
}
