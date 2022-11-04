package functionalinterface;


public interface CalcInteface<T> {

	T sum(T a, T b);
	
	T multiply(T a, T b);

//	default int multiply(T a, T b) {
//		System.out.println("Default in interface");
//		return a * b;
//	}

}
