package serialization;

import java.io.Serializable;

public class Person implements Serializable {

	private int age;
	private String name;
	private Dog friend;
	// private double income;
	private String address;
	private String income;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Dog getFriend() {
		return friend;
	}

	public void setFriend(Dog friend) {
		this.friend = friend;
	}

	/*
	 * public double getIncome() { return income; }
	 * 
	 * public void setIncome(double income) { this.income = income; }
	 */
}
