import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {

	public static void main(String[] args) {
		List<String> list = new LinkedList<>();
		list.add("1");
		list.add("5");
		ListIterator<String> iter = list.listIterator();

		iter.next();
		iter.remove();
		System.out.println(iter.nextIndex());
		iter.add("2");
		iter.add("3");
		iter.add("4");
		System.out.println(iter.nextIndex());

		ListIterator<String> iter2 = list.listIterator();

		for (int i = 0; i < list.size(); i++) {
			iter2.next();
			System.out.println(iter2.nextIndex());

		}
		
		iter2.next();

	}

}
