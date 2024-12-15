package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class lengthOfLongestSubstringWithoutRepeatingChar {

    public static int lengthOfLongestSubstring(String s) {

        int maxLen = 0;
        int st=0;

        for(int i=0; i<s.length()-1; i++){
            if(s.substring(st,i+1).contains(s.charAt(i+1) + "")){
               // System.out.println("s.substring(st,i+1)" + s.substring(st,i+1));
                maxLen = maxLen < (i+1-st) ? (i+1-st): maxLen;
                st=i+1;
            }
        }
        return maxLen;

    }

    public static int lengthOfLongestSubstring_2(String s) {

        int maxLen=0;
        int l=0;
        Set<Character> set = new HashSet<>();

        for(int r=0; r<s.length(); r++){

            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            maxLen = maxLen<(r-l +1) ? (r-l +1): maxLen;
        }
        return maxLen;
    }
    
    public static void main(String[] args) {
        String s= "bbbb";
        //String s= "zxyzxyz";
        System.out.println(lengthOfLongestSubstring_2(s));


    }



}
