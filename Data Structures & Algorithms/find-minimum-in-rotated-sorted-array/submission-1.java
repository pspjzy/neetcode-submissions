class Solution {
    public int findMin(int[] nums) {
        int res = Integer.MAX_VALUE;
        for(int i: nums){
            res = Math.min(i, res);
        }
        return res;
    }
}
