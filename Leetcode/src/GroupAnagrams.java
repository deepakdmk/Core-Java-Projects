import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/group-anagrams/
public class GroupAnagrams {

	public List<List<String>> groupAnagrams(String[] strs) {

		List<List<String>> answer = new ArrayList<List<String>>();

		for (int j = 0; j < strs.length; j++) {
			List<String> tempAnagram = new ArrayList<String>();
			tempAnagram.add(strs[j]);
			for (int i = 0; i < strs.length; i++) {

				if (!strs[j].equalsIgnoreCase(strs[i])) {

					List<String> words = new ArrayList<>();
					if (isAnagram(strs[j], strs[i])) {
						tempAnagram.add(strs[i]);
					}
				}
			}
			// write a comparison here before u add the tempAnagram arraylist to the final
			// answer arraylist
//			for (List<String> temp: if (!answer.e(tempAnagram)) {
			answer.add(tempAnagram);
//			}
		}
		return answer;
	}

	public boolean isAnagram(String s, String t) {
		List<String> listOne = Arrays.asList(s.split(""));
		List<String> listTwo = Arrays.asList(t.split(""));

		if (listOne.size() == listTwo.size()) {
			return listOne.containsAll(listTwo) && listTwo.containsAll(listOne);
		}
		return false;
	}
}