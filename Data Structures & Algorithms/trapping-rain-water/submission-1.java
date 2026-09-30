class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;
        while (left < right) {
            // 左边柱子更矮
            if (height[left] < height[right]) {
                // 更新左边最高柱子
                leftMax = Math.max(leftMax, height[left]);
                // 当前 left 能装多少水
                water += leftMax - height[left];
                left++;
            } else {
                // 更新右边最高柱子
                rightMax = Math.max(rightMax, height[right]);
                // 当前 right 能装多少水
                water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }
}
