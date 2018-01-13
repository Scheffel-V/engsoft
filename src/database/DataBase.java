package database;

import java.sql.SQLException;
import java.util.ArrayList;

import domain.Book;
import domain.RegistredUser;

public class DataBase {

	public boolean createRegistredUser(RegistredUser user) throws SQLException{
		RegistredUserDAO userDAO = new RegistredUserDAO();
		
		try {
			if(userDAO.create(user)){
				return true;
			}else{
				return false;
			}	
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public RegistredUser readRegistredUser(String username) throws SQLException{
		RegistredUserDAO userDAO = new RegistredUserDAO();
		try {
			return userDAO.read(username);
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public boolean updateRegistredUser(RegistredUser oldUser, RegistredUser newUser){
		RegistredUserDAO userDAO = new RegistredUserDAO();
		
		if(userDAO.update(oldUser, newUser)){
			return true;
		}else{
			return false;
		}
	}
	
	/*public boolean deleteRegistredUser(RegistredUser user){
		RegistredUserDAO userDAO = new RegistredUserDAO();
		
		if(userDAO.delete(user)){
			return true;
		}else{
			return false;
		}
	}*/
		
	public ArrayList<RegistredUser> searchUsers(String name) {
		RegistredUserDAO userDAO = new RegistredUserDAO();
		return userDAO.searchByName(name);
	}
	
	public boolean createOwnBook(Book book, String username) {
		BookDAO bookDAO = new BookDAO();
		if(bookDAO.createOwnBook(book, username)) {
			return true;
		}else{
			return false;
		}
	}
	
	public ArrayList<Book> readBookList() {
		BookDAO bookDAO = new BookDAO();
		return bookDAO.readAll();
	}
	
	public ArrayList<Book> readOwnBookList(String username) {
		BookDAO bookDAO = new BookDAO();
		return bookDAO.readOwnBooks(username);
	}
	
	public boolean updateOwnBook(Book oldBook, Book newBook, String username) {
		BookDAO bookDAO = new BookDAO();
		return bookDAO.updateOwnBook(oldBook, newBook, username);
	}
	
	public boolean createWantBook(Book book, String username) {
		BookDAO bookDAO = new BookDAO();
		if(bookDAO.createWantBook(book, username)) {
			return true;
		}else{
			return false;
		}
	}
	
	public ArrayList<Book> readWantBookList(String email) {
		BookDAO bookDAO = new BookDAO();
		return bookDAO.readWantBooks(email);
	}

	public ArrayList<Book> readBooks(String title, String autor, String genre, String isbn) {
		BookDAO bookDAO = new BookDAO();
		return bookDAO.readBooks(title, autor, genre, isbn);
	}
	
	public ArrayList<Book> readBooks(String title, String autor, String genre) {
		BookDAO bookDAO = new BookDAO();
		return bookDAO.readBooks(title, autor, genre);
	}
	
	public ArrayList<Book> readBooks(String title, String autor) {
		BookDAO bookDAO = new BookDAO();
		return bookDAO.readBooks(title, autor);
	}
	
	public ArrayList<Book> readBooks(String title) {
		BookDAO bookDAO = new BookDAO();
		return bookDAO.readBooks(title);
	}
	
	public ArrayList<Book> readBooks() {
		BookDAO bookDAO = new BookDAO();
		return bookDAO.readBooks();
	}

	public ArrayList<Book> readBooksByTitleAutorIsbn(String title, String autor, String isbn) {
		BookDAO bookDAO = new BookDAO();
		return bookDAO.readBooksByTitleAutorIsbn(title, autor, isbn);
	}

	public ArrayList<Book> readBooksByTitleGenreIsbn(String title, String genre, String isbn) {
		BookDAO bookDAO = new BookDAO();
		return bookDAO.readBooksByTitleGenreIsbn(title, genre, isbn);
	}

	public ArrayList<Book> readBooksByTitleGenre(String title, String genre) {
		BookDAO bookDAO = new BookDAO();
		return bookDAO.readBooksByTitleGenre(title, genre);
	}

	public ArrayList<Book> readBooksByTitleIsbn(String title, String isbn) {
		BookDAO bookDAO = new BookDAO();
		return bookDAO.readBooksByTitleIsbn(title, isbn);
	}

	public ArrayList<Book> readBooksByAutorGenreIsbn(String autor, String genre, String isbn) {
		BookDAO bookDAO = new BookDAO();
		return bookDAO.readBooksByAutorGenreIsbn(autor, genre, isbn);
	}

	public ArrayList<Book> readBooksByAutorGenre(String autor, String genre) {
		BookDAO bookDAO = new BookDAO();
		return bookDAO.readBooksByAutorGenre(autor, genre);
	}

	public ArrayList<Book> readBooksByAutorIsbn(String autor, String isbn) {
		BookDAO bookDAO = new BookDAO();
		return bookDAO.readBooksByAutorIsbn(autor, isbn);
	}

	public ArrayList<Book> readBooksByAutor(String autor) {
		BookDAO bookDAO = new BookDAO();
		return bookDAO.readBooksByAutor(autor);
	}

	public ArrayList<Book> readBooksByGenreIsbn(String genre, String isbn) {
		BookDAO bookDAO = new BookDAO();
		return bookDAO.readBooksByGenreIsbn(genre, isbn);
	}

	public ArrayList<Book> readBooksByGenre(String genre) {
		BookDAO bookDAO = new BookDAO();
		return bookDAO.readBooksByGenre(genre);
	}

	public ArrayList<Book> readBooksByIsbn(String isbn) {
		BookDAO bookDAO = new BookDAO();
		return bookDAO.readBooksByIsbn(isbn);
	}
	
	
}
