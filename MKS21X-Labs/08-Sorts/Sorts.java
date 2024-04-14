import java.util.Arrays;

public class Sorts{

  // public static void main(String[] args) {
  //   int[] arr = {1,5,3,6,2};
  //   int[] arr2 = {1,215,63,631,61};
  //   int[] arr3 = {0,-35,3,-6,2};
  //   int[] arr4 = {1};
  //   int[] arr5 = {};
  //   int[] arr6 = randomArray(10,1,5);
  //   int[] arr7 = randomArray(10,1,100000);
  //   System.out.println(tester(arr, 1));
  //   System.out.println(tester(arr, 2));
  //   System.out.println(tester(arr, 3));
  //   System.out.println(tester(arr2, 1));
  //   System.out.println(tester(arr2, 2));
  //   System.out.println(tester(arr2, 3));
  //   System.out.println(tester(arr3, 1));
  //   System.out.println(tester(arr3, 2));
  //   System.out.println(tester(arr3, 3));
  //   System.out.println(tester(arr4, 1));
  //   System.out.println(tester(arr4, 2));
  //   System.out.println(tester(arr4, 3));
  //   System.out.println(tester(arr5, 1));
  //   System.out.println(tester(arr5, 2));
  //   System.out.println(tester(arr5, 3));
  //   System.out.println(tester(arr6, 1));
  //   System.out.println(tester(arr6, 2));
  //   System.out.println(tester(arr6, 3));
  //   System.out.println(tester(arr7, 1));
  //   System.out.println(tester(arr7, 2));
  //   System.out.println(tester(arr7, 3));
  // }

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

  /*Selection sort
   */
  public static void selectionSort(int[] ary) {
    for (int i = 0; i < ary.length; i++) {
      int min = ary[i];
      for (int j = i; j < ary.length; j++) {
        if (ary[j] < min) {
          min = ary[j];
          int temp = ary[i];
          ary[i] = ary[j];
          ary[j] = temp;
        }
      }
    }
  }

  // public static void insertionSort(int[] data){
  //   for (int i = 1; i < data.length; i++) {
  //     for (int j = i; j < data.length; j++) {
  //       int index = j;
  //       int key = data[j];
  //       for (int x = 1; j-x >= 0; x++)
  //         if (key < data[j-x]) {
  //           index--;
  //       }
  //       int temp = data[j];
  //       for (int x = j; x > index; x--) {
  //         data[x] = data[x-1];
  //       }
  //       data[index] = key;
  //     }
  //   }
  // }

  public static void insertionSort(int[] data){
    for (int i = 1; i < data.length; i++) {
      int key = data[i];
      int index = i - 1;
      while (index >= 0 && key < data[index]) {
        data[index + 1] = data[index];
        index--;
      }
      data[index + 1] = key;
    }
  }

  public static int[] randomArray(int size, int min, int max) {
      int[] ran = new int[size];
      for (int i = 0; i < ran.length; i++) {
        ran[i] = (int) (Math.random() * (max - min + 1) + min);
      }
      return ran;
  }

  public static boolean tester(int[] arr, int x) {
    int[] arrcopy = arr.clone();
    Arrays.sort(arr);
    if (x == 1) {
      bubbleSort(arrcopy);
    }
    else if (x == 2) {
      selectionSort(arrcopy);
    }
    else if (x == 3) {
      insertionSort(arrcopy);
    }
    return Arrays.equals(arrcopy, arr);
  }

}
