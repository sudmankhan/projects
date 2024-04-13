public class RecursionClasswork {

  public static boolean partialSum(int[] arr,int targetValue) {
    return partialSum(0, arr, targetValue);
  }

  public static boolean partialSum(int start,int[] arr,int targetValue) {
    int sum = 0;
    if(targetValue == 0) {
      return true;
    }
    else if (start != arr.length){
      sum += arr[start];
      return partialSum(start+1, arr, targetValue) ||
      partialSum(start+1, arr, targetValue - sum);
    }
    else {
      return false;
    }
  }

  public static boolean splitArray(int[] nums) {
    return splitArray(nums, 0, 0, 0);
  }

  public static boolean splitArray(int[] nums, int index, int sum1, int sum2) {
    if (index == nums.length) {
      return sum1 == sum2;
    }
    else {
      return splitArray(nums, index + 1, sum1, sum2 + nums[index]) ||
      splitArray(nums, index + 1, sum1 + nums[index], sum2);
    }
  }

  public static boolean groupSum6(int start, int[] nums, int target) {
    int sum = 0;
    if (start >= nums.length){
      return target == sum;
    }
    else {
      sum += nums[start];
      if (nums[start] == 6) {
        sum += nums[start] + 6;
        return groupSum6(start+1, nums, target - 6) ||
        groupSum6(start+1, nums, target - sum - 6);
      } else {
        return groupSum6(start+1, nums, target) ||
        groupSum6(start+1, nums, target - sum);
      }
    }
  }

  public static boolean groupNoAdj(int start, int[] nums, int target) {
    int sum = 0;
    if (start >= nums.length){
      return target == sum;
    }
    else {
      sum += nums[start];
      return groupNoAdj(start+1, nums, target) ||
      groupNoAdj(start+2, nums, target - sum);
    }
  }

  public static boolean splitOdd10(int[] nums) {
    return splitOdd10(nums, 0, 0, 0);
  }

  public static boolean splitOdd10(int[] nums, int index, int sum1, int sum2) {
    if (index == nums.length) {
      return (sum1 % 10 == 0) && (sum2 % 2 != 0);
    }
    else {
      return splitArray(nums, index + 1, sum1, sum2 + nums[index]) ||
      splitArray(nums, index + 1, sum1 + nums[index], sum2);
    }
  }

  public static boolean split53(int[] nums) {
    return split53(nums,0,0,0);
  }

  public static boolean split53(int[] nums, int index, int sum1, int sum2) {
    if (index == nums.length) {
      return sum1 == sum2;
    }
    else {
      if (nums[index] % 5 == 0) {
        return split53(nums, index + 1, sum1, sum2 + nums[index]);
      }
      else if (nums[index] % 3 == 0){
        return split53(nums, index + 1, sum1 + nums[index], sum2);
      }
      else {
        return split53(nums, index + 1, sum1, sum2 + nums[index]) ||
        split53(nums, index + 1, sum1 + nums[index], sum2);
      }
    }
  }

  public boolean groupSum5(int start, int[] nums, int target) {
    int sum = 0;
    if (start >= nums.length){
      return target == sum;
    }
    else {
      if (nums[start] % 5 == 0) {
        sum += nums[start] + 5;
        return groupSum5(start+1, nums, target - nums[start]) ||
        groupSum5(start+1, nums, target - sum);
      } else if (start >= 1 && nums[start-1] % 5 == 0 && nums[start] == 1) {
        return groupSum5(start+1, nums, target) ||
        groupSum5(start+1, nums, target - sum);
      }
      else {
        sum += nums[start];
        return groupSum5(start+1, nums, target) ||
        groupSum5(start+1, nums, target - sum);
      }
    }
  }

  public boolean groupSumClump(int start, int[] nums, int target) {
    int sum = 0;
    if(target == 0) {
      return true;
    }
    else if (start != nums.length){
      int numAdj = 1;
      while (start + 1 < nums.length && nums[start] == nums[start+1]) {
        numAdj++;
        start++;
      }
      sum += nums[start] * numAdj;
      return groupSumClump(start+1, nums, target) ||
      groupSumClump(start+1, nums, target - sum);
    }
    else {
      return false;
    }
  }

  public static void main(String[] args) {
    // System.out.println(partialSum(new int[]{2,4,8}, 10));
    // System.out.println(partialSum(new int[]{2,4,8}, 14));
    // System.out.println(partialSum(new int[]{2,4,8}, 9));
    // System.out.println(partialSum(new int[]{2,3,7,10}, 9));
    // System.out.println(groupSum6(0, new int[] {5, 6, 2}, 8));
    // System.out.println(groupSum6(0, new int[] {5, 6, 2}, 9));
    // System.out.println(groupSum6(0, new int[] {5, 6, 2}, 7));
    // System.out.println(split53(new int[]{1, 1}));
    // System.out.println(split53(new int[]{1, 1, 1}));
    // System.out.println(split53(new int[]{2, 4, 2}));
    // int numAdj = 1;
    // int[] arr = new int[] {2,1,1,1,1};
    // int i = 0;
    // while (i+1 < arr.length && arr[i] == arr[i+1]) {
    //   numAdj++;
    //   i++;
    // }
    // System.out.println(numAdj);
  }
}
