package serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Main {
	public static void main(String[] args) throws Exception {
		/*
		 * FileOutputStream fos = new FileOutputStream("test-ser.bin");
		 * ObjectOutputStream oos = new ObjectOutputStream(fos);
		 * 
		 * Dog d = new Dog(); d.setName("Bobik");
		 * 
		 * Person a = new Person(); a.setAge(10); a.setName("Person Name A");
		 * a.setFriend(d);
		 * 
		 * oos.writeLong(1000L); oos.writeObject(a);
		 * oos.writeObject("Hello, serialization");
		 * 
		 * oos.flush(); oos.close();
		 */

		FileInputStream fis = new FileInputStream("test-ser.bin");
		ObjectInputStream ois = new ObjectInputStream(fis);

		long l = ois.readLong();
		Person cloneOfA = (Person) ois.readObject();
		String s = (String) ois.readObject();

		System.out.println(cloneOfA.getName() + " " + cloneOfA.getFriend().getName());

		System.out.println("Done");
	}
}
