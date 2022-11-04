package functionalinterface;

public class FunctionalMain {

	public static void main(String[] args) {
		FunctionalMain fm = new FunctionalMain();
		fm.ci();
		fm.anonInt();
		fm.anonDouble();
	}
	
	public void ci() {
		CalcImplementation ci = new CalcImplementation();
		System.out.println("5 + 3 = " + ci.sum(5,3));
	}
	
	public void anonInt() {
		CalcInteface<Integer> ci = new CalcInteface<Integer>() {

			@Override
			public Integer sum(Integer a, Integer b) {
				// TODO Auto-generated method stub
				return a + b;
			}

			@Override
			public Integer multiply(Integer a, Integer b) {
				// TODO Auto-generated method stub
				return a * b;
			}
		};
		
		System.out.println("5 + 3 = " + ci.sum(5,3));		
	}
	
	public void anonDouble() {
		CalcInteface<Double> ci = new CalcInteface<Double>() {

			@Override
			public Double sum(Double a, Double b) {
				// TODO Auto-generated method stub
				return a + b;
			}

			@Override
			public Double multiply(Double a, Double b) {
				// TODO Auto-generated method stub
				return a * b;
			}
		};
		
		System.out.println("5 + 3 = " + ci.sum(5.0,3.0));		
	}

	
//	@Override
//	public int multiply(int a, int b) {
//		System.out.println("override of interface default");
//		return a * b;
//	}

}
