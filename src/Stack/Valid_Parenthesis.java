package Stack;

import java.util.Stack;

public class Valid_Parenthesis {

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length(); i++){
            char c = s.charAt(i);



            if(c =='(' || c =='{' || c =='['){
                stack.push(c);
            }
            else if(c ==')' && stack.peek() != '('){
                return false;
            }else if(c ==']' && stack.peek() != '['){
                return false;
            }else if(c =='}' && stack.peek() != '{'){
                return false;
            }
            else{
                stack.pop();

            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "[]";
        System.out.println(isValid(s));

    }
}
