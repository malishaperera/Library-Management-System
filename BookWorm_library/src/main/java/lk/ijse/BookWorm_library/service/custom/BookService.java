package lk.ijse.BookWorm_library.service.custom;

import lk.ijse.BookWorm_library.dto.BookDTO;
import lk.ijse.BookWorm_library.entity.Books;
import lk.ijse.BookWorm_library.service.SuperService;

import java.util.List;

public interface BookService extends SuperService {

    String saveBook(BookDTO bookDTO);

    List<Books> getAllJPQLBooks(String branchSelect , String categorySelect);


    BookDTO getBook(String bookId);

    boolean deleteBook(BookDTO existingBook);

    boolean updateBook(BookDTO existingBook);


    List<String> getBookId();
}
