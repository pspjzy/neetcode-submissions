class Solution {
    public int search(int[] nums, int target) {
        // mid > right rotate part is on the right side
        // elsewise the right side is normally asended
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid]>=nums[left]){
                if(nums[left] <= target && nums[mid]>target){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                } 
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
