
public class sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] sort = { 10, 2, 99, 4, 3, 2, 1, 5, 7, 8 };
		
		for (int i = 0; i < sort.length; i++) {
			for (int j = i + 1; j < sort.length; j++) {
				int tmp = 0;
				if (sort[i] > sort[j]) {
					tmp = sort[i];
					sort[i] = sort[j];
					sort[j] = tmp;
				}
			}
			System.out.println(sort[i]);
		}
	}
}
