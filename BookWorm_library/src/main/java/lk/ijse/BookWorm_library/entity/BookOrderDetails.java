package lk.ijse.BookWorm_library.entity;

import lk.ijse.BookWorm_library.emedded.BookOrderDetailsPK;

import javax.persistence.*;
import java.time.LocalDate;
@Entity(name = "book_OrderDetails")
public class BookOrderDetails {

    @EmbeddedId
    private BookOrderDetailsPK  bookOrderDetailsPK;

    @Column(name = "bookReturn_Date")
    private LocalDate bookReturnDate;

    @ManyToOne
    @JoinColumn(
            name = "book_order_id",
            referencedColumnName = "book_order_id",
            insertable = false,
            updatable = false
    )
    private BookOrder bookOrder;


    @ManyToOne
    @JoinColumn(
            name = "book_id",
            referencedColumnName = "book_id",
            insertable = false,
            updatable = false
    )
    private Books item;




    public BookOrderDetails() {
    }

    public BookOrderDetails(BookOrderDetailsPK bookOrderDetailsPK, LocalDate bookReturnDate, BookOrder bookOrder, Books item) {
        this.bookOrderDetailsPK = bookOrderDetailsPK;
        this.bookReturnDate = bookReturnDate;
        this.bookOrder = bookOrder;
        this.item = item;
    }

    public BookOrderDetailsPK getBookOrderDetailsPK() {
        return bookOrderDetailsPK;
    }

    public void setBookOrderDetailsPK(BookOrderDetailsPK bookOrderDetailsPK) {
        this.bookOrderDetailsPK = bookOrderDetailsPK;
    }

    public LocalDate getBookReturnDate() {
        return bookReturnDate;
    }

    public void setBookReturnDate(LocalDate bookReturnDate) {
        this.bookReturnDate = bookReturnDate;
    }

    public BookOrder getBookOrder() {
        return bookOrder;
    }

    public void setBookOrder(BookOrder bookOrder) {
        this.bookOrder = bookOrder;
    }

    public Books getItem() {
        return item;
    }

    public void setItem(Books item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "BookOrderDetails{" +
                "bookOrderDetailsPK=" + bookOrderDetailsPK +
                ", bookReturnDate=" + bookReturnDate +
                ", bookOrder=" + bookOrder +
                ", item=" + item +
                '}';
    }
}
