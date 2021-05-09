package com.code;

/**
 * @author: guoyongkui
 * @date: 2020/5/11 21:52
 * @projectName: holdon
 * @description:
 */
public class FindMedianSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0;
        int[] result = new int[nums1.length + nums2.length];
        int m = 0;
        int i = 0;
        int j = 0;
        while (i < nums1.length || j < nums2.length){
            if (i < nums1.length && j < nums2.length){
                if (nums1[i] <= nums2[j]){
                    result[m] = nums1[i];
                    i++;
                }else {
                    result[m] = nums2[j];
                    j++;
                }
                m++;
                continue;
            }
            if (i >= nums1.length){
                result[m] = nums2[j];
                j++;
                m++;
                continue;
            }
            if (j >= nums2.length){
                result[m] = nums1[i];
                i++;
                m++;
            }
        }
        int size = result.length;
        if (size == 1) return result[0];
        if (size%2 != 0){
            median = result[size/2];
        }else {
            median = (double)(result[size/2 - 1] + result[size/2])/2;
        }
        return median;
    }

    public static double findMedianSortedArrays1(int[] A, int[] B) {
            int m = A.length;
            int n = B.length;
        // to ensure m<=n
            if (m > n) {
                int[] temp = A; A = B; B = temp;
                int tmp = m; m = n; n = tmp;
            }
            int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
            while (iMin <= iMax) {
                int i = (iMin + iMax) / 2;
                int j = halfLen - i;
                if (i < iMax && B[j-1] > A[i]){
                    // i is too small
                    iMin = i + 1;
                } else if (i > iMin && A[i-1] > B[j]) {
                    // i is too big
                    iMax = i - 1;
                } else {
                    // i is perfect
                    int maxLeft = 0;
                    if (i == 0) { maxLeft = B[j-1]; }
                    else if (j == 0) { maxLeft = A[i-1]; }
                    else { maxLeft = Math.max(A[i-1], B[j-1]); }
                    if ( (m + n) % 2 == 1 ) { return maxLeft; }

                    int minRight = 0;
                    if (i == m) { minRight = B[j]; }
                    else if (j == n) { minRight = A[i]; }
                    else { minRight = Math.min(B[j], A[i]); }

                    return (maxLeft + minRight) / 2.0;
                }
            }
            return 0.0;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4, 5};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
