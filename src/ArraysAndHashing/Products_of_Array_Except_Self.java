package ArraysAndHashing;

import java.util.Arrays;

public class Products_of_Array_Except_Self {

    public int[] productExceptSelf_1(int[] nums) {

        int[] output = new int[nums.length];
        int product = 1;

        for(int i=0; i< nums.length; i++){
            product*= nums[i];
        }
        for(int i=0; i< nums.length; i++){
            if( nums[i] == 0 ){
                output[i]= product;
            }
            output[i]= product/nums[i];
        }

        return output;

    }
    public int[] productExceptSelf_2(int[] nums) {

        int[] output = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] sufix = new int[nums.length];
        prefix[0] = 1;
        sufix[nums.length -1] = 1;


        for(int start = 1; start< nums.length; start++){

            prefix[start] = prefix[start-1] * nums[start-1] ;
        }
        for(int end=nums.length-2; end>=0; end--){

            sufix[end] = sufix[end+1] * nums[end+1];
        }
        for(int i = 0; i< nums.length; i++){

            output[i] = prefix[i] * sufix[i] ;
        }


        return output;

    }

    public static int[] productExceptSelf_3(int[] nums) {

        int n = nums.length;
        int[] output = new int[n];
        output[0]= 1;

        for(int i= 1; i< n; i++){

            output[i] = nums[i-1] * output[i-1];
        }

        int product=1;
        for (int i = n-1; i >=0 ; i--) {
            output[i] = product * output[i];
            product = nums[i] * product;

        }
        return output;

    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,1};

        System.out.println(Arrays.toString(productExceptSelf_3(nums)));  //[6, 2, 3, 6]

    }

}
