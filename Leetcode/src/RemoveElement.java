import java.util.ArrayList;
import java.util.Arrays;

//https://leetcode.com/problems/remove-element/?envType=study-plan-v2&envId=top-interview-150
public class RemoveElement {

	
    public int removeElement(int[] nums, int val) {
        Arrays.sort(nums);
        int counter =0;

        ArrayList<Integer> reArranged= new ArrayList<>();
    	
        for(int i=0;i<nums.length;i++) {
        	if (nums[i]== val) {
        		counter++;
        	} else {
        		reArranged.add(nums[i]);
        	}	
        }
        int k = nums.length-counter;
        for(int i=0;i<k;i++) {
        	nums[i]=reArranged.get(i);
        }
        return k;
    }   
}
