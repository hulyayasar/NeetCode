package Binary_Search;

import java.util.Arrays;

public class Pile_Of_Banana {

    public static int minEatingSpeed(int[] piles, int h) {

        Arrays.sort(piles);

        for( int j=1; j<=piles[piles.length-1] ; j++){

            int count = 0;
            for(int i=0; i<piles.length; i++){
                if( count> h ){
                    break;
                }

                if((piles[i]%j) == 0){
                    count += (piles[i]/j);
                }else{
                    count += (piles[i]/j) + 1;
                }
            }
            if(!(count> h)) return j;
        }
        return 0;

    }

    public static int minEatingSpeed_2(int[] piles, int h) {

        Arrays.sort(piles);
        int result = 0;

        int left= 0, right = piles[piles.length-1];
        while(left<=right) {

            int mid= (right+left)/2;

            int count = 0;
            for(int i=0; i<piles.length; i++){
                if( count> h ){
                    break;
                }
                if((piles[i]%mid) == 0){
                    count += (piles[i]/mid);
                }else{
                    count += (piles[i]/mid) + 1;
                }
            }

            if(!(count> h)){
                result = mid;
                right= mid-1;
            }else{
                left = mid +1;
            }
        }

        return result;

    }

    public static void main(String[] args) {
//        int [] piles = {1,4,3,2};
//        int h = 9;
//        System.out.println(minEatingSpeed_2(piles, h));

        int [] piles = {25,10,23,4};
        int h = 4;
        System.out.println(minEatingSpeed_2(piles, h));



    }
}
