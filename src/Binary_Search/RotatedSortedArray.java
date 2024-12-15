package Binary_Search;

public class RotatedSortedArray {

    public static int findMin(int[] nums) {
        int l=0, r=nums.length-1;
        int m=0;

        while(l<=r){
            m= (l+r)/2;
            if(nums[l]>nums[r]){
                if(nums[m]>nums[r]){
                    l=m+1;
                    continue;
                }else{
                    r=m;
                    continue;
                }
            }
            else{
                return nums[l];
            }
        }
        return nums[m];
    }


    public static void main(String[] args) {
        // Test cases
        System.out.println(testFindMin(new int[]{3, 4, 5, 6, 1, 2}, 1));  // Expected: 1
        System.out.println(testFindMin(new int[]{1, 2, 3, 4, 5, 6}, 1));  // Expected: 1
        System.out.println(testFindMin(new int[]{6, 1, 2, 3, 4, 5}, 1));  // Expected: 1
        System.out.println(testFindMin(new int[]{5, 6, 1, 2, 3, 4}, 1));  // Expected: 1
        System.out.println(testFindMin(new int[]{2, 3, 4, 5, 6, 1}, 1));  // Expected: 1
        System.out.println(testFindMin(new int[]{10, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 1));  // Expected: 1
        System.out.println(testFindMin(new int[]{1}, 1));                // Expected: 1 (single element)
        System.out.println(testFindMin(new int[]{1, 2}, 1));             // Expected: 1 (two elements, no rotation)
        System.out.println(testFindMin(new int[]{2, 1}, 1));             // Expected: 1 (two elements, rotated)
    }

    public static String testFindMin(int[] nums, int expected) {
        int result = findMin(nums);
        return result == expected ? "PASS" : "FAIL: got " + result + " but expected " + expected;
    }
}
