package lk.ijse.BookWorm_library.entity;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "book_order")
public class BookOrder {

     /* @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Books> books = new ArrayList<>();*/

    @Id
    @Column(name = "book_order_id")
    private String book_orderId;


    @Column(name = "book_order_time")
    private String boo_order_date_time;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "bookOrder"// book_order
    )
    private List<BookOrderDetails> orderDetails = new ArrayList<>();



    public BookOrder() {
    }

    public BookOrder(String book_orderId, String boo_order_date_time, User userId, List<BookOrderDetails> orderDetails) {
        this.book_orderId = book_orderId;
        this.boo_order_date_time = boo_order_date_time;
        this.userId = userId;
        this.orderDetails = orderDetails;
    }

    public String getBook_orderId() {
        return book_orderId;
    }

    public void setBook_orderId(String book_orderId) {
        this.book_orderId = book_orderId;
    }

    public String getBoo_order_date_time() {
        return boo_order_date_time;
    }

    public void setBoo_order_date_time(String boo_order_date_time) {
        this.boo_order_date_time = boo_order_date_time;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public List<BookOrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<BookOrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "BookOrder{" +
                "book_orderId='" + book_orderId + '\'' +
                ", boo_order_date_time='" + boo_order_date_time + '\'' +
                ", userId=" + userId +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
