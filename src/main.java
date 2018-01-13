import database.DataBase;
import managment.Controller;
import repository.Repository;

public class main {

	public static void main(String[] args) {
	
		DataBase dataBase = new DataBase();
		Repository repository = new Repository(dataBase);
		Controller controller = new Controller(repository);
	}

}
