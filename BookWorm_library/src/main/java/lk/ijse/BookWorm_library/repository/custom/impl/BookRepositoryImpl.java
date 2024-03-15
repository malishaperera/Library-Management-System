package lk.ijse.BookWorm_library.repository.custom.impl;

import lk.ijse.BookWorm_library.dto.BranchDTO;
import lk.ijse.BookWorm_library.entity.Books;
import lk.ijse.BookWorm_library.entity.Branchs;
import lk.ijse.BookWorm_library.repository.custom.BookRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {

    private Session session;


    @Override
    public String save(Books books) {
       return (String) session.save(books);
    }

    @Override
    public Books get(String Id) {
        return session.get(Books.class,Id);
    }

    /*@Override
    public Books get(long bookId) {
        return session.get(Books.class, bookId);
    }*/

    @Override
    public void delete(Books book) {
        session.delete(book);
    }

    @Override
    public void update(Books book) {
        session.update(book);
    }

    @Override
    public Books getEntity(String branchId) {
        return null;
    }

    @Override
    public List<String> getAllId() {
        String sql = "SELECT bookId FROM Books ";
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
        this.session = session;
    }

    @Override
    public List<Books> getAllJPQLBooks(String branchSelect ,String categorySelect) {

        String sql = "SELECT C FROM Books AS C WHERE bookBranch = :branch AND bookGenre = :category";

        Query query = session.createQuery(sql);
        query.setParameter("branch", branchSelect);
        query.setParameter("category", categorySelect);

        List<Books> resultList = query.getResultList();

        session.close();
        return resultList;

    }
}
