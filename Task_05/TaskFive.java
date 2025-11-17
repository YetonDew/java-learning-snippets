// Writeafunctionacceptingtwoarraysints, a and b, assumingthatelementsofthefirst
// are in non-descending order, while those of the second in non-ascending order, and
// returning an array c containing all elements from both input arrays in non-descending
// order.

public class TaskFive {
	private static int[] merge(int[] a, int[] b) {
		int len = a.length + b.length;
		int i = 0;
		int j = 0;
		int pass = 0;
		int[] result = new int[len];

		while (i < a.length) {
			result[i] = a[i++];
		}
		while (j < b.length) {
			result[i++] = b[j++];
		}
		while (pass < len) {
			int index = 0;

			while (index < len - 1) {
				if (result[index] > result[index + 1]) {
					int temp = result[index];
					result[index] = result[index + 1];
					result[index + 1] = temp;
				}
				index++;
			}
			pass++;
		}

		return result;
	}

	public static void main(String[] args) {
		int[] a = { 3, 9, 14, 14, 19 };
		int[] b = { 15, 2, 2, 0, -1 };
		int[] c = merge(a, b);
		int i = 0;
		while (i < c.length) {
			System.out.print(c[i++] + " ");
		}
		System.out.println();
	}
}
