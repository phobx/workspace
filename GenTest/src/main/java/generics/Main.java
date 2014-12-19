package generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Human> l = new ArrayList<>();
		List<Human> l3 = new ArrayList<>();
		l.add(new Person());
		
		List<Person> l2 = new ArrayList<>();
		//l2.add((Person) new Human());

		System.out.println(l.getClass() == l2.getClass());
		System.out.println(l2.getClass().getCanonicalName());
		System.out.println(l3.getClass().getCanonicalName());
		System.out.println(l instanceof ArrayList);
		System.out.println(l2 instanceof ArrayList);
		System.out.println(l3 instanceof ArrayList);
	}

}
