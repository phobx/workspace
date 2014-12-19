import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "MyCoolPerson")
@XmlAccessorType(XmlAccessType.NONE)
public class Person {

	@XmlElement(name="first-name")
	private String firstName;
	@XmlAttribute(name="last-name")
	private String lastName;
	@XmlAttribute(name="birth-date")
	private Date birthDate;
	private double _salary;

	public String getFirstName() {
		return firstName;
	}

	@XmlTransient
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public double getSalary() {
		return _salary;
	}

	public void setSalary(double salary) {
		this._salary = salary;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName + " " + birthDate + " " + _salary;
	}
}
