package Services;

import Models.Admin;

import java.sql.SQLException;

public interface AdminServices {

    public void showBooks() throws SQLException;
    public void addbook(int bookidnum,String booktitle,String bookAuthor) throws SQLException;
    public void removebook(int rempoveID) throws SQLException;
    public void AddMember(int Id,String name) throws SQLException;
    public void removemember(int Id) throws SQLException;
    public void showmembers() throws SQLException;
    public void getBorrowedBooks() throws SQLException;
    public void giveBookToMember(int memberId, int bookId) throws SQLException;
    public void returnBook(int returnMemberId, int returnBookId) throws SQLException;
}
