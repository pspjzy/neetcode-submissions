class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        // 1. 统计出现次数
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // 2. 把所有不同数字放入 List
        List<Integer> list = new ArrayList<>(count.keySet());

        // 3. 根据出现次数降序排序
        list.sort((a, b) -> Integer.compare(count.get(b), count.get(a)));

        // 4. 取前 K 个数字
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}