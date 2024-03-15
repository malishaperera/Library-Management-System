package lk.ijse.BookWorm_library.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import lk.ijse.BookWorm_library.entity.Books;
import lk.ijse.BookWorm_library.service.ServiceFactory;
import lk.ijse.BookWorm_library.service.custom.BookService;
import lk.ijse.BookWorm_library.service.custom.UserService;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class UserDashboardFormController implements Initializable {
    @FXML
    private ComboBox<String> comBookCategory;

    @FXML
    private ComboBox<String> comBranchSelect;


    @FXML
    private GridPane girdBook;

    @FXML
    private ImageView imgBook;

    @FXML
    private AnchorPane mainAnchor2;

    @FXML
    private AnchorPane mainRoot;

   // BookService bookService = (BookService) ServiceFactory.getBoFactory().getService(ServiceFactory.ServiceTypes.Book);

    UserService userService = (UserService) ServiceFactory.getBoFactory().getService(ServiceFactory.ServiceTypes.User);




    @FXML
    void btnHomeOnAction(ActionEvent event) {

    }

    @FXML
    void navigate(MouseEvent event) {

    }

    @FXML
    void playMouseEnterAnimation(MouseEvent event) {

    }

    @FXML
    void playMouseExitAnimation(MouseEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

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

                                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/user_book_card_form.fxml"));
                                    VBox vBox = fxmlLoader.load();
                                    UserBookCardFormController userBookCardFormController = fxmlLoader.getController();
                                    userBookCardFormController.setData(books, image);


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

    private List<Books> loadAllBook(String branchSelect, String categorySelect) {
        List<Books> allJPQLBooks = userService.getAllJPQLBooks(branchSelect,categorySelect);
        return  allJPQLBooks;
    }
}
