class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                // 最小值一定在 mid 右边
                left = mid + 1;
            } else {
                // 最小值在 mid 或 mid 左边
                right = mid;
            }
        }
        return nums[left];
    }
}