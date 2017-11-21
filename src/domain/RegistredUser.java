package domain;

import java.util.ArrayList;

public class RegistredUser extends User {
	
	private String name;
	private String email;
	private String number;
	private String password;
	private ArrayList<Card> cards;
	
	// Jogos de Interesse
	
	RegistredUser(String name, String email, String number, String password) {
		super();
		this.name = name;
		this.email = email;
		this.number = number;
		this.password = password;
	}
	
	String getName() {
		return this.name;
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	String getEmail() {
		return this.email;
	}
	
	void setEmail(String email) {
		this.email = email;
	}
	
	String getNumber() {
		return this.number;
	}
	
	void setNumber(String number) {
		this.number = number;
	}
	
	String getPassword() {
		return this.password;
	}
	
	void setPassword(String password) {
		this.password = password;
	}
	
}
