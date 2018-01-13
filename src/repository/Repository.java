package repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DataBase;
import domain.Book;
import domain.RegistredUser;

public class Repository {
	private DataBase dataBase;
	private RegistredUser loggedUser;
	private List<RegistredUser> searchedUsers;
	private ArrayList<Book> searchedBooks;

	public Repository(DataBase database){
		 this.dataBase = database;
		 loggedUser = null;
		 searchedUsers = new ArrayList<>();
	}
	
	public RegistredUser getLoggedUser() {
		return loggedUser;
	}

	public DataBase getDataBase() {
		return dataBase;
	}

	public void setDataBase(DataBase dataBase) {
		this.dataBase = dataBase;
	}
	
	public void setLoggedUser(RegistredUser loggedUser) {
		this.loggedUser = loggedUser;
	}

	public boolean login(String username, String password) throws SQLException {
		RegistredUser user;
		try {
			user = dataBase.readRegistredUser(username);
		} catch (SQLException e) {
			throw e;
		}
		if(user == null) {
			return false;
		}else{
			if(user.getPassword().equals(password)) {
				logged(user);
				return true;
			}else{
				return false;
			}
		}
	}
	
	public void logout() {
		loggedUser = null;
	}
	
	
	public void logged(RegistredUser user) {
		loggedUser = user;
	}
	
	public boolean registerUser(String email, String password, String name, String address) throws SQLException {
		RegistredUser user = new RegistredUser(email, password, name, address);
		try {
			if(dataBase.createRegistredUser(user)) {
				return true;
			}else{
				return false;
			}	
		} catch(SQLException e) {
			throw e;
		}
	}
	
	
	public boolean createOwnBook(Book book) {
		if(dataBase.createOwnBook(book, this.loggedUser.getEmail())) {
			return true;
		}else{
			return false;
		}
	}
	
	public ArrayList<Book> getBookList() {
		return dataBase.readBookList();
	}	
	public ArrayList<Book> getOwnBookList() {
		return dataBase.readOwnBookList(this.loggedUser.getEmail());
	}
	
	public boolean updateOwnBook(Book oldBook, Book newBook) {
		return dataBase.updateOwnBook(oldBook, newBook, this.loggedUser.getEmail());
	}
	
	public boolean createWantBook(Book book) {
		if(dataBase.createWantBook(book, this.loggedUser.getEmail())) {
			return true;
		}else{
			return false;
		}
	}
	
	public ArrayList<Book> getWantBookList() {
		return dataBase.readWantBookList(this.loggedUser.getEmail());
	}

	public boolean researchUsers(String name) {
		this.searchedUsers = dataBase.searchUsers(name);
		if(this.searchedUsers != null) {
			searchedUsers.get(0).setOwnBooks(dataBase.readOwnBookList(searchedUsers.get(0).getEmail()));
			return true;
		}else{
			return false;
		}
	}
	
	public void researchBooks(String title, String autor, String genre, String isbn) {
		if(!title.trim().equals("")) {
			if(!autor.trim().equals("")) {
				if(!genre.trim().equals("")) {
					if(!isbn.trim().equals("")) {
						this.searchedBooks = dataBase.readBooks(title, autor, genre, isbn);
					}else{
						this.searchedBooks = dataBase.readBooks(title, autor, genre);
					}
				}else {
					if(!isbn.trim().equals("")) {
						this.searchedBooks = dataBase.readBooksByTitleAutorIsbn(title, autor, isbn);
					}else{
						this.searchedBooks = dataBase.readBooks(title, autor);
					}
				}
			}else{
				if(!genre.trim().equals("")) {
					if(!isbn.trim().equals("")) {
						this.searchedBooks = dataBase.readBooksByTitleGenreIsbn(title, genre, isbn);
					}else{
						this.searchedBooks = dataBase.readBooksByTitleGenre(title, genre);
					}
				}else {
					if(!isbn.trim().equals("")) {
						this.searchedBooks = dataBase.readBooksByTitleIsbn(title, isbn);
					}else {
						this.searchedBooks = dataBase.readBooks(title);
					}
				}
			}
		}else {
			if(!autor.trim().equals("")) {
				if(!genre.trim().equals("")) {
					if(!isbn.trim().equals("")) {
						this.searchedBooks = dataBase.readBooksByAutorGenreIsbn(autor, genre, isbn);
					}else{
						this.searchedBooks = dataBase.readBooksByAutorGenre(autor, genre);
					}
				}else{
					if(!isbn.trim().equals("")) {
						this.searchedBooks = dataBase.readBooksByAutorIsbn(autor, isbn);
					}else {
						this.searchedBooks = dataBase.readBooksByAutor(autor);
					}
				}
			}else{
				if(!genre.trim().equals("")) {
					if(!isbn.trim().equals("")) {
						this.searchedBooks = dataBase.readBooksByGenreIsbn(genre, isbn);
					}else {
						this.searchedBooks = dataBase.readBooksByGenre(genre);
					}
				}else {
					if(!isbn.trim().equals("")) {
						this.searchedBooks = dataBase.readBooksByIsbn(isbn);
					}else {
						this.searchedBooks = dataBase.readBooks();
					}
				}
			}
		}
	}

	public List<RegistredUser> getSearchedUsers() {
		return searchedUsers;
	}
	
	public ArrayList<Book> getSearchedBooks() {
		return searchedBooks;
	}

	public void setSearchedUsers(List<RegistredUser> searchedUsers) {
		this.searchedUsers = searchedUsers;
	}
}
