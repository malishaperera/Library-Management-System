package lk.ijse.BookWorm_library.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import lk.ijse.BookWorm_library.dto.BookDTO;
import lk.ijse.BookWorm_library.service.ServiceFactory;
import lk.ijse.BookWorm_library.service.custom.BookService;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BookManageFormController extends BookCardFormController{

    @FXML
    private TextField bookId;

    @FXML
    private TextField book_author;

    @FXML
    private TextField book_branch;

    @FXML
    private ImageView book_img;

    @FXML
    private TextField book_qty;

    @FXML
    private TextField book_title;

    @FXML
    private ComboBox<String> comBook_Genre;

    @FXML
    private JFXButton btnSave;


    @FXML
    private JFXButton btnSearch;

    @FXML
    private AnchorPane bookSaveRoot;


    private byte[] vehicleImageBytes;
    Image vehicleImage = null;


    BookService bookService = (BookService) ServiceFactory.getBoFactory().getService(ServiceFactory.ServiceTypes.Book);

    public void initialize() {

        // Create an ObservableList containing the items
        ObservableList<String> items = FXCollections.observableArrayList("Education", "Children", "Horror");

        comBook_Genre.setItems(items);


    }

    @FXML
    void btnAddBookStoreOnAction(ActionEvent event) {
       /* String bookIdText = bookId.getText().replaceAll("L", "");
        Long bookID = Long.valueOf(bookIdText);*/

       // long bookID = Long.parseLong(bookId.getText());

        String bookID = bookId.getText();
        String bookTitle = book_title.getText();
        String bookAuthor = book_author.getText();
        int bookQty = Integer.parseInt(book_qty.getText());
        String bookBranch = book_branch.getText();
        String booGenre = comBook_Genre.getValue();


        bookService.saveBook(new BookDTO(bookID, bookTitle, bookAuthor, bookQty, bookBranch, booGenre, vehicleImageBytes));

        /*System.out.println(isSaveBook);
        if (isSaveBook > -1) {
            new Alert(Alert.AlertType.CONFIRMATION, "Woow").show();

        }*/
    }

    @FXML
    void btnSearchBookonAction(ActionEvent event) {

    }

    @FXML
    void btnBookImageUploadOnAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image File");
        File selectedFile = fileChooser.showOpenDialog(new Stage());

        if (selectedFile != null) {
            try {
                // Read the image file as a BufferedImage
                BufferedImage bufferedImage = ImageIO.read(selectedFile);

                // Convert the BufferedImage to a byte array
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ImageIO.write(bufferedImage, "png", byteArrayOutputStream);
                vehicleImageBytes = byteArrayOutputStream.toByteArray();

                // Display the selected image in the ImageView
                vehicleImage = new Image(new FileInputStream(selectedFile));
                book_img.setImage(vehicleImage);

                new Alert(Alert.AlertType.INFORMATION, "Image uploaded successfully").show();
            } catch (IOException e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, "Error uploading image").show();

            }
        }
    }
}
