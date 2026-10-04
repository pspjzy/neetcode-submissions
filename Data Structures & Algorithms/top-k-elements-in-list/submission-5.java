class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        List<Integer>[] busket = new ArrayList[nums.length+1];
        for (Map.Entry<Integer, Integer> e: map.entrySet()){
            if (busket[e.getValue()] == null){
                busket[e.getValue()] = new ArrayList<>();
            }
            busket[e.getValue()].add(e.getKey());
            
        }
        int[] res = new int[k];
        int index = 0;
        for(int i = busket.length - 1; i >= 0; i--){
            if(busket[i] == null){
                continue;
            }
            for(int n : busket[i]){
                if(index == k){
                    break;
                }
                res[index] = n;
                index++;
                
            } 
        }
        return res;
    }
}
