import java.util.Scanner;

public class Stars {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a positive odd number: ");
        int n = scan.nextInt();

        for (int len=1, sp=n/2; len <= n; len+=2, --sp) {
            for (int i = 0; i < sp; ++i)
                System.out.print(" ");
            for (int i = 0; i < len; ++i)
                System.out.print("*");
            System.out.println();
        }
    }
}
