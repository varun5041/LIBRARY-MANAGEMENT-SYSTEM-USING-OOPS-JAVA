package Models;

public class Book
{   
    //book attributes
    int BookId= 1;
    String Title;
    String Author;

    //constructor
    public Book(int BookId, String Title, String Author)
    {
        this.BookId=BookId;
        this.Title=Title;
        this.Author=Author;
    }

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int bookId) {
        BookId = bookId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "BookId=" + BookId +
                ", Title='" + Title + '\'' +
                ", Author='" + Author + '\'' +
                '}';
    }
}