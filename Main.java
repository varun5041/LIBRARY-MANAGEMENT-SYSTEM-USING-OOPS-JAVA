import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        admin a = new admin("Varun", 5041);

        while (true) {
            System.out.println("WELCOME TO LIBRARY!: ");
            System.out.println("=================================");
            System.out.println("1.Add Book");
            System.out.println("2.Show all Books");
            System.out.println("3.Remove Book");
            System.out.println("4.Add Members");
            System.out.println("5.Remove Members");
            System.out.println("6.Show all Members");
            System.out.println("7.Exit");
            System.out.println("=================================");
            System.out.println("ENTER YOUR CHOICE:");
            choice = sc.nextInt();

            // Consume newline left by nextInt()
            sc.nextLine();

            switch (choice) {
                case 1:
                    int bookid;
                    String bookauthor;
                    String BookTitle;

                    System.out.println("Enter Book Id:");
                    bookid = sc.nextInt();
                    sc.nextLine(); // Consume newline character

                    System.out.println("Enter Book Title:");
                    BookTitle = sc.nextLine();

                    System.out.println("Enter Book Author:");
                    bookauthor = sc.nextLine();

                    a.addbook(bookid, BookTitle, bookauthor);  // Ensure addbook is defined
                    System.out.println("BOOK ADDED!");
                    break;

                case 2:
                    System.out.println("LIST OF ALL THE BOOKS");
                    a.showBooks();  // Ensure showBooks is defined
                    break;

                case 3:
                    a.removebook();  // Ensure removebook is defined
                    break;

                case 4:
                    System.out.println("Enter new member id:");
                    int memberid = sc.nextInt();
                    sc.nextLine();  // Consume newline character
                    System.out.println("Enter new member name:");
                    String membername = sc.nextLine();
                    a.AddMember(memberid, membername);  // Ensure AddMember is defined
                    System.out.println("NEW MEMBER " + membername + " added successfully!");
                    break;

                case 5:
                    System.out.println("Enter member ID to remove:");
                    int memid = sc.nextInt();
                    a.removemember(memid);  // Ensure removemember is defined
                    System.out.println("MEMBER removed successfully!");
                    break;

                case 6:
                    System.out.println("MEMBERS LIST ASSOCIATED WITH LIBRARY");
                    a.showmembers();  // Ensure showmembers is defined
                    break;

                case 7:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please choose a number between 1 and 7.");
            }
        }
    }
}
