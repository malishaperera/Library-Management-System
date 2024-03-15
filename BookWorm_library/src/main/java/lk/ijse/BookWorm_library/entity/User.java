package lk.ijse.BookWorm_library.entity;

import lk.ijse.BookWorm_library.dto.BranchDTO;
import lk.ijse.BookWorm_library.dto.UserDTO;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "custom-id")
    @GenericGenerator(name = "custom-id", strategy = "lk.ijse.BookWorm_library.entity.id.UserGenerator")//lk.ijse.BookWorm_library.entity.CustomIdGenerator  //lk.ijse.BookWorm_library.entity.CustomIdGenerator
    @Column(name = "user_id")
    String userId;

    @Column(name = "user_name")
    String userName;

    @Column(name = "user_password")
    String userPassword;

    @Column(name = "user_contactNumber")
    String userContactNumber;



    public User() {
    }



    public User(String userId, String userName, String userPassword, String userContactNumber) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userContactNumber = userContactNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserContactNumber() {
        return userContactNumber;
    }

    public void setUserContactNumber(String userContactNumber) {
        this.userContactNumber = userContactNumber;
    }

    public UserDTO toDto() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(this.userId);
        userDTO.setUserName(this.userName);
        userDTO.setUserPassword(this.userPassword);
        userDTO.setUserContactNumber(this.userContactNumber);

        return userDTO;
    }

    //me tika



    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userId")   //mappeBy damme assosiate table aka nathara karanna
    private List<BookOrder> bookOrders = new ArrayList<>();                              //user ta bookorder list akak thiyenava











    public List<BookOrder> getBookOrders() {
        return bookOrders;
    }

    public void setBookOrders(List<BookOrder> bookOrders) {
        this.bookOrders = bookOrders;
    }

    public User(String userId, String userName, String userPassword, String userContactNumber, List<BookOrder> bookOrders) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userContactNumber = userContactNumber;
        this.bookOrders = bookOrders;
    }
}
