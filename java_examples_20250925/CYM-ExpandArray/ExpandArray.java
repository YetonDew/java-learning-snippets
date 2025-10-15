import java.util.Arrays;

public class ExpandArray {
    public static void main(String[] args) {

          // 'Expanding' an array by inserting
          // a value at a given index
        int[] a = {4, 5, -2, 4, 1, 6, 7};
        int ind = 3;
        int value = 9;
        System.out.println("'Expanding' an array by inserting " +
                            value + " at index " + ind);
        System.out.println(Arrays.toString(a));
        int[] b = new int[a.length+1];  // longer array
        for (int i = 0; i < ind; ++i)
            b[i] = a[i];
        for (int i = ind+1; i < b.length; ++i)
            b[i] = a[i-1];
        b[ind] = value;
        System.out.println(Arrays.toString(b));
    }
}
