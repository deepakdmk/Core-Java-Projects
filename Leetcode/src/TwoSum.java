// https://leetcode.com/problems/two-sum
/*

Brute Force Method -

    public int[] twoSum(int[] nums, int target) {

        int[] answer = { 0, 0 };
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target && i!=j) {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        return answer;
    }




 1)first i'll convert the int[] array into a hashset so i can use the methods contain
 2) initialize an empty {0,0} array first.
 3) 
 2)ill iterate through the list , take the first number, minus from the value i need, then make sure its non-negative. then use it to find the other value. 

*/

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        
    }
}
