import java.util.*;
public class BurnTrees{
  private int[][]map;
  private int ticks;
  private static final int TREE = 2;
  private static final int FIRE = 1;
  private static final int ASH = 3;
  private static final int SPACE = 0;
  private ArrayDeque<int[]> frontier;

  /*Determine if the simulation is still burning
   *@return false if any fires are still burning, true otherwise
   */
  public boolean done(){
    //YOU MUST IMPLEMENT THIS METHOD
    //(BEFORE WRITING ANY CODE READ ALL OF THE CODE AND SEE HOW IT FITS TOGETHER)
    //HINT: do not check the board for fire which is an n^2 operation
    return frontier.size() == 0;
    //return false;//placeholder for compilation purposes
  }


  /*This is the core of the simulation. All of the logic for advancing to the next round goes here.
   *All existing fires spread new fires, and turn to ash
   *new fires should remain fire, and not spread.
   */
  public void tick(){
    ticks++;//leave this here.
    //YOU MUST IMPLEMENT THE REST OF THIS METHOD
    //(BEFORE WRITING ANY CODE READ ALL OF THE CODE AND SEE HOW IT FITS TOGETHER)
    int times = frontier.size();
    for (int i = 0; i < times; i++) {
      try {
        int ycor = frontier.element()[0];
        int xcor = frontier.element()[1];
        if (xcor+1 < map[0].length) {
          if(map[ycor][xcor+1] == TREE) {
            map[ycor][xcor+1] = FIRE;
            int[] temp = {ycor, xcor+1};
            frontier.add(temp);
          }
        } else {
          map[ycor][xcor] = ASH;
        }

        if (xcor-1 >= 0) {
          if (map[ycor][xcor-1] == TREE) {
            map[ycor][xcor-1] = FIRE;
            int[] temp = {ycor, xcor-1};
            frontier.add(temp);
          }
        } else {
          map[ycor][xcor] = ASH;
        }

        if (ycor+1 < map.length) {
          if(map[ycor+1][xcor] == TREE) {
            map[ycor+1][xcor] = FIRE;
            int[] temp = {ycor+1, xcor};
            frontier.add(temp);
          }
        } else {
          map[ycor][xcor] = ASH;
        }

        if (ycor-1 >= 0) {
          if(map[ycor-1][xcor] == TREE) {
            map[ycor-1][xcor] = FIRE;
            int[] temp = {ycor-1, xcor};
            frontier.add(temp);
          }
        } else {
          map[ycor][xcor] = ASH;
        }
        map[ycor][xcor] = ASH;
        frontier.remove();
      }
      catch (NoSuchElementException e) {

      }
    }
  }



  /***********************YOU MIGHT UPDATE THIS**************************/

  /*Initialize the simulation.
   *If you add more instance variables you can add more here,
   *otherwise it is complete
   */
  public BurnTrees(int width,int height, double density){
    map = new int[height][width];
    for(int r = 0; r < map.length; r++ ){
      for(int c = 0; c < map[r].length; c++ ){
        if(Math.random() < density){
           map[r][c]=TREE;
         }
       }
     }
     frontier = new ArrayDeque<int[]>();
     start();//set the left column on fire.
   }


  /*
   *Sets the trees in the left column of the forest on fire
   */
  public void start(){
    //If you add more instance variables you can add more here,
    //otherwise it is complete.
    for(int i = 0; i < map.length; i++){
      if(map[i][0]==TREE){
        map[i][0]=FIRE;
        int[] temp = {i,0};
        frontier.add(temp);
        //System.out.println(frontier.getLast()[0]);
      }
    }
  }

  public static double averageOfNRuns(int n, int size, double density) {
    BurnTrees b = new BurnTrees(size,size,density);
    double sum = 0.0;
    for (int i = 0; i < n; i++) {
      sum += b.run();
    }
    return ((sum + 0.0) / n);
  }

  public static void main(String[]args){
    int WIDTH = 20;
    int HEIGHT = 20;
    int DELAY = 200;
    double DENSITY = .6;
    if(args.length > 1){
      WIDTH = Integer.parseInt(args[0]);
      HEIGHT = Integer.parseInt(args[1]);
      DENSITY = Double.parseDouble(args[2]);
    }
    if(args.length > 3){
      DELAY = Integer.parseInt(args[3]);
    }
    BurnTrees b = new BurnTrees(WIDTH,HEIGHT,DENSITY);

    for (double i = 0.05; i <= 1.0; i = i + 0.05) {
      System.out.println("Density " + i + ": " + averageOfNRuns(1000, 100, i));
    }

    // int ans = b.animate(DELAY);//animate all screens
    // System.out.println(ans);//print the final answer

    //System.out.println(b.run());

    // int ans = b.outputAll();//print all screens one after another
    // System.out.println(ans);//print the final answer
  }




  /***********************DO NOT UPDATE THINGS BELOW HERE**************************/

  /*DO NOT UPDATE THIS
   *PLEASE READ SO YOU SEE HOW THE SIMULATION IS SUPPOSED TO WORK!!!
   */
  public int run(){
    while(!done()){
      tick();
    }
    return getTicks();
  }


  /*DO NOT UPDATE THIS*/
  public int getTicks(){
    return ticks;
  }

  /*DO NOT UPDATE THIS*/
  public String toString(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==SPACE)
          builder.append(" ");
        else if(map[i][c]==TREE)
          builder.append("@");
        else if(map[i][c]==FIRE)
          builder.append("w");
        else if(map[i][c]==ASH)
          builder.append(".");
      }
      builder.append("\n");
    }
    return builder.toString();
  }

  /*DO NOT UPDATE THIS*/
  public String toStringColor(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==0)
          builder.append(" ");
        else if(map[i][c]==2)
          builder.append(Text.color(Text.GREEN)+"@");
        else if(map[i][c]==1)
          builder.append(Text.color(Text.RED)+"w");
        else if(map[i][c]==3)
          builder.append(Text.color(Text.DARK)+".");
      }
      builder.append("\n"+Text.RESET);
    }
    return builder.toString()+ticks+"\n";
  }

  /*DO NOT UPDATE THIS*/
  public int animate(int delay) {
    System.out.print(Text.CLEAR_SCREEN);
    System.out.println(Text.go(1,1)+toStringColor());
    Text.wait(delay);
    while(!done()){
      tick();
      System.out.println(Text.go(1,1)+toStringColor());
      Text.wait(delay);
    }
    return getTicks();
  }

  /*DO NOT UPDATE THIS*/
  public int outputAll(){
    System.out.println(toStringColor());
    while(!done()){
      tick();
      System.out.println(toStringColor());
    }
    return getTicks();
  }


}
