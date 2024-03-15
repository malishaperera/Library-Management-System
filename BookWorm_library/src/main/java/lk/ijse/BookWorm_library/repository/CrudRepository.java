package lk.ijse.BookWorm_library.repository;

import lk.ijse.BookWorm_library.dto.BookDTO;
import lk.ijse.BookWorm_library.dto.BranchDTO;
import lk.ijse.BookWorm_library.entity.Books;
import lk.ijse.BookWorm_library.entity.Branchs;

import java.util.ArrayList;
import java.util.List;

public interface CrudRepository <T,ID> extends SuperRepository{

    ID save(T object);


    T get(String Id);

    void delete(T entity);

    void update(T entity);

    T getEntity(String branchId);

    List<String> getAllId();

    List<Branchs> getAll();



    /*List<String> getAllBranchId();*/
}
