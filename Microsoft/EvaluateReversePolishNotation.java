/** You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer. **/


class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack1 = new Stack();
        for(String T: tokens){
            if("+-*/".contains(T))
                stack1.push(eval(stack1.pop(),stack1.pop(),T));
                else
                stack1.push(Integer.parseInt(T));
        }
        return stack1.pop();
        
    }
    private int eval(int b,int a,String op){
        if("+".equals(op)) return a+b;
        else if("-".equals(op)) return a-b;
        else if("/".equals(op)) return a/b;
        else return a*b;
    }
}