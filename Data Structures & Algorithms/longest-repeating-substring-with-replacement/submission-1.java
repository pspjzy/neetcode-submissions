class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int res = 0;
        int mostFreqCharCount = 0;
        int[] count = new int[26];
        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            count[c - 'A']++;
            mostFreqCharCount = Math.max(mostFreqCharCount, count[c - 'A']);
            while(right - left + 1 - mostFreqCharCount > k){
                count[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
