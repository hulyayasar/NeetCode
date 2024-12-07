package ArraysAndHashing;

import java.util.*;

public class Top_K_Frequent_Elements {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 1;
        map.put(nums[0],count);

        for( int i = 1; i< nums.length; i++){
            if(nums[i]!=nums[i-1]){
                count = 1;
                map.put(nums[i],count);

            }else{
                count++;
                map.put(nums[i],count);
            }
        }

        List<int[]> list = new ArrayList<int[]>();

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){

            list.add(new int[] {entry.getValue(), entry.getKey()});
        }

        list.sort((a,b) ->(b[0]-a[0]));


        //create the k size array
        int[] output = new int[k];
        for(int i=0; i<k ; i++){
            output[i] = list.get(i)[1];

        }
        return output;

    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,3,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));  //

    }


}
