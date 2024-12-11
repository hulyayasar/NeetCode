package Stack;

import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {

    public static int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        int result = Integer.parseInt(tokens[0]) ;

        for(int i=1; i< tokens.length; i++){
            String s = tokens[i];

            if(!(s.equals("+")  || s.equals("-") || s.equals("*")  || s.equals("/") )){
                stack.push(Integer.parseInt(s));
            }
            else{
                int num = stack.pop().intValue();
                switch (s){
                    case "+":
                        result = result +num;
                        break;
                    case "-":
                        result = result - num;
                        break;
                    case "*":
                        result = result *num;
                        break;
                    case "/":
                        result = result / num;
                        break;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {

        String [] tokens = {"1","2","+","3","*","4","-"};
        System.out.println(evalRPN(tokens));



    }
}
