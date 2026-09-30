class Solution {
    public int[] productExceptSelf(int[] nums) {
        // int product = 1;
        // int zeroCount = 0;
        // for(int i: nums){
        //     if(i==0){
        //         zeroCount++;
        //     } else {
        //         product *= i;
        //     }
            
        // }
        // for(int i = 0; i < nums.length; i++){
        //     if(zeroCount >= 2){
        //         nums[i] = 0;
        //     } else if(zeroCount == 1){
        //         nums[i] = nums[i] == 0 ? product : 0;
        //     } else {
        //         nums[i] = product/nums[i];
        //     }
            
        // }
        // return nums;

        int[] pre = new int[nums.length];
        int[] suf = new int[nums.length];
        int[] res = new int[nums.length];
        pre[0] = 1;
        for(int i = 1; i < pre.length; i++){
            pre[i] = pre[i-1] * nums[i-1];
        }
        suf[suf.length-1] = 1;
        for(int i = suf.length-2; i >= 0; i--){
            suf[i] = suf[i+1] * nums[i+1];
        }
        for(int i = 0; i < res.length; i++){
            res[i] = pre[i] * suf[i];
        }
        return res;

    }
}  
