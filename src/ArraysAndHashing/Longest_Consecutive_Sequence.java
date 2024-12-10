package ArraysAndHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Longest_Consecutive_Sequence {


    //time: n logn, space 1
    public static int longestConsecutive(int[] nums) {

        Arrays.sort(nums);
        int  distance;
        int maxSeq =0;
        int curentSeq = 0;
        int last = nums[0] ;

        for(int i = 0; i < nums.length-1; i++){

            distance = nums[i+1]-last;
            if(distance == 0){
                continue;
            }
            else if(distance == 1 ){
                last = nums[i+1];
                curentSeq++;
                System.out.println(distance);
                System.out.println("i " + i);
            }else{
                curentSeq = 0;
                System.out.println("curentSeq " + curentSeq);
            }
            if(maxSeq<curentSeq){
                maxSeq = curentSeq;
                System.out.println("maxSeq = curentSeq" + maxSeq);
            }
        }
        return maxSeq +1;
    }

    //time: n, space n
    public int longestConsecutive_1(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int res = 0;

        for (int num : nums) {
            if (!mp.containsKey(num)) {
                mp.put(num, mp.getOrDefault(num - 1, 0) + mp.getOrDefault(num + 1, 0) + 1);
                mp.put(num - mp.getOrDefault(num - 1, 0), mp.get(num));
                mp.put(num + mp.getOrDefault(num + 1, 0), mp.get(num));
                res = Math.max(res, mp.get(num));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //int []nums = {2,20,4,10,3,4,5};
        //int []nums = { 0,3,2,5,4,6,1,1};
        int []nums = {22,2,1,3,4,4,4,7};



        System.out.println("result " +longestConsecutive(nums));

    }


}
