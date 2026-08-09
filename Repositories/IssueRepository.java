package Repositories;

import Database.databaseConnection;
import Models.Book;
import Models.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IssueRepository {
    BookRepository bookRepository= new BookRepository();
    MemberRepository memberRepository = new MemberRepository();
    public void issueBook(int memberId, int bookId) throws SQLException {
        //get book Object first
        Member member = memberRepository.getMemberById(memberId);
        Book book = bookRepository.getBookbyId(bookId);
        String sql = "INSERT INTO borrowed_books(member_id, book_id,member_name,book_title,book_author) VALUES(?,?,?,?,?);";

        Connection connection = databaseConnection.getConnection();

        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setInt(1,member.getMemberId());
        statement.setInt(2,book.getBookId());
        statement.setString(3,member.getMembername());
        statement.setString(4,book.getTitle());
        statement.setString(5,book.getAuthor());
        statement.executeUpdate();
        bookRepository.DeleteBook(bookId);
    }

    public void getBorrowedBooks() throws SQLException {

        String sql = "SELECT * FROM borrowed_books";

        Connection connection = databaseConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rs = statement.executeQuery();

        while (rs.next()) {

            System.out.println(
                    "Member ID: " + rs.getInt("member_id") +
                            ", Member Name: " + rs.getString("member_name") +
                            ", Book ID: " + rs.getInt("book_id") +
                            ", Book Title: " + rs.getString("book_title") +
                            ", Book Author: " + rs.getString("book_author")
            );
        }
    }

    public void returnBook(int memberId, int bookId) throws SQLException {

        String sql = "SELECT book_id, book_title, book_author " +
                "FROM borrowed_books " +
                "WHERE member_id = ? AND book_id = ?";

        Connection connection = databaseConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, memberId);
        statement.setInt(2, bookId);

        ResultSet rs = statement.executeQuery();

        if (!rs.next()) {
            System.out.println("This book is not borrowed by this member!");
            return;
        }

        int returnedBookId = rs.getInt("book_id");
        String title = rs.getString("book_title");
        String author = rs.getString("book_author");

        // Add book back to books table
        bookRepository.addBook(
                new Book(returnedBookId, title, author)
        );

        // Remove from borrowed_books
        String deleteSql =
                "DELETE FROM borrowed_books " +
                        "WHERE member_id = ? AND book_id = ?";

        PreparedStatement deleteStatement =
                connection.prepareStatement(deleteSql);

        deleteStatement.setInt(1, memberId);
        deleteStatement.setInt(2, bookId);

        deleteStatement.executeUpdate();

        System.out.println("Book returned successfully!");
    }
}
