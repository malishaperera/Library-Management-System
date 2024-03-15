package lk.ijse.BookWorm_library.repository.custom;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lk.ijse.BookWorm_library.entity.Books;
import lk.ijse.BookWorm_library.entity.User;
import lk.ijse.BookWorm_library.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User ,String> {
    boolean verifyUser(String name, String password);

    String checkAccount(String txtuserName, String txtPassword);


    List<Books> getAllJPQLBooks(String branchSelect, String categorySelect);
}
