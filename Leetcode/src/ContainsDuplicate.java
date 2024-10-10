import java.util.HashSet;

//https://leetcode.com/problems/contains-duplicate/
public class ContainsDuplicate {
	
    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> checker = new HashSet<>();

        for (int temp: nums){
            if (checker.contains(temp))
            {

            return true;

            }
            
            checker.add(temp);
        }
        return false;
    }

}
