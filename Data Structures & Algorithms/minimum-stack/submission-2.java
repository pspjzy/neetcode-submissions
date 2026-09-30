class MinStack {

    // 正常存所有元素
    private Deque<Integer> stack;
    // 专门存当前最小值
    private Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int val) {

        // 正常入栈
        stack.push(val);

        // 如果 minStack 为空
        // 或者 val 比当前最小值还小/相等
        // 就同时放进 minStack
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        int removed = stack.pop();
        // 如果删除的正好是当前最小值
        // minStack 也要同步删除
        if (removed == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}