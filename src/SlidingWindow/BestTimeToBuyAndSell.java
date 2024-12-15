package SlidingWindow;

public class BestTimeToBuyAndSell {
    public static int maxProfit(int[] prices) {

        int st=0;
        int maxProf = 0;

        for(int i=1;i<prices.length;i++){
            if(prices[i]-prices[st]>0){
                int prof = prices[i]-prices[st];
                maxProf = maxProf<prof ? prof: maxProf;
                System.out.println("prof" + prof);
            }
            else{
                st = i;
            }
        }
        return maxProf;
    }

    public static void main(String[] args) {
        int [] num1 = {7,1,5,3,6,4};
        System.out.println(maxProfit(num1));

//        int [] nums = {3,5,6,0,1,2};
//        System.out.println(search(nums, 4));
//


    }
}
