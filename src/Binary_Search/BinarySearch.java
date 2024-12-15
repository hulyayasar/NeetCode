package Binary_Search;

public class BinarySearch {

    public static int search(int[] nums, int target) {

        return binary( nums, target, 0,nums.length-1 );

    }

    public static int binary(int[] nums, int target, int left, int right ) {

        if(left>right ){
            return -1;
        }
        int m= left + (right-left)/2;
        if(nums[m]==target){
            return m;
        }

        if(nums[m]< target){
            return binary(nums,target, m+1, right);
        }
        else {
            return binary(nums, target, left, m-1);
        }

    }

    //iteratively binary search
    public static int search_2(int[] nums, int target) {

        int left = 0, right = nums.length-1;
        int m = -1;
        boolean flag = true;

        while(left<=right){
            m = (left + right)/2;
            if(nums[m]==target){
                flag = false;
                break;
            }
            else if(nums[m]<target){
                left = m+1;
            }else{
                right = m-1;
            }
        }
        if(flag) m = -1;
       return m;
    }

    public static String testSearch(int[] nums, int target, int expected) {
        int result = search_2(nums, target);
        return result == expected ? "PASS" : "FAIL: got " + result + " but expected " + expected;
    }

    public static void main(String[] args) {
        //Test cases
        System.out.println(testSearch(new int[]{-1, 0, 2, 4, 6, 8}, 4, 3));  // Expected: 3
        System.out.println(testSearch(new int[]{-1, 0, 2, 4, 6, 8}, 2, 2));  // Expected: 2
        System.out.println(testSearch(new int[]{-1, 0, 2, 4, 6, 8}, 6, 4));  // Expected: 4
        System.out.println(testSearch(new int[]{-1, 0, 2, 4, 6, 8}, 8, 5));  // Expected: 5
        System.out.println(testSearch(new int[]{-1, 0, 2, 4, 6, 8}, 10, -1)); // Expected: -1
        System.out.println(testSearch(new int[]{1, 3, 5, 7, 9}, 5, 2));      // Expected: 2
        System.out.println(testSearch(new int[]{1, 3, 5, 7, 9}, -5, -1));    // Expected: -1
    }
}
