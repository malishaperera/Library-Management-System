package lk.ijse.BookWorm_library.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.BookWorm_library.dto.BookDTO;
import lk.ijse.BookWorm_library.entity.Books;
import lk.ijse.BookWorm_library.service.ServiceFactory;
import lk.ijse.BookWorm_library.service.custom.BookService;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BookwormLibraryFormController implements Initializable {
    @FXML
    private ImageView imgBook;

    @FXML
    private Label lblsection;


    @FXML
    private GridPane girdBook;

    @FXML
    private AnchorPane mainAnchor2;

    @FXML
    private ComboBox<String> comBranchSelect;

    @FXML
    private ComboBox<String> comBookCategory;


    @FXML
    private ImageView imgBranch;

    @FXML
    private AnchorPane mainRoot;



    BookService bookService = (BookService) ServiceFactory.getBoFactory().getService(ServiceFactory.ServiceTypes.Book);


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        /*ObservableList<String> items = FXCollections.observableArrayList("Education", "Children", "Horror"); meka araka coment ,*/

        ObservableList<String> items = FXCollections.observableArrayList("Galle", "Matara", "Colombo");
        comBranchSelect.setItems(items);

        girdBook.setVisible(false); // Initially hiding the grid

        ObservableList<String> category = FXCollections.observableArrayList("Education", "Children", "Horror");
        comBookCategory.setItems(category);


        comBranchSelect.setOnAction(event -> { //  Add listener to the ComboBox selection change event ,and 2 list
            String branchSelect = comBranchSelect.getValue();
            if (branchSelect != null) {

                comBookCategory.setOnAction(event1 -> {
                    String categorySelect = comBookCategory.getValue();
                    if (categorySelect != null){


                        List<Books> booksCard = loadAllBook(branchSelect,categorySelect); // Load books for the selected branch,ok
//

                        if(booksCard.size() == 0){ //cheak books branch availabality
                            new Alert(Alert.AlertType.INFORMATION,"Those book genres are not available in this branch").show();
                        }

                        girdBook.getChildren().clear(); // Clear existing content in the grid

                        try {
                            int column = 0;
                            int row = 1;

                            for (Books books : booksCard) {
                                byte[] bookImage = books.getBookImg();
                                if (bookImage != null && bookImage.length > 0) {
                                    ByteArrayInputStream bis = new ByteArrayInputStream(bookImage);
                                    Image image = new Image(bis);
                                    System.out.println("why");

                                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/book_card_form.fxml"));
                                    VBox vBox = fxmlLoader.load();
                                    BookCardFormController bookCardFormController = fxmlLoader.getController();
                                    bookCardFormController.setData(books, image);


                                    if (column == 6) {
                                        column = 0;
                                        row++;
                                    }
                                    girdBook.add(vBox, column++, row);
                                    GridPane.setMargin(vBox, new Insets(10));//marging book(space)
                                }
                            }

                            girdBook.setVisible(true); // Make the grid visible after loading books ,ok

                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                    }
                });
            }
        });
    }





    @FXML
    void navigate(MouseEvent event) throws IOException {

        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            Parent root = null;
            Parent parent = null;

            switch (icon.getId()) {
                case "imgBook":

                    /*parent = FXMLLoader.load(this.getClass().getResource("/view/book_manage_form.fxml"));
                    this.mainAnchor2.getChildren().clear();
                    this.mainAnchor2.getChildren().add(parent);
                    break;*/

                    parent = FXMLLoader.load(this.getClass().getResource("/view/book_manage_form.fxml"));
                    Scene scene = new Scene(parent);

                    Stage stage = new Stage();
                    stage.setScene(scene);

                    stage.show();
                    stage.centerOnScreen();
                    break;

                case  "imgBranch":
                    parent = FXMLLoader.load(this.getClass().getResource("/view/book_branch_manage_form.fxml"));
                    this.mainAnchor2.getChildren().clear();
                    this.mainAnchor2.getChildren().add(parent);
                    break;

            }

            if (root != null) {
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.mainAnchor2.getScene().getWindow();
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();

                TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
                tt.setFromX(-subScene.getWidth());
                tt.setToX(0);
                tt.play();

            }
        }
    }


    @FXML
    void playMouseEnterAnimation(MouseEvent event) {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            switch (icon.getId()) {

                case "imgCustomers":
                    lblsection.setText("Manage customer");
                    break;
            }

            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play();

            DropShadow glow = new DropShadow();
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            icon.setEffect(glow);
        }
    }


    @FXML
    void playMouseExitAnimation(MouseEvent event) {

        if (event.getSource() instanceof ImageView){
            ImageView icon = (ImageView) event.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();

            icon.setEffect(null);
            lblsection.setText("Welcome");
        }
    }


    @FXML
    void btnHomeOnAction(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/view/bookworm_library_form.fxml"));
        this.mainRoot.getChildren().clear();
        this.mainRoot.getChildren().add(parent);

    }


    private List<Books> loadAllBook(String branchSelect , String categorySelect) {

        List<Books> allJPQLBooks = bookService.getAllJPQLBooks(branchSelect,categorySelect);
        return  allJPQLBooks;
    }
}