package lk.ijse.BookWorm_library.repository.custom;

import lk.ijse.BookWorm_library.entity.Books;
import lk.ijse.BookWorm_library.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Books, String> {


    List<Books> getAllJPQLBooks(String branchSelect,String categorySelect);
}
