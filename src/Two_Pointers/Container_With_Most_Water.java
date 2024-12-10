package Two_Pointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Container_With_Most_Water {

    public static int maxArea(int[] heights) {
        int shorter;
        int area;
        int maximumArea=0;
        int s=0, e=heights.length-1;

        while(s<e){
            shorter = heights[s] > heights[e] ? heights[e] : heights[s];

            area = (e-s) * shorter;
            maximumArea = maximumArea< area ? area : maximumArea;

            if(heights[s] > heights[e]){
                e--;
            }else{
                s++;
            }
        }
        return maximumArea;

    }
    public static void main(String[] args) {
        int [] nums = {1,7,2,5,4,7,3,6};

        System.out.println(maxArea(nums)); //36

    }


}
