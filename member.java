import java.util.ArrayList;

public class member 
{
    int MemberId;
    String Membername;
    ArrayList<Book> borrowedbooks = new ArrayList<>();
    
    member(int MemberId,String Membername)
    {
        this.MemberId=MemberId;
        this.Membername=Membername;
    }

    public static void recievebook(Book book)
    {
        
    }

    public void givebook(Book book){
       
    }
}
