class Solution {
    public int maxArea(int[] heights) {
        int res = 0;
        int left = 0;
        int right = heights.length - 1;
        while(left < right){
            int vol = (right - left) * Math.min(heights[left], heights[right]);
            res = Math.max(vol, res);
            if(left < right && heights[left] <= heights[right]){
                left++;
            } else if(left < right && heights[left] > heights[right]){
                right--;
            }
        }
        return res;
    }
}
