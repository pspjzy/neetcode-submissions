class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 保证 nums1 是更短的数组
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int left = 0;
        int right = nums1.length;
        while (left <= right) {
            // nums1 左边取 firstMid 个
            int firstMid = left + (right - left) / 2;
            // nums2 左边取 secMid 个
            int secMid = (nums1.length + nums2.length + 1) / 2 - firstMid;
            // nums1 partition 左右边界
            int Aleft = (firstMid == 0) ? Integer.MIN_VALUE : nums1[firstMid - 1];
            int Aright = (firstMid == nums1.length) ? Integer.MAX_VALUE : nums1[firstMid];
            // nums2 partition 左右边界
            int Bleft = (secMid == 0) ? Integer.MIN_VALUE : nums2[secMid - 1];
            int Bright = (secMid == nums2.length) ? Integer.MAX_VALUE : nums2[secMid];
            // 找到正确 partition
            if (Aleft <= Bright && Bleft <= Aright) {
                // 总长度是奇数
                if ((nums1.length + nums2.length) % 2 == 1) {
                    return Math.max(Aleft, Bleft);
                }
                // 总长度是偶数
                return (Math.max(Aleft, Bleft)+Math.min(Aright, Bright)) / 2.0;
            } else if (Aleft > Bright) {// nums1 左边拿太多了
                right = firstMid - 1;
            } else { // nums1 左边拿太少了
                left = firstMid + 1;
            }
        }
        return 0.0;
    }
}