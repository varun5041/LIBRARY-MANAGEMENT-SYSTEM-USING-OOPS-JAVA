package Application;

import Models.Admin;
import Services.Implimentations.AdminServicesImpl;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Admin a = new Admin("Varun", 5041);
        AdminServicesImpl service = new AdminServicesImpl(a);
        while (true) {
            System.out.println("WELCOME TO LIBRARY!: ");
            System.out.println("=================================");
            System.out.println("1.Add Book");
            System.out.println("2.Show all Books");
            System.out.println("3.Remove Book");
            System.out.println("4.Add Members");
            System.out.println("5.Remove Members");
            System.out.println("6.Show all Members");
            System.out.println("7.Issue Book To a member");
            System.out.println("8.Show Books Borrowed By members");
            System.out.println("9.Exit");
            System.out.println("=================================");
            System.out.println("ENTER YOUR CHOICE:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Book Id:");
                    int bookid = sc.nextInt();
                    sc.nextLine(); // Consume newline character

                    System.out.println("Enter Book Title:");
                    String BookTitle = sc.nextLine();

                    System.out.println("Enter Book Author:");
                    String bookauthor = sc.nextLine();

                    service.addbook(bookid, BookTitle, bookauthor);  // Ensure addbook is defined
                    System.out.println("BOOK ADDED!");
                    break;

                case 2:
                    System.out.println("LIST OF ALL THE BOOKS");
                    service.showBooks();  // Ensure showBooks is defined
                    break;

                case 3:
                    System.out.println("Enter Book ID to remove");
                    int removeID= sc.nextInt();
                    service.removebook(removeID);
                    break;

                case 4:
                    System.out.println("Enter new Member id:");
                    int memberid = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter new Member name:");
                    String membername = sc.nextLine();
                    service.AddMember(memberid, membername);  // Ensure AddMember is defined
                    System.out.println("NEW MEMBER " + membername + " added successfully!");
                    break;
                case 5:
                    System.out.println("Enter Member ID to remove:");
                    int memid = sc.nextInt();
                    service.removemember(memid);  // Ensure removemember is defined
                    System.out.println("MEMBER removed successfully!");
                    break;
                case 6:
                    System.out.println("MEMBERS LIST ASSOCIATED WITH LIBRARY");
                    service.showmembers();  // Ensure showmembers is defined
                    break;
                case 7:
                    service.showmembers();
                    System.out.println("Enter Member Id From Above Members");
                    int memberID=sc.nextInt();
                    service.showBooks();
                    System.out.println("Enter Book Id To Give To Member");
                    int bookidtogive= sc.nextInt();
                    service.giveBookToMember(memberID,bookidtogive);
                case 8:
                    System.out.println("Books Borrowed Followed By members");
                    service.getBorrowedBooks();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please choose a number between 1 and 7.");
            }
        }
    }
}
