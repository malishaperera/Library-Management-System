package lk.ijse.BookWorm_library.entity;

import lk.ijse.BookWorm_library.dto.BookDTO;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Books  {

/*    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "custom-id")
    @GenericGenerator(name = "custom-id", strategy = "lk.ijse.BookWorm_library.entity.id.BookIdGenerator")
    @Column(name = "book_id")
    String bookId;

    @Column(name = "book_title")
    String bookTitle;

    @Column(name = "book_author")
    String bookAuthor;

    @Column(name = "book_qty")
    int bookQty;

    @Column(name = "book_branch")
    String bookBranch;

    @Column(name = "book_genre")
    String bookGenre;

    @Column(name = "book_img")
    private byte[] bookImg;

    /*@ManyToMany(mappedBy = "bookOrders")
    private List<BookOrder> bookOrders = new ArrayList<>();*/

//LONGBLOB
    public Books(String bookId, String bookTitle, String bookAuthor, int bookQty, String bookBranch, String bookGenre,byte[] bookImg) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookQty = bookQty;
        this.bookBranch = bookBranch;
        this.bookGenre = bookGenre;
        this.bookImg = bookImg;
    }

    public byte[] getBookImg() {
        return bookImg;
    }



    public void setBookImg(byte[] bookImg) {
        this.bookImg = bookImg;
    }

    public Books() {
    }


    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }



    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getBookQty() {
        return bookQty;
    }

    public void setBookQty(int bookQty) {
        this.bookQty = bookQty;
    }

    public String getBookBranch() {
        return bookBranch;
    }

    public void setBookBranch(String bookBranch) {
        this.bookBranch = bookBranch;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookQty=" + bookQty +
                ", bookBranch='" + bookBranch + '\'' +
                ", bookGenre='" + bookGenre + '\'' +
                '}';
    }

    public BookDTO toDto() {
        BookDTO bookDto = new BookDTO();
        bookDto.setBookId(this.bookId);
        bookDto.setBookTitle(this.bookTitle);
        bookDto.setBookAuthor(this.bookAuthor);
        bookDto.setBookQty(this.bookQty);
        bookDto.setBookGenre(this.bookGenre);
        bookDto.setBookBranch(this.bookBranch);
        bookDto.setBookImg(this.bookImg);
        return bookDto;
    }


    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "bookOrder"
    )
    private List<BookOrderDetails> orderDetails = new ArrayList<>();



    public List<BookOrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<BookOrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Books(String bookId, String bookTitle, String bookAuthor, int bookQty, String bookBranch, String bookGenre, byte[] bookImg, List<BookOrderDetails> orderDetails) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookQty = bookQty;
        this.bookBranch = bookBranch;
        this.bookGenre = bookGenre;
        this.bookImg = bookImg;
        this.orderDetails = orderDetails;
    }
}
