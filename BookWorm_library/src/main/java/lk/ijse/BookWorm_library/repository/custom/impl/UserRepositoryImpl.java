package lk.ijse.BookWorm_library.repository.custom.impl;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lk.ijse.BookWorm_library.entity.Books;
import lk.ijse.BookWorm_library.entity.Branchs;
import lk.ijse.BookWorm_library.entity.User;
import lk.ijse.BookWorm_library.repository.custom.UserRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private Session session;
    @Override
    public String save(User user) {
        return (String) session.save(user);
    }

    @Override
    public User get(String Id) {
        return null;
    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public void update(User entity) {

    }

    @Override
    public User getEntity(String branchId) {
        return null;
    }

    @Override
    public List<String> getAllId() {
        String sql = "SELECT userId FROM User";
        Query query = session.createQuery(sql);
        List list = query.list();
        session.close();
        return list;
    }

    @Override
    public List<Branchs> getAll() {
        return null;
    }

    @Override
    public void setSession(Session session) {
        this.session =session;

    }

    @Override
    public boolean verifyUser(String name, String password) {
        Query<User> query = session.createQuery("FROM User WHERE userName = :name AND userPassword = :password", User.class);
        query.setParameter("name", name);
        query.setParameter("password", password);

        User user = query.uniqueResult();

        return user != null;

    }

    @Override
    public String checkAccount(String userName, String password) {
        Query<User> query = session.createQuery("FROM User WHERE userName = :name AND userPassword = :password", User.class);
        query.setParameter("name", userName);
        query.setParameter("password", password);

        User user = query.uniqueResult();



        // If the user is verified, return the user ID, otherwise return null
        return (user != null) ? user.getUserId() : null;
    }

    @Override
    public List<Books> getAllJPQLBooks(String branchSelect, String categorySelect) {
        String sql = "SELECT C FROM Books AS C WHERE bookBranch = :branch AND bookGenre = :category";

        Query query = session.createQuery(sql);
        query.setParameter("branch", branchSelect);
        query.setParameter("category", categorySelect);

        List<Books> resultList = query.getResultList();

        session.close();
        return resultList;
    }
}
