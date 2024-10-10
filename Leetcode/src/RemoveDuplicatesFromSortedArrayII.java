//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/?envType=study-plan-v2&envId=top-interview-150

public class RemoveDuplicatesFromSortedArrayII {

	public int removeDuplicates(int[] nums) {
		if (nums.length <= 2) {
			return nums.length;
		}

		int counter = 2;

		for (int i = 2; i < nums.length; i++) {
			if (nums[i] != nums[counter - 2]) {
				nums[counter] = nums[i];
				counter++;
			}
		}
		return counter;
	}

}
