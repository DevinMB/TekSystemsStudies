package functionalinterface;

public class CalcImplementation implements CalcInteface<Integer> {

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

}
