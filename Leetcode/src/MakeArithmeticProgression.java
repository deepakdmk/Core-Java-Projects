
import java.util.ArrayList;
import java.util.Collections;

// https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/description/
public class MakeArithmeticProgression {
//sort the array and check if differences of the sequences

    public Boolean canMakeArithmetic(int[] arr) {
        ArrayList<Integer> set = new ArrayList<Integer>();
        for (int i : arr) {
            set.add(i);
        }

        Collections.sort(set);
        int difference = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == difference || arr[i] - arr[i - 1] == ~difference) {
                return true;
            }
        }
        return false;
    }

}
