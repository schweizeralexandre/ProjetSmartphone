package Contacts;

public class PersonDetails {

	private String surname;
	private String name;
	private String email;
	private int homeNum;
	private int personalNum;
	private int companyNum;
	
	
	
	public PersonDetails(String surname, String name, String email, int homeNum, int personalNum, int companyNum) {
		super();
		this.surname = surname;
		this.name = name;
		this.email = email;
		this.homeNum = homeNum;
		this.personalNum = personalNum;
		this.companyNum = companyNum;
	}
	
	
	
	public String getSurname() {
		return surname;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public int getHomeNum() {
		return homeNum;
	}
	public int getPersonalNum() {
		return personalNum;
	}
	public int getCompanyNum() {
		return companyNum;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		email = email;
	}
	public void setHomeNum(int homeNum) {
		this.homeNum = homeNum;
	}
	public void setPersonalNum(int personalNum) {
		this.personalNum = personalNum;
	}
	public void setCompanyNum(int companyNum) {
		this.companyNum = companyNum;
	}
	
    
	
	
	
	
	
	
}
