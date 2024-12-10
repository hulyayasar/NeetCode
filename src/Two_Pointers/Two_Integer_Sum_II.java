package Two_Pointers;

import java.util.*;

public class Two_Integer_Sum_II {

    public int[] twoSum(int[] numbers, int target) {

        int[] result = new int[2];
        for(int i =0; i< target; i++){
            for(int j =i+1; j< target; j++){
                if(numbers[i] != numbers[j] &&
                        numbers[i] + numbers[j] == target ){
                    result[0]=i+1;
                    result[1]=j+1;
                }
            }
        }
        return result;
    }


    // i cannot check the index because of the set
    public int[] twoSum_2(int[] numbers, int target) {

        int[] result = new int[2];
        Set<Integer> set = new HashSet<Integer>();
        for (int n: numbers) {
            set.add(n);

        }
        for (int n: set) {
            if(set.contains(target-n)){

                result[0]=n;
                result[1]=target-n;
            }
        }
        return result;

    }
    //i can achieve this by using hashmap
    public int[] twoSum_4(int[] numbers, int target) {

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i+1);

            if(map.containsKey(target - numbers[i])){
                return new int[]{map.get(target - numbers[i]), i+1};
            }
        }
        return new int[]{};
    }



    //lets try the 2 pointer
    public int[] twoSum_3(int[] numbers, int target) {

        int[] result = new int[2];

        for(int i =0, end =numbers.length-1 ; i< numbers.length; ){
            if(numbers[i] != numbers[end] && i<end){
                if(numbers[i] + numbers[end] == target){
                    result[0]=i+1;
                    result[1]=end +1;
                    return result;
                }
                else if(numbers[i] + numbers[end] > target){
                    end--;
                }
                else{
                    i++;
                }
            }
        }

    return result;

    }




}
