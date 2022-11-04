package functionalinterface;

import java.util.ArrayList;
import java.util.List;

public class HumanMain {

	public static void main(String[] args) {
		Human HMsg = (eat) -> System.out.println("Hello. It’s me again, James and I eat " + eat);
		HMsg.eat("food");

		Human h = new Human() {
			@Override
			public void eat(String food) {
				System.out.println("Hello. It’s me again, James and I eat " + food);

			}
		};
		h.eat("food");

		MultipleParameterDemo mpd = (p1, p2, p3) -> {
			String c = p1 + " " + p2 + " " + p3;
			System.out.println(c);
			return (c);
		};
		mpd.concatString("A", "B", "C");

		
		List<String> names = new ArrayList<String>();
		names.add("Larry");
		names.add("Steve");
		names.add("James");
		names.add("Conan");
		names.add("Ellen");
		
		names.forEach(name -> {System.out.println(name);});
		
		for ( String name : names ) {
			System.out.println(name);
		}
	}

	@FunctionalInterface
	public interface MultipleParameterDemo {
		/* A Single-Abstract-Method */
		String concatString(String a, String b, String c);
	}

}
