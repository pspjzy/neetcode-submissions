class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(c=='(' || c=='{' || c=='['){
                stack.push(c);
            } else {
                // 没有对应的左括号
                if (stack.isEmpty()) {
                    return false;
                }
                // 取出最近的左括号
                char top = stack.pop();
                // 检查是否匹配
                if (c == ')' && top != '(') {
                    return false;
                }
                if (c == ']' && top != '[') {
                    return false;
                }
                if (c == '}' && top != '{') {
                    return false;
                }
            }
        }
        // 最后 stack 必须为空
        return stack.isEmpty();
    }
}
