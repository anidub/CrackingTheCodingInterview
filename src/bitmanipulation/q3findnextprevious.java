package bitmanipulation;

public class q3findnextprevious {


	// set the first non-trailing zero
	public static int findNext(int num) {
	int digit = num & 1;
	int count = 0;
		while (digit == 0) {
			if (count == 31)
			return 0;
			digit = (num >> ++count) & 1;
		}
		int countSet = 0;
		while (digit == 1 && count < 31) {
			digit = (num >> ++count) & 1;
			++countSet;
		}
		num = ((num >> count) | 1) << count;
		num |= ~(~0 << (countSet - 1));
		return num;
	}

	// unset the first non-trailing one
	public static int findPrev(int num) {
		int digit = num & 1;
		int count = 0;
		int countSet = 0;
		while (digit == 1) {
			if (count == 31)
				return -1;
			digit = (num >> ++count) & 1;
			countSet++;
		}

		while (digit == 0 && count < 31) {
			digit = (num >> ++count) & 1;
		}
		num = num & (~0 << (count + 1));
		num |= ~((~0 << count) + ~(~0 << (count - countSet - 1)));
		return num;
	}

	public static void main(String[] args) {
		//System.out.println(Integer.toBinaryString(findNext(0xF1)));
		System.out.println(Integer.toBinaryString(findNext(11)));
		System.out.println(Integer.toBinaryString(findPrev(0xF1)));
	}
}