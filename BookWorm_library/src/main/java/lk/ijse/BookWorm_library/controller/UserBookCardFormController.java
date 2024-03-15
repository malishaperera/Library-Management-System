package lk.ijse.BookWorm_library.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import lk.ijse.BookWorm_library.entity.Books;
import lk.ijse.BookWorm_library.service.ServiceFactory;
import lk.ijse.BookWorm_library.service.custom.BookService;

public class UserBookCardFormController {
    @FXML
    private ImageView bookImg;

    @FXML
    private VBox bookVbox;

    @FXML
    private JFXButton btnRead;

    @FXML
    private Label lblBookId;

    @FXML
    private TextField txtBookAuthor;

    @FXML
    private TextField txtBookBranch;

    @FXML
    private TextField txtBookGenre;

    @FXML
    private TextField txtBookQty;

    @FXML
    private TextField txtBookTitle;

    public void initialize(){
        txtBookTitle.setDisable(true);
        txtBookAuthor.setDisable(true);
        txtBookGenre.setDisable(true);
        txtBookQty.setDisable(true);
        txtBookBranch.setDisable(true);

    }

    @FXML
    void btnReadBookOnAction(ActionEvent event) {
        String bookId = lblBookId.getText();
        String bookTitle = txtBookTitle.getText();
        String bookAuthor = txtBookAuthor.getText();
        String bookGenre = txtBookGenre.getText();
        String bookQty = txtBookQty.getText();
        String bookBranch = txtBookBranch.getText();

    }


    public void setData(Books books, Image image) {
        lblBookId.setText(books.getBookId());
        txtBookTitle.setText(books.getBookTitle());
        txtBookAuthor.setText(books.getBookAuthor());
        txtBookGenre.setText(books.getBookGenre());
        txtBookQty.setText(String.valueOf(books.getBookQty()));
        txtBookBranch.setText(books.getBookBranch());
        bookImg.setImage(image);
    }
}
