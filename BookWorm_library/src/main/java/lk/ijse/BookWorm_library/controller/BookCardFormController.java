package lk.ijse.BookWorm_library.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.VBox;
import lk.ijse.BookWorm_library.dto.BookDTO;
import lk.ijse.BookWorm_library.entity.Books;
import lk.ijse.BookWorm_library.service.ServiceFactory;
import lk.ijse.BookWorm_library.service.custom.BookService;


import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BookCardFormController {

    @FXML
    private ImageView bookImg;

    @FXML
    private VBox bookVbox;

    @FXML
    private Label lblBookId;

    @FXML
    private TextField txtBookAuthor;

    @FXML
    private TextField txtBookGenre;

    @FXML
    private TextField txtBookQty;

    @FXML
    private TextField txtBookTitle;

    @FXML
    private JFXButton btnBookDelete;

    @FXML
    private JFXButton btnBookUpdate;

    @FXML
    private TextField txtBookBranch;

    private byte[] vehicleImageBytes;
    Image vehicleImage = null;

    BookService bookService = (BookService) ServiceFactory.getBoFactory().getService(ServiceFactory.ServiceTypes.Book);

    public void initialize(){
        txtBookQty.setDisable(true); //disable is locked
    }

    public void setData(Books books, Image imageView) {
        //lblBookId.setText(String.valueOf(books.getBookId()));
        lblBookId.setText(books.getBookId());
        txtBookTitle.setText(books.getBookTitle());
        txtBookAuthor.setText(books.getBookAuthor());
        txtBookGenre.setText(books.getBookGenre());
        txtBookQty.setText(String.valueOf(books.getBookQty()));
        txtBookBranch.setText(books.getBookBranch());
        bookImg.setImage(imageView);
    }

    @FXML
    void btnBookUpdateOnAction(ActionEvent event) {
        txtBookQty.setDisable(false);
        btnBookUpdate.setText("Save");
        check();
    }



    private void check() { //update is not correct.look for after
        if (btnBookUpdate.equals("Save"));


        btnBookUpdate.setOnMousePressed(event -> {
            new Alert(Alert.AlertType.INFORMATION,"O yef").show();
           // long bookId = Long.parseLong(lblBookId.getText());
            String bookId = lblBookId.getText();
            String bookTitle = txtBookTitle.getText();
            String bookAuthor = txtBookAuthor.getText();
            int bookQty = Integer.parseInt(txtBookQty.getText());
            String bookBranch = txtBookBranch.getText();
            String bookGenre = txtBookGenre.getText();


            BookDTO bookDTO1 = checkBook(bookId);
            if (bookDTO1 !=null){


                try {
                    imageByteConvert();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                //after issues you check bookKIs.getBookImg()
                BookDTO bookDTO = new BookDTO(bookId,bookTitle,bookAuthor,bookQty,bookBranch,bookGenre,bookDTO1.getBookImg());
                bookService.updateBook(bookDTO);
            }
        });
    }

    private void imageByteConvert() throws IOException {
        //This method  convert Image view byte[]
        //It's ok


    }

    @FXML
    void btnBookDeleteOnAction(ActionEvent event) {
        //long bookId = Long.parseLong(lblBookId.getText());
        String bookId = lblBookId.getText();
        System.out.println("This is book ID0"+bookId);

        BookDTO existingBook = checkBook(bookId);
        bookService.deleteBook(existingBook);
    }

    private BookDTO checkBook(String bookId) {
        /*BookDTO bookDTO = bookService.getBook(Long.parseLong(bookId));*/
        BookDTO bookDTO = bookService.getBook(bookId);
        return bookDTO;
    }
}
