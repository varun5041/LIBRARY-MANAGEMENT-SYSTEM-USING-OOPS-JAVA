package Database;
import Models.Book;
import Repositories.BookRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class databaseConnection {
    private static final String URL =
            "jdbc:mysql://localhost:3306/library";

    private static final String USER =
            "root";

    private static final String PASSWORD =
            "Varun5041@";


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {

        try {
            Connection connection = getConnection();

            System.out.println("Database Connected Successfully!");
//            Book book = new Book(1234,"Naruto","VARUN SONI");
            BookRepository repository = new BookRepository();
//            repository.addBook(book);


//            List<Book> books = repository.getAllBooks();
//
//            for (Book book : books) {
//                System.out.println(book);
//            }

            repository.DeleteBook(1234);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
