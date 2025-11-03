// A date may be specified by three numbers denoting year, month and day of month.
// If we don’t need dates from a deep past, we can specify years relative to the year
// 2000 (e.g., year 2032 as 32). Assuming that we will not consider the future past the
// year 2127, we can use numbers from the interval [0, 127] for year; such numbers can
// be written on 7 bits. Month number can occupy 4 bits, as it belongs to the interval
// [0, 15], and for the day we can spend 5 bits (which is enough to store any number
// from the interval [0, 31]). Therefore, full date can be packed in 16 bits and we can
// store two such dates in one 32-bit int (e.g., beginning and end of a period).
// Write a program which defines two dates (from and to), each as three integers (year,
// month, day). Pack them into one integer. Then unpack the integer and recover these
// six numbers.

public class TaskFour {
	public static void main(String[] args) {
		int fromy = 2000, fromm = 2, fromd = 3;
		int toy = 2127, tom = 11, tod = 29;

		System.out.println("**** Original\n" +
				"From " + fromy + "/" +
				fromm + "/" + fromd + " to " +
				toy + "/" + tom + "/" + tod);

		int period = 0;
		period |= (tod & 0x1F);
		period |= ((tom & 0x0F) << 5);
		period |= (((toy - 2000) & 0x7F) << 9);
		period |= ((fromd & 0x1F) << 16);
		period |= ((fromm & 0x0F) << 21);
		period |= (((fromy - 2000) & 0x7F) << 25);

		fromy = fromm = fromd = toy = tom = tod = 0;

		tod = period & 0x1F;
		tom = (period >>> 5) & 0x0F;
		toy = ((period >>> 9) & 0x7F) + 2000;
		fromd = (period >>> 16) & 0x1F;
		fromm = (period >>> 21) & 0x0F;
		fromy = ((period >>> 25) & 0x7F) + 2000;

		System.out.println("**** Reconstructed\n" +
				"From " + fromy + "/" +
				fromm + "/" + fromd + " to " +
				toy + "/" + tom + "/" + tod);
	}
}
