import java.util.*;
public class StuyabloGame{
  private static final int WIDTH = 80;
  private static final int HEIGHT = 30;
  private static final int BORDER_COLOR = Text.BLACK;
  private static final int BORDER_BACKGROUND = Text.RED + Text.BACKGROUND;

  public static void main(String[] args) {
    run();
  }

  //Display a List of 1-4 adventurers on the rows row through row+3 (4 rows max)
  //Should include Name and HP on 2 separate lines. (more to be added later)
  public static void drawParty(ArrayList<Adventurer> party,int startRow){
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    int i = 0;
    while (i < party.size()) {
      Adventurer current = party.get(i);
      Text.go(startRow, (20*i)+3);
      System.out.println(Text.colorize(" " + current.getName() + " ",Text.BLACK,Text.WHITE+Text.BACKGROUND));
      Text.go(startRow+1, (20*i)+3);
      System.out.println(current.getSpecialName() + ": " + current.getSpecial()+ "/" + current.getSpecialMax());
      Text.go(startRow+2, (20*i)+3);
      if ((current.getHP()+0.0)/current.getmaxHP() >= .75) {
        System.out.println(Text.colorize("HP: " + current.getHP() + "/" + current.getmaxHP(), Text.GREEN));
      }
      else if ((current.getHP()+0.0)/current.getmaxHP() <= .25) {
        System.out.println(Text.colorize("HP: " + current.getHP() + "/" + current.getmaxHP(), Text.RED));
      }
      else {
        System.out.println("HP: " + current.getHP() + "/" + current.getmaxHP());
      }
      i++;
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }

  //Display a line of text starting at column 2 of the specified row.
  public static void drawText(String s,int startRow){
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    Text.go(startRow, 3);
    System.out.println(s);
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }

  public static void drawScreen(){
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    Text.hideCursor();
    Text.clear();
    for (int i = 1; i <= WIDTH; i++) {
      Text.go(1,i);
      System.out.println(Text.colorize(" ",BORDER_BACKGROUND));
    }
    for (int i = 1; i <= WIDTH; i++) {
      Text.go(HEIGHT,i);
      System.out.println(Text.colorize(" ",BORDER_BACKGROUND));
    }
    for (int i = 1; i <= HEIGHT; i++) {
      Text.go(i,1);
      System.out.println(Text.colorize("  ",BORDER_BACKGROUND));
    }
    for (int i = 1; i <= HEIGHT; i++) {
      Text.go(i,WIDTH);
      System.out.println(Text.colorize("  ",BORDER_BACKGROUND));
    }
    int[] arr = new int[4];
    for(int i = 0; i < 4; i++) {
      arr[i] = (int) (Math.random() * (99));
    }
    Text.go(HEIGHT+1, 1);
    System.out.println(">");
    Text.showCursor();
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }


  public static void run(){
    //Clear and initialize
    Text.hideCursor();
    Text.clear();
    Text.go(1,1);


    //Things to attack:
    //Make an ArrayList of Adventurers and add 1 enemy to it.
    ArrayList<Adventurer>enemies = new ArrayList<>();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    Adventurer Griffith = new Warrior("Griffith","Perish.",100);
    enemies.add(Griffith);
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    //Adventurers you control:
    //Make an ArrayList of Adventurers and add 3 Adventurers to it.
    ArrayList<Adventurer> party = new ArrayList<>();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    Adventurer Guts = new Warrior("Guts","AAAAAAAAARRRR!!",50);
    Adventurer Casca = new Warrior("Casca","HA!",30);
    Adventurer Schierke = new Wizard("Schierke","HA!",50);
    party.add(Guts);
    party.add(Casca);
    party.add(Schierke);
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    //Main loop
    boolean partyTurn = false;
    int whichPlayer = 0;
    int turn = 0;


    String input = "";
    Scanner in = new Scanner(System.in);
    while(! (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit"))){

      //Draw the window border
      Text.hideCursor();
      drawScreen();

      //display event based on last turn's input
      if(partyTurn){
        //Process user input:
        if(input.equals("attack") || input.equals("")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          drawText(party.get(whichPlayer).attack(enemies.get(0)), HEIGHT/2 - 1);
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if(input.equals("special") || input.equals("s")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          drawText(party.get(whichPlayer).specialAttack(enemies.get(0)), HEIGHT/2 - 1);
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        whichPlayer++;



        if(whichPlayer < party.size()){
          drawText("Enter command for "+party.get(whichPlayer)+
                   ": attack/special/quit",HEIGHT/2);
        }else{
          drawText("press enter to see monster's turn",HEIGHT/2);
          partyTurn = false;
        }
      }else{
        //this block ignores user input!
        //display enemy attack except on turn 0.
        if(turn > 0){
          //Enemy action choices go here!
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          int whichAtk = (int) (Math.random() * (2));
          int whichPlayerToAssault = (int) (Math.random() * (3));
          if (whichAtk == 0) {
            drawText(enemies.get(0).attack(party.get(whichPlayerToAssault)), HEIGHT/2 - 1);
          }
          if (whichAtk == 1) {
            drawText(enemies.get(0).specialAttack(party.get(whichPlayerToAssault)), HEIGHT/2 - 1);
          }
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }

        //after enemy goes, change back to player's turn.
        partyTurn=true;
        whichPlayer = 0;
        //display which player's turn is next and prompt for action.
        drawText("Enter command for "+party.get(whichPlayer)+": attack/special/quit",HEIGHT/2);

        //end the turn.
        turn++;

      }

      //display current state of all Adventurers
      drawParty(party,2);
      drawParty(enemies,HEIGHT-5);

      //Draw the prompt
      Text.reset();
      Text.go(HEIGHT+1,1);
      Text.showCursor();
      System.out.print(">");
      //Read user input
      input = in.nextLine();
    }

    //After quit reset things:
    Text.reset();
    Text.showCursor();
    Text.go(32,1);
  }




}
