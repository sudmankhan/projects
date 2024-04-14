import java.util.Arrays;

public class Sorts{

  public static void main(String[] args) {
    int[] arr = {1,5,3,6,2};
    //bubbleSort(arr);
    System.out.println("1");
    System.out.println(Arrays.toString(arr));
  }

  /**Bubble sort of an int array.
  *Upon completion, the elements of the array will be in increasing order.
  *@param data  the elements to be sorted.
  */
  public static void bubbleSort(int[] data){
    for (int j = 0; j < data.length; j++) {
      for (int i = 0; i < data.length-1; i++) {
        if (data[i] > data[i+1]) {
          int temp1 = data[i];
          int temp2 = data[i+1];
          data[i] = temp2;
          data[i+1] = temp1;
        }
      }
    }
  }
}
