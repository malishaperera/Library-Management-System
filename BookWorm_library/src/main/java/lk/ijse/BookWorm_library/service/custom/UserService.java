package lk.ijse.BookWorm_library.service.custom;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lk.ijse.BookWorm_library.dto.UserDTO;
import lk.ijse.BookWorm_library.entity.Books;
import lk.ijse.BookWorm_library.service.SuperService;

import java.util.List;

public interface UserService extends SuperService {
    List<String> getUserId();

    String saveUser(UserDTO userDTO);

    boolean verifyUser(String text, String text1);

    String check(TextField txtuserName, PasswordField txtPassword);

    List<Books> getAllJPQLBooks(String branchSelect, String categorySelect);
}
