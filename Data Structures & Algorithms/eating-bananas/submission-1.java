class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // 最慢速度
        int left = 1;
        // 最快只需要到最大 pile
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            long hours = 0;
            // 如果速度为 mid，需要多少小时？
            for (int pile : piles) {
                hours += (pile + mid - 1) / mid;
            }
            if (hours <= h) {
                // mid 可以完成
                // 但我们要找最小速度
                // 所以继续向左找
                right = mid;
            } else {
                // mid 太慢了
                // 必须提高速度
                left = mid + 1;
            }
        }
        return left;
    }
}