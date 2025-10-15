// Write a program reading integers until zero is entered and printing the length of the
// longest sequence of consecutive numbers of the same value (and this value).
// For example, for
// 2 2 2 2 3 3 3 2 6 6 6 0
// the result should be
// Longest sequence: 4 times 2

import java.util.Scanner;

public class TaskTwo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean anyNumber = false;
		int currentValue = 0;
		int currentSequenceLen = 0;
		int longestSequenceValue = 0;
		int longestSequence = 0;

		while (true) {
			System.out.println("Please enter a integer number. Type 0 to finish:");
			int number = scan.nextInt();
			if (number == 0)
				break;
			if (!anyNumber){
			anyNumber = true;
			currentValue = number;
			currentSequenceLen = 1;
			longestSequenceValue = number;
			longestSequence = 1;
			} else if (number == currentValue) {
				currentSequenceLen++;
				if (currentSequenceLen > longestSequence) {
					longestSequence = currentSequenceLen;
					longestSequenceValue = currentValue;
				}
			} else {
				currentValue = number;
				currentSequenceLen = 1;
			}
		}
		System.out.println("Longest sequence: " + longestSequence + " times " + longestSequenceValue);
		scan.close();
	}
}
