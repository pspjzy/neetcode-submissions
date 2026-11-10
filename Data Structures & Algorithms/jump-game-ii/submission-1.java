class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;
        for(int i=0; i<nums.length-1; i++){
            //当前最远能跳
            farthest = Math.max(farthest, nums[i]+i);
            //已到达当前最远，必须+一跳
            if(i == currentEnd){
                jumps++;
                currentEnd = farthest;
            }
        }
        return jumps;
    }
}
