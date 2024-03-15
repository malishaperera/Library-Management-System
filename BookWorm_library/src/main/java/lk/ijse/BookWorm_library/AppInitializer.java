package lk.ijse.BookWorm_library;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AppInitializer extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        /*stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/bookworm_library_form.fxml"))));
        stage.setTitle("Main Form");

        stage.centerOnScreen();
        stage.show();*/

        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/login_form.fxml"))));
        stage.setTitle("Login Form");

        stage.centerOnScreen();
        stage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
