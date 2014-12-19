import java.util.ArrayList;
import java.util.List;

public class Family {
	
	private String clanName = "Simpsons";
	private List<Person> familyMembers = new ArrayList<>();

	public String getClanName() {
		return clanName;
	}

	public void setClanName(String clanName) {
		this.clanName = clanName;
	}

	public List<Person> getFamilyMembers() {
		return familyMembers;
	}

	public void setFamilyMembers(List<Person> familyMembers) {
		this.familyMembers = familyMembers;
	}
}
