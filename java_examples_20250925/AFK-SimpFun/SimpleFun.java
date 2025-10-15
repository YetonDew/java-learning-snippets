import java.util.Locale;
import java.util.Scanner;

public class SimpleFun {
    static void justPrint(int n) {
        System.out.println("Printing n: " + n);
        n = n + 1;
        System.out.println(" n is now : " + n);
    }

    static void printArray(int[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println("]");
    }

    static void reverseArray(int[] arr) {
        for (int i = 0, j = arr.length-1; i < j; ++i,--j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    static int gcd(int a, int b) {
        while (a != b)
            if (a > b) a -= b;
            else       b -= a;
        return a;
    }

    static String info(String name, int year, String tel) {
        return name + "(b. " + year + "), tel: " + tel;
    }

    static void changeScannerLocale(Scanner s) {
        s.useLocale(Locale.JAPANESE);
    }

    public static void main(String[] args) {
        int var = 5;
        justPrint(var);
        System.out.println("After invoking 'justPrint' " +
                           "var is " + var);

        int[] a = {1,3,5,7,9};
        System.out.println("Array before 'reverseArray'");
        printArray(a);
        reverseArray(a);
        System.out.println("Array after  'reverseArray'");
        printArray(a);

        int result = gcd(5593,11067);
        System.out.println("Greatest common divisor of" +
                          " 5593 and 11067 is " + result);

        System.out.println(info("Mary",1996,"228630099"));

        Scanner scan = new Scanner(System.in);
        System.out.println(scan.locale());
        changeScannerLocale(scan);
        System.out.println(scan.locale());
    }
}
