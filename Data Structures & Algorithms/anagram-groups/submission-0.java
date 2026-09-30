class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for(String str: strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);
            res.putIfAbsent(sorted, new ArrayList<>());
            if(res.containsKey(sorted)){
                res.get(sorted).add(str);
            }
        }
        return new ArrayList(res.values());
    }
}
