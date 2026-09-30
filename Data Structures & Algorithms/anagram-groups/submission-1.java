class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for(String str: strs){
            char[] charArray = str.toCharArray();
            int[] charCount = new int[26];
            for(char a: charArray){
                charCount[a - 'a']++;
            }
            String key = Arrays.toString(charCount);
            // Arrays.sort(charArray);
            // String sorted = new String(charArray);
            // res.putIfAbsent(sorted, new ArrayList<>());
            // if(res.containsKey(sorted)){
            //     res.get(sorted).add(str);
            // }
            res.putIfAbsent(key, new ArrayList<>());
            if(res.containsKey(key)){
                res.get(key).add(str);
            }
        }
        return new ArrayList(res.values());
    }
}
