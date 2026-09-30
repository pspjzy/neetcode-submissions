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

            /*
             * left 从 i 后面的第一个元素开始
             *
             * right 从数组最后一个元素开始
             */
            int left = i + 1;
            int right = nums.length - 1;


            /*
             * 第三步：
             * 使用 Two Pointers 寻找另外两个数字
             */
            while (left < right) {

                /*
                 * 当前三个数字的和
                 *
                 * 用 long 是为了防止整数溢出。
                 *
                 * 比如三个很大的 int 相加，
                 * 有可能超过 Integer.MAX_VALUE。
                 */
                long sum =
                        (long) nums[i]
                        + nums[left]
                        + nums[right];


                /*
                 * 情况 1：
                 *
                 * sum < 0
                 *
                 * 说明总和太小。
                 *
                 * 因为数组已经排序，
                 * 想让 sum 变大，
                 * 就需要让 left 指向更大的数字。
                 */
                if (sum < 0) {
                    left++;
                }


                /*
                 * 情况 2：
                 *
                 * sum > 0
                 *
                 * 说明总和太大。
                 *
                 * 想让 sum 变小，
                 * 就需要让 right 指向更小的数字。
                 */
                else if (sum > 0) {
                    right--;
                }


                /*
                 * 情况 3：
                 *
                 * sum == 0
                 *
                 * 找到一个合法答案。
                 */
                else {

                    /*
                     * 把三个数字加入结果。
                     *
                     * 注意这里保存的是 value，
                     * 不是 index。
                     */
                    result.add(
                            Arrays.asList(
                                    nums[i],
                                    nums[left],
                                    nums[right]
                            )
                    );


                    /*
                     * 当前组合已经使用过了，
                     * 两个指针都往中间移动。
                     */
                    left++;
                    right--;


                    /*
                     * left 去重
                     *
                     * 例如：
                     *
                     * [-2, 0, 0, 0, 2]
                     *      ↑
                     *
                     * 已经找到 [-2, 0, 2]
                     *
                     * 后面的 0 如果继续用，
                     * 还是会得到 [-2, 0, 2]。
                     *
                     * 所以直接跳过重复的 0。
                     */
                    while (
                            left < right
                            && nums[left] == nums[left - 1]
                    ) {
                        left++;
                    }


                    /*
                     * right 去重
                     *
                     * 原理和 left 一样。
                     *
                     * 注意这里比较的是：
                     * nums[right] == nums[right + 1]
                     *
                     * 因为 right 刚刚已经 right-- 了。
                     */
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
