import java.util.*;

public class Merge {

  public static int[] merge(int[] left, int[] right){
    //return a new array that is the merged version of left and right
    int[] data = new int[left.length+right.length];
    int i = 0;
    int j = 0;
    for (int x = 0; x < data.length; x++) {
      if (left[i] < right[j]) {
        data[x] = left[i];
        i++;
      }
      else if (right[j] < left[i]) {
        data[x] = right[j];
        j++;
      }
      else if (right[j] == left[i]) {
        data[x] = left[i];
        data[x] = right[j];
        i++;
        j++;
      }
    }
    return data;
  }

  // public static void mergesort(int[] data){
  //   int [] temp  =  mergeSortH(data);
  //   copy temp into data
  // }
  //
  // public static int[] mergesortH(int[] data) {
  //   if more than 1 element{
  //     left = copy half of data
  //     right = copy other half of data
  //     return merge(mergesortH(left),mergesortH(right))
  //   }
  // }

  public static void main(String[] args) {
    int arr = new int arr{}
  }

}
