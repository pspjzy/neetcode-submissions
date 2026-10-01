class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++) {

            // 最后人为加一个高度 0
            // 用来把 stack 里剩余柱子全部结算
            int currentHeight =
                    (i == heights.length) ? 0 : heights[i];

            // 如果当前柱子更矮
            // 说明 stack 顶部柱子的右边界找到了
            while (
                !stack.isEmpty()
                && currentHeight < heights[stack.peek()]
            ) {
                int height = heights[stack.pop()];

                int width;

                if (stack.isEmpty()) {
                    // 左边没有更矮柱子
                    width = i;
                } else {
                    // 左边第一个更矮柱子 = stack.peek()
                    width = i - stack.peek() - 1;
                }
                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }

        return maxArea;
    }
}