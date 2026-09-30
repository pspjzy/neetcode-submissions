class Solution {
    public int maxArea(int[] heights) {
        int res = 0;
        int left = 0;
        int right = heights.length - 1;
        while(left < right){
            int water = Math.min(heights[left], heights[right]) * (right-left);
            res = Math.max(water, res);
            if(heights[left] < heights[right]){
                left++;
            } else{
                right--;
            }
        }
        return res;
    }
}
