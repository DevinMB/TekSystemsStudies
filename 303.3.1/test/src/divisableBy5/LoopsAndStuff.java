package divisableBy5;

public class LoopsAndStuff {

	public static void main(String[] args) {
		// print all numbers divisible by 5 with no remainder between 1 - 100

		for (int i = 1; i <= 100; i++) {
			if (i % 5 == 0) {
				System.out.println(i + " is divisable by 5 with no remainder");
			}
		}
	}
}
