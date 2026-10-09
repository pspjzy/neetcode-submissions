class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> index = new ArrayDeque<>();
        int maxArea = 0;
        for(int i=0; i<=heights.length; i++){
            int currentH = i == heights.length ? 0 : heights[i];
            while(!index.isEmpty() && currentH < heights[index.peek()]){
                int h = heights[index.pop()];
                int w = index.isEmpty() ? i : i - index.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            index.push(i);
        }
        return maxArea;
    }
}
