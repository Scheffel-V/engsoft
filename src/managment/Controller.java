package managment;

import java.sql.SQLException;
import java.util.ArrayList;

import domain.Book;
import domain.RegistredUser;
import repository.Repository;
import userInterface.LoginUI;
import userInterface.MainUI;
import userInterface.RegistrationUI;
import userInterface.SearchBookUI;
import userInterface.SearchUserUI;
import userInterface.UserProfileUI;
import userInterface.AddUserBookUI;
import userInterface.ListBooksUI;
import userInterface.ListUsersUI;

public class Controller {
	private Repository repository;
	
	public Controller(Repository repository) {
		openLogin();
		this.repository = repository;
	}
	
	public void openRegistration() {
		RegistrationUI registrationUI = new RegistrationUI(this);
		registrationUI.openUI();
	}
	
	public void openLogin() {
		LoginUI loginUI = new LoginUI(this);
		loginUI.openUI();
	}
	
	public void openMain() {
		MainUI mainUI = new MainUI(this);
		mainUI.openUI();
	}
	
	public void openAddOwnBookToUser() {
		AddUserBookUI userBooksUI = new AddUserBookUI(this, 1);
		userBooksUI.openUI();
	}
	
	public void openAddWantBookToUser() {
		AddUserBookUI userBooksUI = new AddUserBookUI(this, 2);
		userBooksUI.openUI();
	}
	
	public void openSearchUser() {
		SearchUserUI researchUserUI = new SearchUserUI(this);
		researchUserUI.openUI();
	}
	
	public void openSearchBook() {
		SearchBookUI searchBookUI = new SearchBookUI(this);
		searchBookUI.openUI();
	}
	
	public void research(String type) {
		if (type == "user") {
			openSearchUser();
		}
		else if (type == "book") {
			//to do: openResearchBook();
		}		
	}
	
	public void researchBooks(String title, String autor, String genre, String isbn) {
		this.repository.researchBooks(title, autor, genre, isbn);
	}
	
	public void openListUsers() {
		ListUsersUI listUsersUI = new ListUsersUI(this,this.repository.getSearchedUsers() );
		listUsersUI.openUI(this.repository.getSearchedUsers());
	}
	
	public void openListBooks() {
		ListBooksUI listBooksUI = new ListBooksUI(this, this.repository.getSearchedBooks());
		listBooksUI.openUI();
	}
	
	public void openUserProfile(RegistredUser user) {
		UserProfileUI userProfileUI = new UserProfileUI(this, user);
		userProfileUI.openUI();		
	}
	
	public boolean registerUser(String email, String password, String name, String address) throws SQLException {
		try {
			return this.repository.registerUser(email, password, name, address);
		} catch(SQLException e) {
			throw e;
		}
	}
	
	public boolean createOwnBook(String title, String author, String genre, String edition, String language, String ISBN, String photo, String comment) {
		Book book = new Book(title, author, genre, edition, language, ISBN, photo, comment);
		return this.repository.createOwnBook(book);
	}
	
	public ArrayList<Book> getBookList() {
		return this.repository.getBookList();
	}
	
	public ArrayList<Book> getOwnBookList() {
		return this.repository.getOwnBookList();
	}
	
	public boolean updateOwnBook(Book oldBook, Book newBook) {
		return this.repository.updateOwnBook(oldBook, newBook);
	}
	
	public boolean createWantBook(String title, String author, String genre, String edition, String language, String ISBN, String photo, String comment) {
		Book book = new Book(title, author, genre, edition, language, ISBN, photo, comment);
		return this.repository.createWantBook(book);
	}
	
	public ArrayList<Book> getWantBookList() {
		return this.repository.getWantBookList();
	}
	
	public boolean login(String username, String password) throws SQLException {
		try {
			return this.repository.login(username, password);
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public void logout() {
		this.repository.logout();
		openLogin();
	}
	
	public boolean researchUsers(String name) {
		return this.repository.researchUsers(name);
	}
}
