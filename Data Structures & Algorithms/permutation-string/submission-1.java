
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if (n > m) {
            return false;
        }

        int[] need = new int[26];
        int[] window = new int[26];

        // 记录 s1 和 s2 第一个窗口的字符频率
        for (int i = 0; i < n; i++) {
            need[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(need, window)) {
            return true;
        }

        // 固定长度窗口向右移动
        for (int right = n; right < m; right++) {

            // 新字符进入窗口
            window[s2.charAt(right) - 'a']++;

            // 最左边的旧字符离开窗口
            window[s2.charAt(right - n) - 'a']--;

            if (Arrays.equals(need, window)) {
                return true;
            }
        }

        return false;
    }
}