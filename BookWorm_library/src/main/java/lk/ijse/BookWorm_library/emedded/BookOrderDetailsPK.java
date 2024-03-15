package lk.ijse.BookWorm_library.emedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BookOrderDetailsPK implements Serializable {

    //book id
    //order id

    @Column(name = "book_order_id")
    private String bookOrderId;

    @Column(name = "book_id")
    private String bookId;

    public BookOrderDetailsPK() {
    }

    public BookOrderDetailsPK(String bookOrderId, String bookId) {
        this.bookOrderId = bookOrderId;
        this.bookId = bookId;
    }

    public String getBookOrderId() {
        return bookOrderId;
    }

    public void setBookOrderId(String bookOrderId) {
        this.bookOrderId = bookOrderId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "BookOrderDetailsPK{" +
                "bookOrderId='" + bookOrderId + '\'' +
                ", bookId='" + bookId + '\'' +
                '}';
    }
}
