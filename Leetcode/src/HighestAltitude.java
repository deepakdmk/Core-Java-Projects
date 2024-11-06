
import java.util.Arrays;

public class HighestAltitude {

    public int largestAltitude(int[] gain) {

        for (int i : gain) {
            System.out.println("Numbers before sorted=" + i);
        }

        Arrays.parallelSort(gain);
        int lastNumber=gain[gain.length-1];
        System.out.println(lastNumber + " = last number");
        return Math.max(0,lastNumber);

    }
}
