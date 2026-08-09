package Models;

import java.util.ArrayList;
import java.util.List;

public class Member
{
    int MemberId;
    String Membername;
    List<Book> borrowedbooks= new ArrayList<>();


    public Member(int memberId, String membername) {
        MemberId = memberId;
        Membername = membername;
    }

    public int getMemberId() {
        return MemberId;
    }

    public void setMemberId(int memberId) {
        MemberId = memberId;
    }

    public String getMembername() {
        return Membername;
    }

    public void setMembername(String membername) {
        Membername = membername;
    }

    public List<Book> getBorrowedbooks() {
        return borrowedbooks;
    }

    public void setBorrowedbooks(List<Book> borrowedbooks) {
        this.borrowedbooks = borrowedbooks;
    }

    @Override
    public String toString() {
        return "Member{" +
                "MemberId=" + MemberId +
                ", Membername='" + Membername + '\'' +
                ", borrowedbooks=" + borrowedbooks +
                '}';
    }
}
