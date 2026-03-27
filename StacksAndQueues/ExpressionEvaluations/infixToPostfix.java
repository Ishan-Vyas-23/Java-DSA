package StacksAndQueues.ExpressionEvaluations;

import java.util.Stack;

public class infixToPostfix {
    // ==================== INFIX TO POSTFIX CONVERSION RULES ====================
    //
    // 1. OPERAND (letters, digits):
    //    - Simply append to result
    //
    // 2. OPENING BRACKET '(':
    //    - Push to stack
    //
    // 3. CLOSING BRACKET ')':
    //    - Pop from stack and append to result until you find '('
    //    - Remove the '(' from stack (don't add to result)
    //
    // 4. OPERATOR (+, -, *, /, ^):
    //    - If stack is empty OR current operator has HIGHER priority than stack top:
    //        → Push to stack
    //    - Otherwise:
    //        → Keep popping operators from stack and append to result
    //        → Stop when you find a LOWER priority operator or stack becomes empty
    //        → Then push current operator to stack
    //
    // 5. SPECIAL CASE - '^' (Exponentiation):
    //    - Has RIGHT associativity (unlike other operators)
    //    - For equal priority, '^' should NOT pop another '^' from stack
    //    - Example: a^b^c should become abc^^ not ab^c^
    //
    // 6. AFTER PROCESSING ALL CHARACTERS:
    //    - Pop all remaining operators from stack and append to result
    //
    // PRIORITY: ^ (highest) > * / > + - (lowest)
    //
    // ===========================================================================

    public static String infixToPostfix(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        int len = s.length();
        for(int i = 0 ; i < len ; i++){
            char ch = s.charAt(i);
            if( ( ch <= 'z' && ch >= 'a' ) || ( ch >= 'A' && ch <= 'Z' ) || ( ch <= '9' && ch >= '0' ) ){
                res.append(ch);
            }else{
                if(ch == '(')stack.push(ch);
                else if(ch == ')'){
                    while(!stack.isEmpty() && stack.peek() != '('){
                        res.append(stack.pop());
                    }
                    if(!stack.isEmpty())stack.pop();
                }else{
                    while (!stack.isEmpty()  && ( priority(stack.peek()) > priority(ch) || (priority(stack.peek()) == priority(ch) && ch != '^'))) {
                        res.append(stack.pop());
                    }
                    stack.push(ch);
                }
            }
        }
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        return new String(res);
    }

    public static int priority(char ch) {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        if (ch == '^') return 3;
        return -1;
    }
}