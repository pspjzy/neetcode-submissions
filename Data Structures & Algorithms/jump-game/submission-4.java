class Solution {
    // public boolean canJump(int[] nums) {
    //     int goal = nums.length - 1;
    //     for(int i=nums.length-2; i>=0; i--){
    //         if(i + nums[i] >= goal){
    //             goal = i;
    //         }
    //     }
    //     return goal == 0;
    // }

    //正向
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for(int i=0; i<nums.length; i++){
            if(i > maxReach){
                return false;
            }
            maxReach = Math.max(maxReach, nums[i]+i);
            if(maxReach >= nums.length - 1){
                return true;
            }
        }
        return false;
    }
}
