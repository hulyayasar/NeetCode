package SlidingWindow;

import java.util.HashMap;

public class LongestRepetedCharReplacement {

    public static int characterReplacement(String s, int k) {

        HashMap<Character, Integer> map = new HashMap<>();
        int mostF = 0;
        char mostCh = ' ';

        for (int index = 0; index < s.length(); index++) {
            map.put(s.charAt(index), map.getOrDefault(s.charAt(index), 0) +1);
            int frq = map.get(s.charAt(index));

            if(frq>mostF){
                mostF = frq;
                mostCh = s.charAt(index);
            }
        }
        int count = 0;
        mostF = 0;

        for (int index = 0; index < s.length(); index++) {

            if(s.charAt(index) == mostCh){
                count++;
            }else if(k>0){
                k--;
                count++;

            }else {
                count=0;
            }
            mostF = count>mostF ? count : mostF;
        }
        return mostF;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(testCharacterReplacement("XYYX", 2, 4)); // Expected: 4
        System.out.println(testCharacterReplacement("AAABABB", 1, 5)); // Expected: 5
        System.out.println(testCharacterReplacement("AABABBA", 1, 4)); // Expected: 4
        System.out.println(testCharacterReplacement("AAAA", 2, 4)); // Expected: 4
        System.out.println(testCharacterReplacement("ABCDE", 3, 4)); // Expected: 4
        System.out.println(testCharacterReplacement("ABBB", 2, 4)); // Expected: 4
        System.out.println(testCharacterReplacement("ABAB", 2, 4)); // Expected: 4
        System.out.println(testCharacterReplacement("AAAAA", 0, 5)); // Expected: 5
        System.out.println(testCharacterReplacement("A", 0, 1)); // Expected: 1
        System.out.println(testCharacterReplacement("", 2, 0)); // Expected: 0
    }

    public static String testCharacterReplacement(String s, int k, int expected) {
        int result = characterReplacement(s, k);
        return result == expected ? "PASS" : "FAIL: got " + result + " but expected " + expected;
    }


}
