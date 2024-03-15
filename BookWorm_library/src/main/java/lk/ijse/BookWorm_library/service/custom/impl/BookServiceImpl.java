package lk.ijse.BookWorm_library.service.custom.impl;

import lk.ijse.BookWorm_library.dto.BookDTO;
import lk.ijse.BookWorm_library.entity.Books;
import lk.ijse.BookWorm_library.repository.RepositoryFactory;
import lk.ijse.BookWorm_library.repository.custom.BookRepository;
import lk.ijse.BookWorm_library.service.custom.BookService;
import lk.ijse.BookWorm_library.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {

    BookRepository bookRepository = (BookRepository) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryTypes.Book);

    private Session session;


    @Override
    public String saveBook(BookDTO bookDTO) {


        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {

            bookRepository.setSession(session);

         bookRepository.save(new Books(bookDTO.getBookId(), bookDTO.getBookTitle(), bookDTO.getBookAuthor(), bookDTO.getBookQty(), bookDTO.getBookBranch(), bookDTO.getBookGenre() , bookDTO.getBookImg()));
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
    public List<Books> getAllJPQLBooks(String branchSelect , String categorySelect) {
        session =SessionFactoryConfig.getInstance()
                .getSession();

        bookRepository.setSession(session);

        List<Books> allJPQLBooks = bookRepository.getAllJPQLBooks(branchSelect,categorySelect);
        List<Books> allBook = new ArrayList<>();
        for (Books books :allJPQLBooks){
            allBook.add(books);

        }
        return allBook;
    }

    @Override
    public BookDTO getBook(String bookId) {

        try {
            session = SessionFactoryConfig.getInstance()
                    .getSession();
            bookRepository.setSession(session);
            Books books = bookRepository.get(bookId);
            session.close();
            return books.toDto();
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public boolean deleteBook(BookDTO bookDTO) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();

        try {
            bookRepository.setSession(session);
            bookRepository.delete(bookDTO.toEntity());
            transaction.commit();
            session.close();
            return true;

        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            session.close();
            return false;

        }
    }

    @Override
    public boolean updateBook(BookDTO bookDTO) {
       session = SessionFactoryConfig.getInstance()
               .getSession();
       Transaction transaction = session.beginTransaction();
       try {
           bookRepository.setSession(session);
           bookRepository.update(bookDTO.toEntity());
           transaction.commit();
           session.close();
           return true;
       }catch (Exception e){
           transaction.rollback();
           session.close();
           e.printStackTrace();
           return false;
       }
    }

    @Override
    public List<String> getBookId() {
        session =SessionFactoryConfig.getInstance()
                .getSession();
       // Transaction transaction = session.beginTransaction();
        bookRepository.setSession(session);
        List<String> allBookId = bookRepository.getAllId();
        return allBookId;

    }
}
