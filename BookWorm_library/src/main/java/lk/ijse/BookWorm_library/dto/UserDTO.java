package lk.ijse.BookWorm_library.dto;

import lk.ijse.BookWorm_library.entity.Branchs;
import lk.ijse.BookWorm_library.entity.User;

import javax.persistence.Column;

public class UserDTO {
    String userId;

    String userName;

    String userPassword;

    String userContactNumber;


    public UserDTO() {
    }

    public UserDTO(String userId, String userName, String userPassword, String userContactNumber) {
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

    public User toEntity() {
        User user = new User();
        user.setUserId(this.userId);
        user.setUserName(this.userName);
        user.setUserPassword(this.userPassword);
        user.setUserContactNumber(this.userContactNumber);
        return user;
    }
}
