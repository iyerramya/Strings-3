//time o(n)
//space o(n)

class Solution {
    public int calculate(String s) {
        int currentNum = 0;
        char currentSign = '+';
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if(Character.isDigit(c)) {
                currentNum = currentNum *10 + (c-'0');
            } if(c == '+' || c == '-' || c=='*' || c=='/' || i==s.length()-1) {
                if(currentSign == '+') {
                    stack.push(currentNum);
                }else if(currentSign == '-') {
                    stack.push(currentNum*-1);
                } else if(currentSign == '*') {
                    stack.push(stack.pop()*currentNum);
                } else if(currentSign == '/') {
                    stack.push(stack.pop()/currentNum);
                }
                currentSign = c;
                currentNum=0;
            }
        }
        
        int result = 0;
        while(!stack.isEmpty()) {
            result += stack.pop();
        }
        
        return result;
    }
}
