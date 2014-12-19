package data;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class MetaDataMain {
	public static void main(String[] args) throws Exception {
		Class<? extends Person> cl = Person.class;
		
		Person p = new Person(1);
		p.setName("John Smith");
		p.setAge(12);
		cl = p.getClass();
		
		System.out.println(cl.getName());
		System.out.println(cl.getSimpleName());
		
		Field [] fs = cl.getDeclaredFields();
		for (Field f : fs){
			System.out.println(f.getName() + " " + f.getType());
		}
		
		Field name = cl.getDeclaredField("name");
		name.setAccessible(true);
		System.out.println(name.get(p));
		
		Integer a = 5;
		Field f = Integer.class.getDeclaredField("value");
		f.setAccessible(true);
		f.set(a, new Integer(777));

		Integer aa = 5;
		System.out.println((a == aa) + " " + aa + " " + a);
		
		Constructor<?> c = cl.getDeclaredConstructor(Integer.TYPE);
		Person p1 = (Person)c.newInstance(5);
		
	}
}
