class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> s = new ArrayDeque<>();
        for(int i = 0; i < temperatures.length; i++){
            while(!s.isEmpty() && temperatures[i] > temperatures[s.peek()]){
                int prev = s.pop();
                res[prev] = i - prev;
            }
            s.push(i);
        }
        return res;
    }
}
