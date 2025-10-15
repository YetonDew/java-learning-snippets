import java.util.Scanner;

public class SimpleSwitch {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter an initial: ");
        char initial = scan.next().charAt(0);

        switch (initial) {
            case 'A':
            case 'a':
                System.out.println("Amelia");
                break;
            case 'B':
            case 'b':
                System.out.println("Barbra");
                break;
            case 'C':
            case 'c':
                System.out.println("Cindy");
                break;
            case 'D':
            case 'd':
                System.out.println("Doris");
                break;
            default:
                System.out.println("Invalid input");
        }
    }
}
