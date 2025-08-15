

import java.util.ArrayList;
import java.util.Scanner;
public class admin 
{
    Scanner sc =new Scanner(System.in);
    String Adminname;
    int AdminId;
     
    //admin constructor
    admin(String name,int id)
    {
        this.Adminname=name;
        this.AdminId=id;
    }

    //admin have book list and members list
    ArrayList<Book> books = new ArrayList<>(); 
    ArrayList<member> memberslist = new ArrayList<>();


    //display all books in library
    public void showBooks() 
    {
        if (books.isEmpty()) 
        {
            System.out.println("No books available.");
        } 

        else 
        {
            for (Book i : books) 
            {
                System.out.println("Book ID: " + i.BookId + ", Title: " + i.Title + ", Author: " + i.Author);
            }
        }
    }
    
    //add a book by id
    public void addbook(int bookidnum,String booktitle,String bookAuthor)
    {
        books.add(new Book(bookidnum,booktitle,bookAuthor));
        System.out.println("BOOK ADDED!");
    }

    //remove a book by id
    public void removebook() 
    {
        System.out.println("ENTER BOOK ID TO REMOVE:");
        int bookidtoremove = sc.nextInt();
    
        for (Book i : books) 
        {
            if (bookidtoremove == i.BookId) 
            {
                books.remove(i);
                System.out.println("Book removed successfully!");
                    return; 
            }
        }

        
        System.out.println("BOOK NOT FOUND!");
    }

     
    
    public void AddMember(int Id,String name)
    {
        memberslist.add(new member(Id,name));
    } 

    
   public void removemember(int Id) {
   int removememberid=Id;
    
    for (member i : memberslist) {
        if (removememberid == i.MemberId) {
            memberslist.remove(i);
            System.out.println("Member removed successfully!");
            return; 
        }
    }
    
    
    System.out.println("Member not found!");
}


    
    public void showmembers()
    {
        if(memberslist.isEmpty())
        {
            System.out.println("THERE ARE NO MEMBERS IN THE LIBRARY!");
        }
        else
        {
            for(member i : memberslist)
            {
                System.out.println("memberid:" + i.MemberId + "MEMBER name"+ i.MemberId );
            }
        }   
    }


}
