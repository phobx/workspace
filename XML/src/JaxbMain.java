import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

import javax.xml.bind.JAXB;


public class JaxbMain {
	public static void main(String[] args) throws Exception {
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

		JAXB.marshal(p, new FileOutputStream("jaxb.xml"));
		System.out.println("Done");
		
		//Person p1 = JAXB.unmarshal(new FileInputStream("jaxb.xml"), Person.class);

		Family f = new Family();
		f.setClanName("MyClan");
		f.getFamilyMembers().add(p);
		f.getFamilyMembers().add(p1);

		JAXB.marshal(f, new FileOutputStream("family.xml"));

		Family anotherFamily = JAXB.unmarshal(new FileInputStream("family.xml"), Family.class);
		
		for (Object o : anotherFamily.getFamilyMembers()){
			System.out.println("- " + o);
		}
		
	}
}
