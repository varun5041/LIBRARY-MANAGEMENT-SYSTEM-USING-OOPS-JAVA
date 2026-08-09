package Services.Implimentations;

import Models.Admin;
import Models.Book;
import Models.Member;
import Services.AdminServices;

public class AdminServicesImpl implements AdminServices {
    Admin admin;


    public AdminServicesImpl(Admin admin) {
        this.admin = admin;
    }

    @Override
    public void showBooks() {
        if (admin.getBookslist().isEmpty()) {
            System.out.println("No bookslist available.");
        }
        else {
            for (Book i : admin.getBookslist()) {
                System.out.println("Book ID: " + i.getBookId() + ", Title: " + i.getTitle() + ", Author: " + i.getAuthor());
            }
        }
    }

    @Override
    public void addbook(int bookidnum,String booktitle,String bookAuthor) {
        admin.getBookslist().add(new Book(bookidnum,booktitle,bookAuthor));
    }

    @Override
    public void removebook(int rempoveID) {
        for (Book i : admin.getBookslist())
        {
            if (rempoveID == i.getBookId())
            {
                admin.getBookslist().remove(i);
                System.out.println("Book removed successfully!");
                return;
            }
        }


        System.out.println("BOOK NOT FOUND!");
    }

    @Override
    public void AddMember(int Id,String name)
    {
        admin.getMemberslist().add(new Member(Id,name));
    }

    @Override
    public void removemember(int Id) {
        int removememberid=Id;

        for (Member i : admin.getMemberslist()) {
            if (removememberid == i.getMemberId()) {
                admin.getMemberslist().remove(i);
                System.out.println("Member removed successfully!");
                return;
            }
        }
        System.out.println("Member not found!");
    }

    @Override
    public void showmembers() {
        if(admin.getMemberslist().isEmpty()) {
            System.out.println("THERE ARE NO MEMBERS IN THE LIBRARY!");
        }
        else{
            for(Member i : admin.getMemberslist())
            {
                System.out.println("memberid:" + i.getMemberId() + "MEMBER name"+ i.getMembername());
            }
        }
    }

    @Override
    public void getBorrowedBooks(){
        for (Member member : admin.getMemberslist()) {
            System.out.println("Member ID: " + member.getMemberId());
            System.out.println("Member Name: " + member.getMembername());

            for (Book book : member.getBorrowedbooks()) {
                System.out.println(
                        "Book ID: " + book.getBookId() +
                                ", Title: " + book.getTitle()
                );
            }

            System.out.println("----------------------");
        }
    }

    @Override
    public void giveBookToMember(int memberId, int bookId) throws NullPointerException {

        if (admin.getBookslist().isEmpty()) {
            System.out.println("No Books In Library to Give");
            return;
        }

        Book bookToGive = null;

        // Find book
        for (Book book : admin.getBookslist()) {
            if (bookId == book.getBookId()) {
                bookToGive = book;
                break;
            }
        }

        if (bookToGive == null) {
            throw new NullPointerException("Book not found!");
        }

        // Find member
        for (Member member : admin.getMemberslist()) {
            if (memberId == member.getMemberId()) {
                member.getBorrowedbooks().add(bookToGive);

                // Remove from available books
                admin.getBookslist().remove(bookToGive);

                return;
            }
        }

        throw new NullPointerException("Member not found!");
    }
}
