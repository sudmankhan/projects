import java.util.*;

public class Quick {
  /*Modify the array such that:
  *1. A random index from start to end inclusive is chosen, the
  * corresponding element is designated the pivot element.
  *2. all elements in range that are smaller than the pivot element
  * are placed before the pivot element.
  *3. all elements in range that are larger than the pivot element are
  *placed after the pivot element.
  *4. Only the indices from start to end inclusive are considered in range
  *@return the index of the final position of the pivot element.
  */
  // public static int partition (int [] data, int start, int end){
  //   int p = (int) (Math.random()*(end-start+1) + start);
  //   int temp2 = data[p];
  //   data[p] = data[start];
  //   data[start] = temp2;
  //   p = start;
  //   boolean left = true;
  //   for (int x = start; x < end; x++) {
  //     if (data[p] > data[p+1]) {
  //       int temp = data[p];
  //       data[p] = data[p+1];
  //       data[p+1] = temp;
  //       p = p + 1;
  //     }
  //     else if (data[p] < data[p+1]){
  //       int temp = data[p+1];
  //       for (int i = p+1; i < end-1; i++) {
  //         data[i] = data[i+1];
  //       }
  //       data[end-1] = temp;
  //     }
  //     else if (data[p] == data[p+1]){
  //       if (left) {
  //         int temp = data[p];
  //         data[p] = data[p+1];
  //         data[p+1] = temp;
  //         p = p + 1;
  //       }
  //       else {
  //         int temp = data[p+1];
  //         for (int i = p+1; i < end-1; i++) {
  //           data[i] = data[i+1];
  //         }
  //         data[end-1] = temp;
  //       }
  //       left = !left;
  //     }
  //   }
  //   return p;
  // }

  public static int partition (int [] data, int start, int end){
    int p = (int) (Math.random()*(end-start+1) + start);
    int temp2 = data[p];
    data[p] = data[start];
    data[start] = temp2;
    p = start;
    boolean left = true;
    while (p < end) {
      if (data[p] == data[p+1]) {
        if (left) {
          p++;
        }
        else {
          int temp = data[p+1];
          data[p+1] = data[end];
          data[end] = temp;
          end--;
        }
        left = !left;
      }
      else if (data[p] > data[p+1]) {
        int temp = data[p];
        data[p] = data[p+1];
        data[p+1] = temp;
        p++;
      }
      else if (data[p] < data[p+1]) {
        int temp = data[p+1];
        data[p+1] = data[end];
        data[end] = temp;
        end--;
      }
    }
    return p;
  }

  // public static int[] partitionDutch(int[] data,int lo, int hi) {
  //   int p = (int) (Math.random()*(hi-lo+1) + lo);
  //   int temp2 = data[p];
  //   data[p] = data[lo];
  //   data[lo] = temp2;
  //   p = lo;
  //   int lt = p;
  //   int gt = hi - 1;
  //   if (data[lt] > data[p+1]) {
  //     int temp = data[lt];
  //     data[p] = data[p+1];
  //     data[p+1] = temp;
  //     p = p + 1;
  //   }
  //   else if (data[p] < data[p]) {
  //     int temp = data[p+1];
  //     for (int i = p+1; i < data.length-1; i++) {
  //       data[i] = data[i+1];
  //     }
  //     data[data.length-1] = temp;
  //   }
  //   else if (data[p] == data[p+1]) {
  //     if (data[p+1] == data[lt]) {
  //       lt = p;
  //     }
  //     int temp = data[p];
  //     data[p] = data[p+1];
  //     data[p+1] = temp;
  //     p = p + 1;
  //   }
  // }

  /*return the value that is the kth smallest value of the array.
  *@param data must have a length > 0
  *@param k is 0 to data.length-1 inclusive
  *@postcondition The array may be modified. */

  public static int quickselect(int []data, int k) {
    int p = partition(data, 0, data.length-1);
    while (p != k) {
      if (p > k) {
        p = partition(data, 0, p-1);
      }
      else {
        p = partition(data, p+1, data.length-1);
      }
    }
    System.out.println(Arrays.toString(data));
    return data[p];
  }

  public static void quicksort(int[] data){
    quicksort(data, 0, data.length-1);
  }

  public static void quicksort(int[] data, int lo, int hi){
    if (lo < hi) {
      int p = partition(data, lo, hi);
      quicksort(data, lo, p-1);
      quicksort(data, p+1, hi);
    }
  }

  // public static int partition(int array[], int low, int high) {
  //   int pivot = array[high];
  //   int i = (low - 1);
  //   for (int j = low; j < high; j++) {
  //     if (array[j] <= pivot) {
  //       i++;
  //       int temp = array[i];
  //       array[i] = array[j];
  //       array[j] = temp;
  //     }
  //   }
  //   int temp = array[i + 1];
  //   array[i + 1] = array[high];
  //   array[high] = temp;
  //   return (i + 1);
  // }
  //

  public static void main(String[] args) {
    int [] data = new int[10];
    for (int i = 0; i < data.length; i++) {
      data[i] = (int) (Math.random()*(10-0+1) + 0);
    }
    //int[] data = {4,3,2,0,0,0,0,0,0,0,1,2,2,3,4};
    //partition(data, 0, data.length-1);
    //
    // System.out.println("Original: "+Arrays.toString(data));
    // int pivot = partition( data , 0, data.length-1);
    // System.out.println("Pivot value: "+data[pivot]+ ", Pivot index: "+pivot);
    // System.out.println("Modified: "+Arrays.toString(data));
    // System.out.println();
    //
    int[] ary = {5,5,5,5,5,5};
    // // partition(data, 0, data.length-1);
    //quicksort(ary);
    System.out.println(Arrays.toString(data));
    quicksort(data);
    //System.out.println(Arrays.toString(ary));
    System.out.println(Arrays.toString(data));


  }
}
