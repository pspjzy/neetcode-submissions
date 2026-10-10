class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int res = 0;
        Set<Character> set = new HashSet<>();
        while(right <= s.length() - 1){
            char c = s.charAt(right);
            while(set.contains(c)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
