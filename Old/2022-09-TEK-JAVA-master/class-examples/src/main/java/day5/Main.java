package day5;

public class Main {
	
	public static void main(String[] args) {
		FutureTuition ft = new FutureTuition();
		
		int x = 40000;
		int y = 60000;
		
		double costX = ft.futureTution(x, 10);
		double costY = ft.futureTution(y, 5);
		
		System.out.println(y + " costs " + (costY - costX) + " more than " + x + " over 11 years");

	}
	
	
	
}

