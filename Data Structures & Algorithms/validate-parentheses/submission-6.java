class Solution {
    public boolean isValid(String s) {
        Stack <Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                char rightPart = stack.pop();
                if((c == ')' && rightPart != '(') 
                    || (c == ']' && rightPart != '[') 
                    || (c == '}' && rightPart != '{')){
                        return false;
                    }
            }
        }
        return stack.isEmpty();
    }
}
