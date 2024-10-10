import java.util.InputMismatchException;
import java.util.Scanner;

//Just a bunch of methods that helps convert data to test solutions
public class HelperClass {

	public String stringInput() {
		Scanner in = new Scanner(System.in);
		return in.nextLine();
	}

	public static int[] stringToIntArray(String arrayOfNumbers) {
		String[] arrOfStr;
		int[] result;
		arrOfStr = arrayOfNumbers.split(",", 999);
		result = new int[arrOfStr.length];
		for (int i = 0; i < arrOfStr.length; i++) {
			result[i] = Integer.parseInt(arrOfStr[i]);
		}
		return result;
	}

	public static int stringToInt(String number) {
		try {
			return Integer.parseInt(number);
		} catch (InputMismatchException e) {
			System.out.println("Enter a real number: " + number);
		}
		return 0;
	}
}
