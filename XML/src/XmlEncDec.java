import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;


public class XmlEncDec {

	public static void main(String[] args) throws Exception {
		/*
		Calendar cal = Calendar.getInstance(new Locale("uk", "UA"));
		
		int dof = cal.get(Calendar.DAY_OF_WEEK);
		int dom = cal.get(Calendar.DAY_OF_MONTH);
		
		System.out.println(cal.get(Calendar.DAY_OF_YEAR));
		
		System.out.println(dof + " " + dom);
		System.out.println(cal);
		
		cal.set(Calendar.ERA, GregorianCalendar.BC);
		cal.set(Calendar.YEAR, 54);
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		
		cal.add(Calendar.DAY_OF_YEAR, 400);
		System.out.println();
		*/
		
		Person p = new Person();
		p.setBirthDate(new Date());
		p.setFirstName("John");
		p.setLastName("Smith");
		p.setSalary(100.32);
		
		Person p1 = new Person();
		p1.setBirthDate(new Date());
		p1.setFirstName("Mike");
		p1.setLastName("Micheal");
		p1.setSalary(55.43);

		XMLEncoder xmlEnc = new XMLEncoder(new FileOutputStream("person.xml"), "UTF8", true, 0);	
		xmlEnc.writeObject(p);
		xmlEnc.flush();
		xmlEnc.close();
		
		System.out.println("Done");
		
		List<Person> persons = new ArrayList<>();
		persons.add(new Person());
		persons.add(new Person());
		persons.add(new Person());
		persons.add(p);

		XMLEncoder xmlEnc1 = new XMLEncoder(new FileOutputStream("persons.xml"), "UTF8", true, 0);	
		xmlEnc1.writeObject(persons);
		xmlEnc1.flush();
		xmlEnc1.close();
		
		XMLDecoder xmlDec = new XMLDecoder(new FileInputStream("persons.xml"));

		Family f = new Family();
		//f.getFamilyMembers().add(p1);
		//f.getFamilyMembers().add(p1);
		
		Object obj = xmlDec.readObject();
		System.out.println(obj);
		
		//obj instanceof List<?> 
		//obj.getClass().isInstance(List.class)
	}
	
	
}
