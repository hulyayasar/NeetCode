package Stack;

public class Daily_Temperatures {

    public int[] dailyTemperatures(int[] temperatures) {

        int [] result = new int[temperatures.length];
        boolean flag= true;

        for(int i=0; i<temperatures.length; i++){
            flag= true;

            for(int j=i+1; j<temperatures.length; j++){
                if(temperatures[i]< temperatures[j]){
                    result[i] = j-i;
                    flag = false;
                    break;
                }
            }
            if(flag){
                result[i]= 0;
            }
        }
        return result;

    }
}
