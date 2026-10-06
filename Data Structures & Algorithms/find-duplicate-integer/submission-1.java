class Solution {
    public int findDuplicate(int[] nums) {
         Set<Integer> seen = new HashSet<>();

        int cur = nums[0];

        while (!seen.contains(cur)) {
            seen.add(cur);
            cur = nums[cur];
        }

        return cur;
    }
}
