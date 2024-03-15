package lk.ijse.BookWorm_library.service.custom.impl;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lk.ijse.BookWorm_library.dto.UserDTO;
import lk.ijse.BookWorm_library.entity.Books;
import lk.ijse.BookWorm_library.entity.Branchs;
import lk.ijse.BookWorm_library.entity.User;
import lk.ijse.BookWorm_library.repository.RepositoryFactory;
import lk.ijse.BookWorm_library.repository.custom.UserRepository;
import lk.ijse.BookWorm_library.service.custom.UserService;
import lk.ijse.BookWorm_library.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserRepository userRepository = (UserRepository) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryTypes.User);

    private Session session;
    @Override
    public List<String> getUserId() {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        userRepository.setSession(session);
        List<String> allId = userRepository.getAllId();
        return allId;
    }

    @Override
    public String saveUser(UserDTO userDTO) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            userRepository.setSession(session);
            String saved = userRepository.save(new User(userDTO.getUserId(), userDTO.getUserName(), userDTO.getUserPassword(), userDTO.getUserContactNumber()));
            System.out.println("csccdxcddx "+saved);
            transaction.commit();
            session.close();
            return "isSave";

        }catch (Exception e){
            transaction.rollback();
            session.close();
            e.printStackTrace();

            return "no";
        }
    }

    @Override
    public boolean verifyUser(String name, String password) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();

        userRepository.setSession(session);
        boolean isUser = userRepository.verifyUser(name, password);

        return isUser;
    }

    @Override
    public String check(TextField txtuserName, PasswordField txtPassword) {
        session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        userRepository.setSession(session);

        String userID  = userRepository.checkAccount(txtuserName.getText(), txtPassword.getText()); // Pass text values
        return userID;
    }

    @Override
    public List<Books> getAllJPQLBooks(String branchSelect, String categorySelect) {
        session =SessionFactoryConfig.getInstance()
                .getSession();

        userRepository.setSession(session);

        List<Books> allJPQLBooks = userRepository.getAllJPQLBooks(branchSelect,categorySelect);
        List<Books> allBook = new ArrayList<>();
        for (Books books :allJPQLBooks){
            allBook.add(books);

        }
        return allBook;
    }
}
