
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/longest-consecutive-sequence/
/*
0) create hashset so u can use the methods, we'll have one global variable thats the highest count
1) loop through the set
2) if the number doesnt contain a previous sequence, start tracking the variable. and start the current count
4) now check the front sequence and see how many there are, make sure to increment the tracked number and the count till no more
5) then before exiting the loop, this sequence will check against the global sequence to see which one has higher amount.

 */

public class LongestConsecutiveSequence {

    public int longestConsecSequence(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        // create a global count
        int count = 0;

        for (int i : set) {

            System.out.println("Iterated variable number=" + i);
            System.out.println(
                    "does it contain the previous number " + i + "-1=" + (i - 1) + " ? - " + set.contains(i - 1));

            if (!set.contains(i - 1)) {
                System.out.println("Begin counting a sequence ---");
                int startNumber = i;
                int sequence = 1;

                System.out.println(
                        "Does it contain the next sequence: " + startNumber + "+1=" + (startNumber + 1) + " ? - "
                                + set.contains(startNumber + 1));

                while (set.contains(startNumber + 1)) {
                    startNumber += 1;
                    sequence += 1;

                    System.out.println("startNumber and sequence is = " + startNumber + " , " +
                            sequence);
                }
                System.out.println("Based on previous sequence count = " + count);
                if (count > sequence) {
                    System.out.println("This sequence doesnt make the cut = " + sequence);
                } else {

                    System.out.println("This made the cut: " + sequence);
                }
                ;
                count = Math.max(count, sequence);
            }
        }

        return count;

    }

}
