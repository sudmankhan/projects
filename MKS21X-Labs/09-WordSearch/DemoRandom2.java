import java.util.Random;

public class DemoRandom2{
  public static void main(String[]args){
    //here no seed is provided, so it uses the clock as a seed
    //this can be used to produce a random seed for a different Random object!
    Random rng = new Random();
    int seed = rng.nextInt();

    System.out.println("The seed: "+1974070100);
    rng = new Random(1974070100);
    for(int i =  0; i < 10; i++ ){
      System.out.println(rng.nextInt() % 1000);
    }
  }
}
