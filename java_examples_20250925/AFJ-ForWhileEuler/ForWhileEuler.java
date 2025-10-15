import java.util.Scanner;
/*
 * Finding and printing values of Euler's totient
 * function, i.e., number of positive integers up
 * to a given integer n that are relatively prime to n.
 */

public class ForWhileEuler {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print(
                "\nEnter a natural number (0 to exit) -> ");
            int n = scan.nextInt();

            if (n == 0) break;

            int count = 0;
            for (int p = 1; p <= n; ++p) {
                int a = n, b = p;
                  // Euclid's algorithm for GCD
                while (a != b) {
                    if (a > b) a -= b;
                    else       b -= a;
                }
                if (a == 1) ++count;
            }
            System.out.print("\u03c6(" + n + ") = " + count);
        }
    }
}
