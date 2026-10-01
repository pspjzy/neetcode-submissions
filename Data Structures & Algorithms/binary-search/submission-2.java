class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        return helper(left, right, nums, target);
    }

    public int helper(int left, int right, int[] nums, int target){
        if(left > right){
            return -1;
        }
        
        int mid = left + (right-left) / 2;
        if(nums[mid] == target){
            return mid;
        } else if(target > nums[mid]){
            return helper(mid + 1, right, nums, target);
        } else {
            return helper(left, mid - 1, nums, target);
        }
    }
}
