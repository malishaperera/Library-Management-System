package lk.ijse.BookWorm_library.repository.custom.impl;

import lk.ijse.BookWorm_library.dto.BranchDTO;
import lk.ijse.BookWorm_library.entity.Books;
import lk.ijse.BookWorm_library.entity.Branchs;
import lk.ijse.BookWorm_library.repository.custom.BranchRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class BranchRepositoryImpl implements BranchRepository {

    private Session session;


    @Override
    public String save(Branchs branchs) {
     return (String) session.save(branchs);
    }

    @Override
    public Branchs get(String branchId) {
        return session.get(Branchs.class,branchId);
    }

    @Override
    public void delete(Branchs entity) {
        session.delete(entity);

    }

    @Override
    public void update(Branchs branchs) {
        session.update(branchs);

    }

    @Override
    public Branchs getEntity(String branchId) {
        return session.get(Branchs.class,branchId);
    }


    @Override
    public void setSession(Session session) {
        this.session = session;

    }

    @Override
    public List<String> getAllId() {
        String sql = "SELECT branchId FROM Branchs";
        Query query = session.createQuery(sql);
        List list = query.list();
        session.close();
        return list;
    }

    @Override
    public List<Branchs> getAll() {
        String sql = "SELECT B FROM Branchs AS B";
        Query query = session.createQuery(sql);
        List<Branchs> list = query.list();
        session.close();
        return list;

    }
}
//SELECT branchId,branchLocation,branchOpenTime,branchCloseTime,branchContact FROM Branchs