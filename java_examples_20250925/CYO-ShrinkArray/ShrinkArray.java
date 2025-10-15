import java.util.Arrays;

public class ShrinkArray {
    public static void main(String[] args) {

          // 'Removing' the element with a given
          // index and 'shrinking' the array
        int[] a = {1, 2, 4, 7, 4, 2, 8};
        int ind = 3;
        System.out.println("'Removing' element with index " +
                ind + " and 'shrinking' the array");
        System.out.println(Arrays.toString(a));
        int[] b = new int[a.length-1];
        for (int i = 0; i < ind; ++i)
            b[i] = a[i];
        for (int i = ind; i < b.length; ++i)
            b[i] = a[i+1];
        System.out.println(Arrays.toString(b));
    }
}
