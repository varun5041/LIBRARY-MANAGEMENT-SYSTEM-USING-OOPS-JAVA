package Services;

import Models.Admin;
import Models.Book;
import Models.Member;

import java.util.List;

public class AdminServices {
    Admin admin;

    public AdminServices(Admin admin) {
        this.admin = admin;
    }


    public void showBooks()
    {
        if (admin.getBookslist().isEmpty()) {
            System.out.println("No bookslist available.");
        }
        else {
            for (Book i : admin.getBookslist()) {
                System.out.println("Book ID: " + i.getBookId() + ", Title: " + i.getTitle() + ", Author: " + i.getAuthor());
            }
        }
    }

    //add a book by id
    public void addbook(int bookidnum,String booktitle,String bookAuthor)
    {
        admin.getBookslist().add(new Book(bookidnum,booktitle,bookAuthor));
    }

    //remove a book by id
    public void removebook(int rempoveID)
    {
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



    public void AddMember(int Id,String name)
    {
        admin.getMemberslist().add(new Member(Id,name));
    }


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



    public void showmembers() {
        if(admin.getMemberslist().isEmpty()) {
            System.out.println("THERE ARE NO MEMBERS IN THE LIBRARY!");
        }
        else{
            for(Member i : admin.getMemberslist())
            {
                System.out.println("memberid:" + i.getMemberId() + "MEMBER name"+ i.getMemberId());
            }
        }
    }

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

    public void GiveBookToMember(int memberid,int bookid){
        Book booktoGive = null;
        for(Book book: admin.getBookslist()){
            if(bookid==book.getBookId()){
                booktoGive=book;
            }
        }

        for (Member member : admin.getMemberslist()){
            if(memberid==member.getMemberId()){
                member.getBorrowedbooks().add(booktoGive);
            }
        }

        admin.getBookslist().remove(booktoGive);
    }
}
