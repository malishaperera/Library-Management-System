package lk.ijse.BookWorm_library.service.custom.impl;

import lk.ijse.BookWorm_library.dto.BookDTO;
import lk.ijse.BookWorm_library.dto.BranchDTO;
import lk.ijse.BookWorm_library.entity.Branchs;
import lk.ijse.BookWorm_library.repository.RepositoryFactory;
import lk.ijse.BookWorm_library.repository.custom.BranchRepository;
import lk.ijse.BookWorm_library.service.custom.BranchService;
import lk.ijse.BookWorm_library.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BranchServiceImpl implements BranchService {

    BranchRepository branchRepository = (BranchRepository) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryTypes.Branch);

    private Session session;


    @Override
    public String saveBranch(BranchDTO branchDTO) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();

        try {
            branchRepository.setSession(session);
            branchRepository.save(new Branchs(branchDTO.getBranchId(), branchDTO.getBranchLocation(), branchDTO.getBranchOpenTime(), branchDTO.getBranchCloseTime(), branchDTO.getBranchContact()));
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
    public List<String> getBranchId() {
        session =SessionFactoryConfig.getInstance()
                .getSession();

        branchRepository.setSession(session);
        List<String> allBranchId = branchRepository.getAllId();


        return allBranchId;
    }

    @Override
    public BranchDTO getBranch(String branchId) {
        try {
            session = SessionFactoryConfig.getInstance()
                    .getSession();
            branchRepository.setSession(session);
            Branchs branchs = branchRepository.get(branchId);
            session.close();
            return branchs.toDto();

        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }

    }

    @Override
    public boolean deleteBranch(BranchDTO existingBranch) {
        session = SessionFactoryConfig.getInstance()
                .getSession();

        Transaction transaction =session.beginTransaction();
        try {
            branchRepository.setSession(session);
            branchRepository.delete(existingBranch.toEntity());
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
    public List<Branchs> getAllBranches() {
        session = SessionFactoryConfig.getInstance()
                .getSession();

        branchRepository.setSession(session);
        List<Branchs> branch = branchRepository.getAll();
        session.close();
        return branch;

    }

    @Override
    public boolean updateBranch(BranchDTO branchDTO1) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();

        try {
            branchRepository.setSession(session);
            branchRepository.update(branchDTO1.toEntity());
            transaction.commit();
            return true;

        }catch (Exception e){
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }
    }
}
