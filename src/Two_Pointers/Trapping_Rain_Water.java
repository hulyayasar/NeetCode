package Two_Pointers;

public class Trapping_Rain_Water {

    public static int trap(int[] height) {

        int s=0;
        int area=0, tempArea = 0;

        for(int e= s+1; e< height.length; e++){

            if(height[s]>height[e]){
                tempArea += height[s]-height[e];
            }
            else{
                area+=tempArea;
                s=e;
                tempArea = 0;
            }

        }
        return area;

    }

    public static void main(String[] args) {
        int [] height = {0,2,0,3,1,0,1,3,2,1};

        System.out.println(trap(height)); //9

    }

}
