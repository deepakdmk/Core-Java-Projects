import java.util.Arrays;

//https://leetcode.com/problems/merge-sorted-array/

public class MergeSortedArray {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int j = 0;
		if (n > 0 ) {
			for (int i = m; i < nums1.length; i++) {
				nums1[i] = nums2[j];
				j++;
			}
		} else if (m <= 0) {
			for (int i = 0; i < nums1.length; i++) {
				nums1[i] = nums2[j];
				j++;
			}
		} else {
			Arrays.sort(nums1);
		} 
		Arrays.sort(nums1);
	}

}
