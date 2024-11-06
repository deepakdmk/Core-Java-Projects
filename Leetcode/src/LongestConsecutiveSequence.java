
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/longest-consecutive-sequence/
public class LongestConsecutiveSequence {

    public int longestConsecSequence(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        int counter = 0;
        int thisCount = 0; //1//2
        int currentNumb = 0; //3//

        for (int i = 0; i < nums.length; i++) {

            if (set.contains(nums[i] - 1)) {
                if (currentNumb == nums[i]) {

                    thisCount++;

                }

                    currentNumb = nums[i];
            }

        }

        return counter;

    }
}
