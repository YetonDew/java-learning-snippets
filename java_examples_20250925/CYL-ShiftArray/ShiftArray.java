import java.util.Arrays;

public class ShiftArray {
    public static void main(String[] args) {
           // 'Inserting' a value at a given index
        int[] a = {4, 5, -2, 4, 1, 6, 7};
        int ind = 3;
        int value = 9;
        System.out.println("'Inserting' a value " + value +
                           " at index " + ind);
        System.out.println(Arrays.toString(a));
        for (int i = a.length-1; i > ind; --i) // must be backward
            a[i] = a[i-1];
        a[ind] = value;
        System.out.println(Arrays.toString(a));
    }
}
