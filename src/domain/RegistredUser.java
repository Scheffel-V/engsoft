package domain;

import java.util.ArrayList;

public class RegistredUser extends User {
	
	private String name;
	private String address;
	private ArrayList<Book> ownBooks;
	private ArrayList<Book> wantBooks;
	
	public RegistredUser(String email, String password, String name, String address) {
		super(email, password);
		this.name = name;
		this.address = address;
		this.ownBooks = new ArrayList<Book>();
		this.wantBooks = new ArrayList<Book>();
	}
	
	public RegistredUser(String email, String password, String name, String address, ArrayList<Book> ownBooks, ArrayList<Book> wantBooks) {
		super(email, password);
		this.address = address;
		this.ownBooks = ownBooks;
		this.wantBooks = wantBooks;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
		
	public String getAddress() {
		return this.address;
	}
	
	public void setAddress(String number) {
		this.address = number;
	}

	public ArrayList<Book> getOwnBooks() {
		return ownBooks;
	}

	public void setOwnBooks(ArrayList<Book> ownBooks) {
		this.ownBooks = ownBooks;
	}

	public ArrayList<Book> getWantBooks() {
		return wantBooks;
	}

	public void setWantBooks(ArrayList<Book> wantBooks) {
		this.wantBooks = wantBooks;
	}
	@Override
	public String toString() {
		return "\nEndereço :"+ this.address + " Email:  " + this.getEmail() + " Nome: " + this.name;
	}
}
