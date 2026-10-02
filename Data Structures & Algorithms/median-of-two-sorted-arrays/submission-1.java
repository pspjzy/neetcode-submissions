class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 保证 nums1 是更短的数组
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int left = 0;
        int right = m;
        while (left <= right) {
            // nums1 左边取 i 个
            int i = left + (right - left) / 2;
            // nums2 左边取 j 个
            int j = (m + n + 1) / 2 - i;
            // nums1 partition 左右边界
            int Aleft = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int Aright = (i == m) ? Integer.MAX_VALUE : nums1[i];
            // nums2 partition 左右边界
            int Bleft = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int Bright = (j == n) ? Integer.MAX_VALUE : nums2[j];
            // 找到正确 partition
            if (Aleft <= Bright && Bleft <= Aright) {
                // 总长度是奇数
                if ((m + n) % 2 == 1) {
                    return Math.max(Aleft, Bleft);
                }
                // 总长度是偶数
                return (Math.max(Aleft, Bleft)+Math.min(Aright, Bright)) / 2.0;
            }
            // nums1 左边拿太多了
            else if (Aleft > Bright) {
                right = i - 1;
            }
            // nums1 左边拿太少了
            else {
                left = i + 1;
            }
        }
        return 0.0;
    }
}