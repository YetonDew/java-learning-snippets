// Write a program which reads from the user three non-negative integers and then
// prints, using symbols ’*’, a ‘histogram’ of the data represented by the numbers, i.e.,
// three vertical bars, aligned at the bottom, with heights equal to the values of the
// three numbers.
// For example, for numbers 3, 1 and 8 the result should look like this:
// Do not use arrays, strings or any other kind of collections.

import java.util.Scanner;

public class TaskThree {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter 3 integers: ");
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		scan.close();
		int currentLine = a > b ? (a > c ? a : c) : (b > c ? b : c);
		System.out.println(a + " " + b + " " + c);
		System.out.print("-----\n");
		while (currentLine > 0) {
			if (a == currentLine) {
				System.out.print("* ");
				a--;
			} else {
				System.out.print("  ");
			}
			if (b == currentLine) {
				System.out.print("* ");
				b--;
			} else {
				System.out.print("  ");
			}
			if (c == currentLine) {
				System.out.print("* ");
				c--;
			} else {
				System.out.print("  ");
			}
			System.out.print("\n");
			currentLine--;
		}
	}
}
