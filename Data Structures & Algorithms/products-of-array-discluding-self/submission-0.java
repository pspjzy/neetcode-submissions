class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroCount = 0;
        for(int i: nums){
            if(i==0){
                zeroCount++;
            } else {
                product *= i;
            }
            
        }
        for(int i = 0; i < nums.length; i++){
            if(zeroCount >= 2){
                nums[i] = 0;
            } else if(zeroCount == 1){
                nums[i] = nums[i] == 0 ? product : 0;
            } else {
                nums[i] = product/nums[i];
            }
            
        }
        return nums;
    }
}  
