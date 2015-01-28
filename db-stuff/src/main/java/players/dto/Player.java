package players.dto;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Player {

	private static SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-YYYY");

	private int id;
	private String firstName;
	private String lastName;
	private int weight;
	private int height;
	private Calendar birthDate;

	public Calendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return id + " - " + firstName + " " + lastName + "; weight " + weight + "; height " + height + "; " + SDF.format(birthDate.getTime());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
