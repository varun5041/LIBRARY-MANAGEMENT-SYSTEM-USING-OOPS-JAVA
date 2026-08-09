package Services.Implimentations;

import Models.Admin;
import Models.Book;
import Models.Member;
import Repositories.BookRepository;
import Repositories.IssueRepository;
import Repositories.MemberRepository;
import Services.AdminServices;

import java.sql.SQLException;
import java.util.List;

public class SqlAdminServiceimpl implements AdminServices {

    private final BookRepository bookRepository =  new BookRepository();
    private final MemberRepository memberRepository = new MemberRepository();
    private final IssueRepository issueRepository = new IssueRepository();
    private final Admin admin;

    public SqlAdminServiceimpl(Admin admin) {
        this.admin = admin;
    }

    @Override
    public void showBooks() throws SQLException {
        List<Book> allbooks = bookRepository.getAllBooks();
        if (allbooks.isEmpty()) {
            System.out.println("\nNo books available in library.");
            return;
        }
        System.out.println("\n========================= BOOKS =========================");
        System.out.printf("%-10s %-25s %-25s%n", "Book ID", "Title", "Author");
        System.out.println("----------------------------------------------------------");
        for (Book book : allbooks) {
            System.out.printf(
                    "%-10d %-25s %-25s%n",
                    book.getBookId(),
                    book.getTitle(),
                    book.getAuthor()
            );
        }
        System.out.println("==========================================================");
    }

    @Override
    public void addbook(int bookidnum, String booktitle, String bookAuthor) throws SQLException {
        bookRepository.addBook(new Book(bookidnum,booktitle,bookAuthor));
    }

    @Override
    public void removebook(int rempoveID) throws SQLException {
        bookRepository.DeleteBook(rempoveID);
    }

    @Override
    public void AddMember(int Id, String name) throws SQLException {
        memberRepository.addMember(new Member(Id,name));
    }

    @Override
    public void removemember(int Id) throws SQLException {
        memberRepository.deleteMember(Id);
    }

    @Override
    public void showmembers() throws SQLException {
        List<Member> allMembers = memberRepository.getAllMembers();

        if(allMembers.isEmpty()){
            System.out.println("No Members In Library!");
            return;
        }

        System.out.println("\n======================= MEMBERS =========================");
        System.out.printf("%-15s %-30s%n", "Member ID", "Member Name");
        System.out.println("----------------------------------------------------------");

        for (Member member : allMembers) {
            System.out.printf(
                    "%-15d %-30s%n",
                    member.getMemberId(),
                    member.getMembername()
            );
        }

        System.out.println("==========================================================");
    }

    @Override
    public void getBorrowedBooks() throws SQLException {
        issueRepository.getBorrowedBooks();
    }

    @Override
    public void giveBookToMember(int memberId, int bookId) throws SQLException {

        if (bookRepository.getAllBooks().isEmpty()) {
            System.out.println("No Books In Library to Give");
            return;
        }

        if (bookRepository.getBookbyId(bookId) == null) {
            System.out.println("Book Not Found!");
            return;
        }

        if (memberRepository.getMemberById(memberId) == null) {
            System.out.println("Member Not Found!");
            return;
        }

        issueRepository.issueBook(memberId, bookId);

        System.out.println("Book Issued to Member successfully!");
    }

    @Override
    public void returnBook(int returnMemberId, int returnBookId) throws SQLException {
        issueRepository.returnBook(returnMemberId, returnBookId);
    }
}
