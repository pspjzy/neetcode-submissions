class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for(int n: set){
            if(!set.contains(n-1)){
                int curr = n;
                int max = 1;
                while(set.contains(curr + 1)){
                    curr++;
                    max++;
                }
                res = Math.max(max,res);
            }
        }
        return res;
    }
}