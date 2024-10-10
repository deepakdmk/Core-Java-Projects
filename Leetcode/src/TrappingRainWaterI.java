//https://leetcode.com/problems/trapping-rain-water/?envType=study-plan-v2&envId=top-interview-150

public class TrappingRainWaterI {

	public int trap(int[] height) {
		if (height.length - 1 != 0) {
			int[] arrayLeftToRight = getMaxArrayList(height);
			int[] arrayRightToLeft = inverseArray(height);
			int[] comparison = getLowestArraySize(arrayLeftToRight, arrayRightToLeft);

			return getTrappedWaterArray(height, comparison);
		} else {
			return 0;
		}
	}

	private int getTrappedWaterArray(int[] original, int[] full) {
		int answer = 0;
		if (full.length == original.length) {
			for (int i = 0; i < full.length; i++) {
				int trappedWater = Math.abs(original[i] - full[i]);
				answer = answer + trappedWater;
			}
		}

		return answer;

	}

	private int[] getLowestArraySize(int[] x, int[] y) {
		int[] prevailingArray = new int[x.length];
		if (x.length == y.length) {
			for (int i = 0; i < x.length; i++) {
				if (x[i] <= y[i]) {
					prevailingArray[i] = x[i];
				} else {
					prevailingArray[i] = y[i];
				}
			}
		}
		return prevailingArray;
	}

	public int[] getMaxArrayList(int[] input) {
		int[] iterator = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			int current = input[i];
			if ((i == 0)) {
				iterator[i] = current;
			} else {
				if (current <= iterator[i - 1]) {
					iterator[i] = iterator[i - 1];
				} else {
					iterator[i] = current;
				}
			}
		}
		return iterator;
	}

	public int[] inverseArray(int[] input) {
		int[] iterator = new int[input.length];
		for (int i = input.length - 1; i >= 0; i--) {
			if (i == (input.length - 1)) {
				iterator[i] = input[i];
			} else if (input[i] <= iterator[i + 1]) {
				iterator[i] = iterator[i + 1];
			} else {
				iterator[i] = input[i];
			}
		}
		return iterator;
	}

}
