package lk.ijse.BookWorm_library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.BookWorm_library.service.ServiceFactory;
import lk.ijse.BookWorm_library.service.custom.UserService;

import java.io.IOException;

public class LoginFormController {
    @FXML
    private ImageView showPassword;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtuserName;

    @FXML
    private AnchorPane rootLogin;

    UserService userService = (UserService) ServiceFactory.getBoFactory().getService(ServiceFactory.ServiceTypes.User);




    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
        String userId = userService.check(txtuserName, txtPassword); ;

        if (userService.verifyUser(txtuserName.getText(), txtPassword.getText())) {
            if (userId != null && userId.startsWith("U")) {
                navigateUserDashboard();
            } else {
                navigateAdminDashboard();
            }
        } else {
            // User verification failed
            // Handle this case (e.g., show an error message)
        }

    }

    private void navigateAdminDashboard() throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/view/bookworm_library_form.fxml"));
        Scene scene = new Scene(parent);

        rootLogin.getChildren().clear();
        Stage primaryStage = (Stage) rootLogin.getScene().getWindow();

        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("MainWindow");
    }

    private void navigateUserDashboard() throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/view/user_dashboard_form.fxml"));
        Scene scene = new Scene(parent);

        rootLogin.getChildren().clear();
        Stage primaryStage = (Stage) rootLogin.getScene().getWindow();

        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("MainWindow");

    }



    @FXML
    void singnUpOnAction(ActionEvent event) throws IOException {


        Parent parent = FXMLLoader.load(this.getClass().getResource("/view/user_manage_form.fxml"));
        Scene scene = new Scene(parent);

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }




    @FXML
    void showPasswordOnMouseClicked(MouseEvent event) {
        txtPassword.setText(txtPassword.getText());

    }
}
