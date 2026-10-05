class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    res.add(triplet);
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left-1]){
                        left++;
                    }
                     while(left < right && nums[right] == nums[right+1]){
                        right--;
                    }
                } else if(sum < 0){
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
