package ArraysAndHashing;

import java.util.Arrays;

public class Valid_Palindrome {
    public static boolean isPalindrome(String s) {

        int start=0, end = s.length()-1;
        boolean flag= true;
        for(; start<end;  ){

            if(s.charAt(start)>='A' && s.charAt(start)<='z'){

                if(s.charAt(end)>='A' && s.charAt(end)<='z'){

                    if(Character.toUpperCase(s.charAt(start)) != Character.toUpperCase(s.charAt(end))){
                        flag = false;
                    }
                    start++;
                    end--;
                }else{
                    end--;
                    continue;
                }
            }else{
                start++;
                continue; }

        }
        return flag;

    }

    public static void main(String[] args) {
        String s = "Was it a car or a cat I saw?";

        System.out.println(isPalindrome(s));  //true

    }


}
