class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        int res = 0;
        for(int n: nums){
            numsSet.add(n);
        }
        for(int n: numsSet){
            if(n==Integer.MIN_VALUE || !numsSet.contains(n-1)){
                int current = n;
                int count = 1;
                while(current!=Integer.MIN_VALUE && numsSet.contains(current+1)){
                    count++;
                    current++;
                }
                res = Math.max(count, res);
            }
        }
        return res;
        // if (nums.length == 0) return 0;
        // Arrays.sort(nums);

        // int longest = 1;
        // int count = 1;

        // for (int i = 1; i < nums.length; i++) {
        //     if (nums[i] == nums[i - 1]) {
        //         continue;
        //     }

        //     if ((long) nums[i] - nums[i - 1] == 1) {
        //         count++;
        //     } else {
        //         count = 1;
        //     }

        //     longest = Math.max(longest, count);
        // }

        // return longest;
    }
}
