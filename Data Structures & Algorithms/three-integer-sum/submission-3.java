class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 最终答案
        List<List<Integer>> result = new ArrayList<>();

        /*
         * 第一步：排序
         *
         * 例如：
         * 原数组：
         * [-1, 0, 1, 2, -1, -4]
         *
         * 排序后：
         * [-4, -1, -1, 0, 1, 2]
         *
         * 排序非常重要，因为之后我们才能：
         * sum 太小 -> left++
         * sum 太大 -> right--
         */
        Arrays.sort(nums);


        /*
         * 第二步：固定第一个数字 nums[i]
         *
         * 三个数字：
         *
         * nums[i] + nums[left] + nums[right] = 0
         *
         * 固定 nums[i] 后，
         * 问题就变成：
         *
         * nums[left] + nums[right] = -nums[i]
         *
         * 这其实就是 Two Sum II。
         */
        for (int i = 0; i < nums.length - 2; i++) {

            /*
             * 去重：跳过重复的第一个数字
             */
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                long sum =
                        (long) nums[i]
                        + nums[left]
                        + nums[right];

                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    result.add(
                            Arrays.asList(
                                    nums[i],
                                    nums[left],
                                    nums[right]
                            )
                    );
                    left++;
                    right--;
                    while (
                            left < right
                            && nums[left] == nums[left - 1]
                    ) {
                        left++;
                    }
                    while (
                            left < right
                            && nums[right] == nums[right + 1]
                    ) {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}
