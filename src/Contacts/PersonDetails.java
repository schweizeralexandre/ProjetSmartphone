package Contacts;

import java.io.Serializable;

public class PersonDetails implements Serializable {

	private String surname;
	private String name;
	private String email;
	private String num1;
	private String num2;
	private String image;
	
	
	
	public PersonDetails(String surname, String name, String email, String num1, String num2) {
	
		this.surname = surname;
		this.name = name;
		this.email = email;
		this.num1 = num1;
		this.num2 = num2;
		
		
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


	public String getNum1() {
		return num1;
	}


	public String getNum2() {
		return num2;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setNum1(String num1) {
		this.num1 = num1;
	}


	public void setNum2(String num2) {
		this.num2 = num2;
		
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}
	
	



	
	
	
	

	
	
	

    
	
	
	
	
	
	
}
