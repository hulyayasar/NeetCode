package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class PermutationInString {


    //set is not properly works, cause i also want duplicated chat in my  set
    public static boolean checkInclusion(String s1, String s2) {

        Set<Character> set = new HashSet<>();
        boolean flag = true;

        if(s1.length() ==0) return true;
        if(s1.length()> s2.length()) return false;

        for (int index = 0; index < s1.length()-1; index++) {
            set.add(s2.charAt(index));
        }

        //System.out.println("set before" + set);

        for(int i =0; i<s2.length()-s1.length() ; i++){

            set.add(s2.charAt(i+s1.length()-1));
            flag = true;

            for (int index = 0; index < s1.length(); index++) {

                if(!set.contains(s1.charAt(index))){
                    flag = false;
                    break;
                }
            }
            if(flag) return flag;

            set.remove(s2.charAt(i));
            //System.out.println("set end of loop" + set);
        }

        return flag;

    }

    //optimal solution like a dynamic programing but for 26 size array
    //understand it but havent tried to write myself

        public static boolean checkInclusion_2(String s1, String s2) {
            if (s1.length() > s2.length()) {
                return false;
            }

            int[] s1Count = new int[26];
            int[] s2Count = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                s1Count[s1.charAt(i) - 'a']++;
                s2Count[s2.charAt(i) - 'a']++;
            }

            int matches = 0;
            for (int i = 0; i < 26; i++) {
                if (s1Count[i] == s2Count[i]) {
                    matches++;
                }
            }

            int l = 0;
            for (int r = s1.length(); r < s2.length(); r++) {
                if (matches == 26) {
                    return true;
                }

                int index = s2.charAt(r) - 'a';
                s2Count[index]++;
                if (s1Count[index] == s2Count[index]) {
                    matches++;
                } else if (s1Count[index] + 1 == s2Count[index]) {
                    matches--;
                }

                index = s2.charAt(l) - 'a';
                s2Count[index]--;
                if (s1Count[index] == s2Count[index]) {
                    matches++;
                } else if (s1Count[index] - 1 == s2Count[index]) {
                    matches--;
                }
                l++;
            }
            return matches == 26;
        }

    public static void main(String[] args) {
        // Test cases
        System.out.println(testCheckInclusion("abc", "lecabee", true)); // Expected: true
        System.out.println(testCheckInclusion("abc", "lecaabee", false)); // Expected: false
        System.out.println(testCheckInclusion("a", "a", true)); // Expected: true
        System.out.println(testCheckInclusion("abc", "ab", false)); // Expected: false
        System.out.println(testCheckInclusion("ab", "eidbaooo", true)); // Expected: true
        System.out.println(testCheckInclusion("adc", "dcda", true)); // Expected: true
        System.out.println(testCheckInclusion("xyz", "abcdefg", false)); // Expected: false
        System.out.println(testCheckInclusion("", "abcdefg", true)); // Expected: true (empty string is a permutation of any string)
        System.out.println(testCheckInclusion("abc", "", false)); // Expected: false
        System.out.println(testCheckInclusion("aaa", "aaaaaa", true)); // Expected: true
    }

    public static String testCheckInclusion(String s1, String s2, boolean expected) {
        boolean result = checkInclusion(s1, s2);
        return result == expected ? "PASS" : "FAIL: got " + result + " but expected " + expected;
    }


}

