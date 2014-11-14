package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		List<Object> l = new ArrayList<>();
		l.add("asdasd");
		l.add(1231);
		l.add(123.45);

		String secretName = "Seventeen";

		List<String> names = new ArrayList<>();
		names.add("One");
		names.add("Two");
		names.add("Three");
		names.add("Four");
		names.add(secretName);

		for (int i = 0; i < names.size(); i++) {
			String name = names.get(i);
			System.out.println(name);
		}
		System.out.println("---------------");

		List<String> moreNames = new LinkedList<>();
		moreNames.add("Seven");
		moreNames.add("Eleven");
		moreNames.add(secretName);

		names.addAll(moreNames);

		names.remove(names.size() - 1);
		for (String name : names) {
			System.out.println(name);
		}
		System.out.println("---------------");

		List<String> someNames = names.subList(2, names.size());
		for (String name : someNames) {
			System.out.println(name);
		}

		Set<String> s = new HashSet<>();

		s.add("100");
		s.add("1");
		s.add("10");
		s.add("6");
		s.add("7");

		for (String i : s) {
			System.out.println(i);
		}

		System.out.println("There's 6 in set: " + s.contains("6"));
		System.out.println("There's 666 in set: " + s.contains("666"));

		System.out.println("====================");

		Map<Integer, String> digitNames = new LinkedHashMap<>();
		digitNames.put(1, "One");
		digitNames.put(2, "Two");
		digitNames.put(0, "Zero");
		digitNames.put(3, "Three");

		for (Integer k : digitNames.keySet()) {
			System.out.println(k + " = " + digitNames.get(k));
		}

		// Set<String>
		Map<String, Boolean> emulatedSet = new HashMap<>();
		emulatedSet.put("John", true);
		System.out.println(emulatedSet.get("John") != null);
		System.out.println(emulatedSet.get("Peter") != null);
	}
}
