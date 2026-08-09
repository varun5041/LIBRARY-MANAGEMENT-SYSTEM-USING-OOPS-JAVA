package Repositories;
import Database.databaseConnection;
import Models.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {


    public void addBook(Book book) throws SQLException {
        String sql = "INSERT INTO books (id, title, author) VALUES (?, ?, ?)";

        Connection connection = databaseConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, book.getBookId());
        statement.setString(2, book.getTitle());
        statement.setString(3, book.getAuthor());

        statement.executeUpdate();
    }

    public List<Book> getAllBooks() throws SQLException{
        String sql= "select * from books;";

        Connection connection = databaseConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rs = statement.executeQuery();

        List<Book> books = new ArrayList<>();

        while (rs.next()) {
            Book book = new Book(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("author")
            );

            books.add(book);
        }

        return books;
    }

    public void DeleteBook(int id) throws SQLException {
        String sql = "delete from books where id= ?;";

        Connection connection= databaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1,id);
        statement.executeUpdate();
    }

    public Book getBookbyId(int id) throws SQLException {
        String sql = "Select * from books where id= ?;";

        Connection connection= databaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1,id);
        ResultSet rs =statement.executeQuery();
        while(rs.next()){
            return new Book(rs.getInt("id"),rs.getString("title"),rs.getString("author"));
        }
        return null;
    }


}
