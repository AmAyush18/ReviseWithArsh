// LeetCode Problem Link: https://leetcode.com/problems/evaluate-reverse-polish-notation/description/

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();

        for(int i = 0; i < tokens.length; i++){
            if(isOperator(tokens[i])){
                int op2 = Integer.parseInt(st.pop()); 
                int op1 = Integer.parseInt(st.pop()); 
                String ans = operate(op1, op2, tokens[i]);
                st.push(ans);
            }else{
                st.push(tokens[i]);
            }
        }
        return Integer.parseInt(st.pop());
    }

    public boolean isOperator(String op){
        return op.equals("+") || op.equals("*") || op.equals("/") || op.equals("-");
    }

    public String operate(int op1, int op2, String OP){
        char op = OP.charAt(0);
        int ans = 0;
        if(op == '+'){
            ans = op1 + op2;
        }else if(op == '-'){
            ans = op1 - op2;
        }else if(op == '*'){
            ans = op1 * op2;
        }else if(op == '/'){
            ans = op1 / op2;
        }

        return ans+"";
    }
}
