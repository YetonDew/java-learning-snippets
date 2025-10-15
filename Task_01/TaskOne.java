import java.util.Scanner;

public class TaskOne {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter 3 integers: ");
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		scan.close();
		System.out.println(a + " " + b + " " + c);
		int temp_min = a < b ? (a < c ? a : c) : (b < c ? b : c);
		int temp_max = a > b ? (a > c ? a : c) : (b > c ? b : c);
		int temp_mid = 0;
		if((a >= b && a <= c) || (a <= b && a >= c))
		{
			temp_mid = a;
		}
		else if ((b >= a && b <= c) || (b <= c && b >= a))
		{
			temp_mid = b;
		}
		else
		{
			temp_mid = c;
		}
		a = temp_min;
		b = temp_mid;
		c = temp_max;
		System.out.println(a + " " + b + " " + c);
	}
}
