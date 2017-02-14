package arrays;

public class Qarrays {

    public static void main(String args[]){
        System.out.println("Welcome to Practice session");
        InnerClassArrays innerClassArrays = new InnerClassArrays();
        int[] num2 = {1,3,5};
        int[] num1 = {2};
        System.out.println(innerClassArrays.findMedianSortedArrays(num1, num2));
    }



    public static class InnerClassArrays {

        // Median of Two Sorted Arrays
        /*
        There are two sorted arrays nums1 and nums2 of size m and n respectively.

        Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
        nums1 = [1, 3]
        nums2 = [2]

        The median is 2.0

         */

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int[] mergedArray = mergeSortedArrays(nums1, nums2);
            int len = mergedArray.length;
            return len%2==0 ? (mergedArray[(len-1)/2] + mergedArray[len/2])/2 : mergedArray[len/2];
        }

        private int[] mergeSortedArrays(int nums1[], int[] nums2) {
            if(nums1.length == 0) {
                return nums2;
            }
            if(nums2.length == 0) {
                return nums1;
            }

            int[] mergedSortedArray = new int[nums1.length + nums2.length];
            int k=0;
            for(int i =0, j=0  ;i < nums1.length && j< nums2.length;) {
                if(nums1[i] < nums2[j]) {
                    mergedSortedArray[k] = nums1[i];
                    i++;
                    k++;
                }
                else if(nums1[i] > nums2[j]) {
                    mergedSortedArray[k] = nums2[j];
                    j++;
                    k++;
                }
                else if(nums1[i] == nums2[j]) {
                    mergedSortedArray[k] = nums1[i];
                    k++;
                    mergedSortedArray[k] = nums2[j];
                    k++;
                }
                if(i == nums1.length - 1) {
                    return copyRemainingArray(j,nums2, mergedSortedArray, k);
                }
                if(j == nums2.length - 1) {
                    return copyRemainingArray(i,nums1, mergedSortedArray, k);
                }
            }
            return mergedSortedArray;
        }

        private int[] copyRemainingArray(int index, int[] nums, int[] mergedSort, int mergeCounter) {
            for(int rem=index;rem<nums.length ; rem++) {
                mergedSort[mergeCounter] = nums[rem];
                mergeCounter ++;
            }
            return mergedSort;
        }

    }
}
