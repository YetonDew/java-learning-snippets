import java.util.Scanner;

public class Recursion {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
          // -- 1 --
        int[] a = {-4, 0, 3, 1, 8, 7, 2};
        int res = greatest(a, 0);
        System.out.println("Greatest = " + res + "\n");

          // -- 2 --
        System.out.println("GCD = " + gcd(2483, 2101) + '\n');

          // -- 3 --
        res = printAndSum();
        System.out.println("\nSum = " + res);
    }

    static int greatest(int[] a, int from) {
        if (from == a.length-1) return a[from];
        return Math.max(a[from], greatest(a, from + 1));
    }

    static int gcd(int a, int b) {
        return a == b ? a :
                        a > b ? gcd(a-b, b) :
                                gcd(a, b-a);
    }

    static int printAndSum() {
        System.out.print("Enter a number (zero to end) ");
        int n = scan.nextInt();
        if (n == 0) return 0;
        int s = printAndSum();
        System.out.print(n + " ");
        return n + s;
    }
}
