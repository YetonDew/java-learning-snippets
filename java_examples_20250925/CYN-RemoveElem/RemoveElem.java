import java.util.Arrays;

public class RemoveElem {
    public static void main(String[] args) {


          // 'Removing' the element with a given index
        int[] a = {1, 2, 4, 7, 4, 2, 8};
        int ind = 3;
        System.out.println("'Removing' element with index " + ind);
        System.out.println(Arrays.toString(a));
        for (int i = ind; i < a.length-1; ++i)
            a[i] = a[i+1];
        System.out.println(Arrays.toString(a));
    }
}
