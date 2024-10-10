import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/valid-anagram/
public class ValidAnagram {
	
	
	public boolean isAnagram(String s, String t) {
		List<String> listOne = Arrays.asList(s.split(""));
		List<String> listTwo = Arrays.asList(t.split(""));

		if (listOne.size() == listTwo.size()) {
			return listOne.containsAll(listTwo) && listTwo.containsAll(listOne);
		}
		return false;
	}
	
}
