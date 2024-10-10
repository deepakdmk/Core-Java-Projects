//https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
public class RemoveDuplicatesFromSortedArray {

	public int removeDuplicates(int[] nums) {
		int pointerLeft = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
			} else {
				nums[pointerLeft] = nums[i];
				pointerLeft++;
			}
		}
		return pointerLeft;
	}

}
