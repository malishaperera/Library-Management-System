package lk.ijse.BookWorm_library.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lk.ijse.BookWorm_library.dto.UserDTO;
import lk.ijse.BookWorm_library.entity.User;
import lk.ijse.BookWorm_library.entity.id.UserGenerator;
import lk.ijse.BookWorm_library.service.ServiceFactory;
import lk.ijse.BookWorm_library.service.custom.UserService;

public class UserManageFormController {
    @FXML
    private JFXButton btnCreateAccount;

    @FXML
    private PasswordField txtUserConfirmPassword;
    @FXML
    private TextField txtUserContact;

    @FXML
    private TextField txtUserName;

    @FXML
    private PasswordField txtUserPassword;


    @FXML
    private Label lblPasswordNotMatched1;

    @FXML
    private Label lblPasswordNotMatched2;

    UserService userService = (UserService) ServiceFactory.getBoFactory().getService(ServiceFactory.ServiceTypes.User);

    public void initialize(){
        setlblVisibility(false);
    }

    @FXML
    void btnCreateAccountOnAction(ActionEvent event){
        registerLibrary();
    }

    private void registerLibrary() {

        String userPassword = txtUserPassword.getText();
        String userConfirmPassword = txtUserConfirmPassword.getText();


        if (userPassword.equals(userConfirmPassword)){

            String userId="autogenarate";
            String userName= txtUserName.getText();
            String userContact = txtUserContact.getText();

            //create user account
            userService.saveUser(new UserDTO(userId,userName,userPassword,userContact));

        }else {
            setBorderColour("red");
            setlblVisibility(true);
            txtUserConfirmPassword.clear();
            txtUserPassword.requestFocus();
        }
    }

    private void setlblVisibility(boolean isVisible) {
        lblPasswordNotMatched1.setVisible(isVisible);
        lblPasswordNotMatched2.setVisible(isVisible);
    }

    private void setBorderColour(String colour) {
        txtUserPassword.setStyle("-fx-border-color: "+colour);
        txtUserConfirmPassword.setStyle("-fx-border-color: "+colour);
    }
}
