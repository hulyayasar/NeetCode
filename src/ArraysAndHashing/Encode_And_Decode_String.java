package ArraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Encode_And_Decode_String {

    public static String encode(List<String> strs) {

        String str="";
        for(String s: strs){
            str=str + " " + s;
        }

        return str + " ";

    }

    public static List<String> decode(String str) {

        List<String> list = new ArrayList<String>();
        if (str.length() == 0) {
            return list;
        }
        String s;
        int start =1;

        for(int i = 1; i<str.length(); i++){
            if(str.charAt(i) == ' '){
                s= str.substring(start, i);
                list.add(s);
                start = i+1;
            }
        }

        return list;
    }

    public static void main(String[] args) {

        List<String> list = Arrays.asList("neet","code","love","you");
        String str = " neet code love you ";
        System.out.println(encode(list));  //
         System.out.println(decode(str));


    }

}
