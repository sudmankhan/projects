import java.util.*;

public class Game{
  public static void main(String[] args) {
    // Adventurer a = new Warrior("Conan","Aaaaaaaar!",20);
    // Adventurer b = new Wizard("Megumin","Donuts?",0);
    // System.out.println(a+" ("+a.getHP()+"HP)");
    // System.out.println(b+" ("+b.getHP()+"HP)");
    // a.attack(b);
    // b.attack(a);
    // System.out.println(a+" ("+a.getHP()+"HP)");
    // System.out.println(b+" ("+b.getHP()+"HP)");
    // a.specialAttack(b);
    // b.specialAttack(a);
    // System.out.println(a+" ("+a.getHP()+"HP)");
    // System.out.println(b+" ("+b.getHP()+"HP)");

    // drawScreen();
    // randomizeNumbers();
    // printNumbers();
    // String input = "";
    // Scanner in = new Scanner(System.in);
    // input = in.nextLine();
    // while(!(input.equals("q") || input.equals("quit"))) {
    //     if (input.equals("")) {
    //       drawScreen();
    //       Text.go(31,1);
    //       System.out.println("> ");
    //       Text.showCursor();
    //     }
    //     else {
    //       drawScreen();
    //       printNumbers();
    //       Text.showCursor();
    //     }
    //     input = in.nextLine();
    //   }

    int x = (int) (Math.random() * (3));
    System.out.println(x);
    }

    public static void drawParty(String x,int startRow,int col){
      /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
      Text.go(startRow+1, col);
      System.out.println(x);
      /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
    }

    public static void drawScreen() {
      Text.hideCursor();
      Text.clear();
      for (int i = 1; i <= 80; i++) {
        Text.go(1,i);
        System.out.println(Text.colorize(" ",Text.RED+Text.BACKGROUND));
      }
      for (int i = 1; i <= 80; i++) {
        Text.go(30,i);
        System.out.println(Text.colorize(" ",Text.RED+Text.BACKGROUND));
      }
      for (int i = 1; i <= 30; i++) {
        Text.go(i,1);
        System.out.println(Text.colorize(" ",Text.RED+Text.BACKGROUND));
      }
      for (int i = 1; i <= 30; i++) {
        Text.go(i,80);
        System.out.println(Text.colorize(" ",Text.RED+Text.BACKGROUND));
      }
    }

    public static int[] randomizeNumbers() {
      int[] arr = new int[4];
      for(int i = 0; i < 4; i++) {
        arr[i] = (int) (Math.random() * (99));
      }
      return arr;
    }

    public static void printNumbers() {
      int[] arr = new int[4];
      for(int i = 0; i < 4; i++) {
        arr[i] = (int) (Math.random() * (99));
      }
      Text.go(2,2);
      System.out.println(colorByInt(arr[0]));
      Text.go(2,20);
      System.out.println(colorByInt(arr[1]));
      Text.go(2,40);
      System.out.println(colorByInt(arr[2]));
      Text.go(2,60);
      System.out.println(colorByInt(arr[3]));
      Text.reset();
      Text.go(31,1);
      System.out.println(">");
      Text.showCursor();
    }
    public static String colorByInt(int x){
      if (x < 25) {
        return Text.colorize(""+x, Text.RED);
      }
      if (x > 75) {
        return Text.colorize(""+x, Text.GREEN);
      }
      else {
        return ""+x;
      }
    }
}
