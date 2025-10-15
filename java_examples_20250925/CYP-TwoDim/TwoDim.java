import java.util.Arrays;

public class TwoDim {
    public static void main(String[] args) {

          // 'Splitting' an array into two arrays
          // and/or one two-dimensional  array
        System.out.println("'Splitting' an array into two");
        int[] a = {4, 5, -2, 0, 4, -1, 6, 0, -7, 9};
        int numNeg = 0;
        int numPos = 0;
        for (int i = 0; i < a.length; ++i)
            if      (a[i] < 0) ++numNeg;
            else if (a[i] > 0) ++numPos;
        int[] aneg = new int[numNeg];
        int[] apos = new int[numPos];

        for (int i = 0, ineg = 0, ipos = 0; i < a.length; ++i)
            if      (a[i] < 0) aneg[ineg++] = a[i];
            else if (a[i] > 0) apos[ipos++] = a[i];
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(aneg));
        System.out.println(Arrays.toString(apos));

          // Array of arrays (two-dimensional array)
        int[][] aa = {aneg, apos};
            // or int[][] aa = new int[][]{aneg, apos};
            // or int[][] aa = new int[2][];
            //     aa[0] = aneg;
            //     aa[1] = apos;
        System.out.println("\nBefore swapping");
        System.out.println(Arrays.toString(aa[0]));
        System.out.println(Arrays.toString(aa[1]));

          // Swapping rows
        int[] tmp = aa[0];
        aa[0] = aa[1];
        aa[1] = tmp;
        System.out.println("\nAfter swapping");
        System.out.println(Arrays.toString(aa[0]));
        System.out.println(Arrays.toString(aa[1]));
    }
}
