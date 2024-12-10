package Two_Pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {


        List<List<Integer>> result = new ArrayList<>();
        List<Integer> found = new ArrayList<>();

        int s = 0, e = nums.length - 1;
        int m = s + 1;
        int sum ;
        int counter = 0;

        while (s < m && m < e) {

            sum = nums[s] + nums[e];

            for (int i = s + 1; i < e; i++) {
                if (sum + nums[i] == 0) {
                    found.add(nums[s]);
                    found.add(nums[e]);
                    found.add(nums[i]);
                    result.add(found);
                    found.clear();
                }else{
                    if(counter%2==0){
                        s++;
                    }else {
                        e--;
                    }
                }

            }
        }
        return result;
    }


    // act like find a num i + num j = - num k
    // 3 + 4 = 7 ( look for sum that makes -7)
    public List<List<Integer>> threeSum_2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> found = new ArrayList<>();

        Arrays.sort(nums);
        int s = 0, e = nums.length - 1;
        int sum ;


        for (int i = 0, j = nums.length-1; i < nums.length-1 || j>0 ; ) {

            sum = nums[i] + nums[j];
                if( sum > 0) {
                    for (int k = i+1; k < j; k++) {
                        if(sum + nums[k] == 0){
                            found.add(nums[i]); found.add(nums[j]); found.add(nums[k]);
                            result.add(found);
                        }
                        else if(sum + nums[k] < 0){
                            i++;
                            break;
                        }
                        else{
                            j--;
                            break;
                        }
                    }

                }else if( sum < 0) {
                    for (int k = e-1; k >i ; k--) {
                        if(sum + nums[k] == 0){
                            found.add(nums[i]); found.add(nums[j]); found.add(nums[k]);
                            result.add(found);
                        }
                        else if(sum + nums[k] > 0){
                            j--;
                            break;
                        }else{
                            i++;
                            break;
                        }
                    }
                }

                else{

                }
        }

        return result;
    }

    public static List<List<Integer>> threeSum_3(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {

            if(nums[i] > 0) break;
            if(i>0 && nums[i] ==nums[i-1]) continue;

            for (int m = i+1, e = nums.length-1; m <e ; ) {

                if(nums[m] + nums[e] == -1*nums[i]){
                    result.add(Arrays.asList(nums[i], nums[m], nums[e]));
                    m++;
                    e--;
                    while(m<e && nums[e] == nums[e+1]){
                        e--;
                    }
                    while(m<e &&nums[m] == nums[m-1]){
                        m++;
                    }

                }
                else if(nums[m] + nums[e] > -1*nums[i]){
                    e--;
                }else{
                    m++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
       int [] nums = {-1,0,1,2,-1,-4};

        System.out.println(threeSum_3(nums)); //[[-1,-1,2],[-1,0,1]]

    }


}
