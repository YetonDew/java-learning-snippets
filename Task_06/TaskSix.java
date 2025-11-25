import java.util.Arrays;

public class TaskSix {
	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3, 4, 5, 6 },
				{ 2, 3, 4, 5, 6, 7 },
				{ 3, 4, 5, 6, 7, 8 },
				{ 4, 5, 6, 7, 8, 9 } };
		System.out.println("**** inner");
		for (int[] r : a)
			System.out.println(Arrays.toString(r));
		System.out.println();
		for (int[] r : inner(a))
			System.out.println(Arrays.toString(r));
		System.out.println("\n**** trans");
		for (int[] r : a)
			System.out.println(Arrays.toString(r));
		System.out.println();
		for (int[] r : trans(a))
			System.out.println(Arrays.toString(r));
		System.out.println("\n**** right");
		for (int[] r : a)
			System.out.println(Arrays.toString(r));
		System.out.println();
		for (int[] r : right(a))
			System.out.println(Arrays.toString(r));
	}

	static int[][] inner(int[][] arr) {
		int[][] result = new int[arr.length - 2][arr[0].length - 2];
		int i, j;
		i = 0;
		while (i < arr.length) {
			j = 0;
			while (j < arr[i].length) {
				if (i == 0 || i == arr.length - 1 || j == 0 || j == arr[0].length - 1) {
					j++;
					continue;
				} else {
					result[i - 1][j - 1] = arr[i][j];
					j++;
				}
			}
			i++;
		}
		return (result);
	}

	static int[][] trans(int[][] arr) {
		int[][] result = new int[arr[0].length][arr.length];
		int i, j;
		j = 0;
		while (j < arr[0].length) {
			i = 0;
			while (i < arr.length) {
				result[j][i] = arr[i][j];
				i++;
			}
			j++;
		}
		return (result);
	}

	static int[][] right(int[][] arr) {
		int len = arr[0].length / 2;
		int[][] result = new int[arr.length][len];
		int start, i, j;
		i = 0;
		while (i < arr.length) {
			j = 0;
			start = len;
			while (j < arr[0].length / 2) {
				result[i][j] = arr[i][start];
				start++;
				j++;
			}
			i++;
		}
		return (result);
	}
}
