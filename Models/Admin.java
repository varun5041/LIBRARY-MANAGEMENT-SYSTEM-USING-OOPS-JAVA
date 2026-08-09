package Models;

import java.util.ArrayList;
import java.util.Scanner;
public class Admin
{
    Scanner sc =new Scanner(System.in);
    String Adminname;
    int AdminId;

     
    //Models.Admin constructor
    public Admin(String name, int id)
    {
        this.Adminname=name;
        this.AdminId=id;
    }

    //Admin have book list and members list
    ArrayList<Book> bookslist = new ArrayList<>();
    ArrayList<Member> memberslist = new ArrayList<>();

    public String getAdminname() {
        return Adminname;
    }

    public void setAdminname(String adminname) {
        Adminname = adminname;
    }

    public int getAdminId() {
        return AdminId;
    }

    public void setAdminId(int adminId) {
        AdminId = adminId;
    }

    public ArrayList<Book> getBookslist() {
        return bookslist;
    }

    public void setBookslist(ArrayList<Book> bookslist) {
        this.bookslist = bookslist;
    }

    public ArrayList<Member> getMemberslist() {
        return memberslist;
    }

    public void setMemberslist(ArrayList<Member> memberslist) {
        this.memberslist = memberslist;
    }


    //    //display all bookslist in library
//    public void showBooks()
//    {
//        if (bookslist.isEmpty()) {
//            System.out.println("No bookslist available.");
//        }
//        else {
//            for (Book i : bookslist) {
//                System.out.println("Models.Book ID: " + i.BookId + ", Title: " + i.Title + ", Author: " + i.Author);
//            }
//        }
//    }
//
//    //add a book by id
//    public void addbook(int bookidnum,String booktitle,String bookAuthor)
//    {
//        bookslist.add(new Book(bookidnum,booktitle,bookAuthor));
//    }
//
//    //remove a book by id
//    public void removebook()
//    {
//        System.out.println("ENTER BOOK ID TO REMOVE:");
//        int bookidtoremove = sc.nextInt();
//
//        for (Book i : bookslist)
//        {
//            if (bookidtoremove == i.BookId)
//            {
//                bookslist.remove(i);
//                System.out.println("Models.Book removed successfully!");
//                    return;
//            }
//        }
//
//
//        System.out.println("BOOK NOT FOUND!");
//    }
//
//
//
//    public void AddMember(int Id,String name)
//    {
//        memberslist.add(new Member(Id,name));
//    }
//
//
//   public void removemember(int Id) {
//   int removememberid=Id;
//
//    for (Member i : memberslist) {
//        if (removememberid == i.MemberId) {
//            memberslist.remove(i);
//            System.out.println("Member removed successfully!");
//            return;
//        }
//    }
//    System.out.println("Member not found!");
//}
//
//
//
//    public void showmembers() {
//        if(memberslist.isEmpty()) {
//            System.out.println("THERE ARE NO MEMBERS IN THE LIBRARY!");
//        }
//        else{
//            for(Member i : memberslist)
//            {
//                System.out.println("memberid:" + i.MemberId + "MEMBER name"+ i.MemberId );
//            }
//        }
//    }
//
//    public void getBorrowedBooks(){
//        for (Member member : memberslist) {
//            System.out.println("Member ID: " + member.MemberId);
//            System.out.println("Member Name: " + member.Membername);
//
//            for (Book book : member.borrowedbooks) {
//                System.out.println(
//                            "Book ID: " + book.BookId +
//                                    ", Title: " + book.Title
//                );
//            }
//
//            System.out.println("----------------------");
//        }
//    }

//    public void GiveBookToMember(int memberid,int bookId){
//
//    }

}
