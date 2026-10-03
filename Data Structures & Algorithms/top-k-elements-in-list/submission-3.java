class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((a,b) -> Integer.compare(map.get(b), map.get(a)));
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
