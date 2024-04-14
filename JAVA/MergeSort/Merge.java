import java.util.Arrays;

public class Merge{
/*merge takes two sorted arrays and returns a new array that combines all
 *elements of both arrays in asorted order.
 *@left a sorted array (this is a precondition)
 *@right a sorted array (this is a precondition)
 *@return a sorted array that contains all elements of left and right
 */
  public static int [] merge(int [] left, int[] right){
    //********************
    int[] data = new int[left.length+right.length];
    int i = 0;
    int j = 0;
    int x = 0;
    while (i < left.length && j < right.length) {
      if (left[i] < right[j]){
        data[x] = left[i];
        i++;
      }
      else {
        data[x] = right[j];
        j++;
      }
      x++;
    }

    while (i < left.length) {
      data[x] = left[i];
      i++;
      x++;
    }

    while (j < right.length) {
      data[x] = right[j];
      j++;
      x++;
    }
    return data;
    //********************
  }

/*mergesortH is the actual mergesort method.
*@data the array to be sorted
*@return a new array that is the sorted version of data.
*/
  public static int[] mergesortH(int [] data){
    if (data.length > 1) {
      int leftLength = data.length / 2;
      int rightLength = data.length - leftLength;
      int[] left = new int[leftLength];
      int[] right = new int[rightLength];
      for (int i = 0; i < leftLength; i++) {
        left[i] = data[i];
      }
      for (int i = 0; i < rightLength; i++) {
        right[i] = data[leftLength+i];
      }
      return merge(mergesortH(left),mergesortH(right));
    }
    return data;
  }

/*mergesort uses the recursive mergesortH method to create a sorted
*version of the array. It then copies the data back into the original
*array. (This is for compatibility with prior sort testers)
*@param data the array to be sorted, this will be modified by the method
*/
  public static void mergesort(int [] data){
    int [] temp  =  mergesortH(data);
    for(int i = 0; i < data.length; i++){
      data[i] = temp[i];
    }
  }

  public static void main(String[] args) {
    int[] arr = {1,2,3,4,5,6,7,8};
    int[] arr2 = {1,2,3,5,2,16,2,1,2};
    System.out.println(Arrays.toString(mergesortH(arr)));
    mergesort(arr2);
    System.out.println(Arrays.toString(arr2));
  }
}
