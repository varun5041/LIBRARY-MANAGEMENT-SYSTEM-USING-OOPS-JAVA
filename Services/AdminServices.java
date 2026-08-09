package Services;

import Models.Admin;

public interface AdminServices {

    public void showBooks();
    public void addbook(int bookidnum,String booktitle,String bookAuthor);
    public void removebook(int rempoveID);
    public void AddMember(int Id,String name);
    public void removemember(int Id);
    public void showmembers();
    public void getBorrowedBooks();
    public void giveBookToMember(int memberId, int bookId);

}
