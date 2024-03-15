package lk.ijse.BookWorm_library.service.custom;

import lk.ijse.BookWorm_library.dto.BookDTO;
import lk.ijse.BookWorm_library.dto.BranchDTO;
import lk.ijse.BookWorm_library.entity.Branchs;
import lk.ijse.BookWorm_library.repository.custom.BranchRepository;
import lk.ijse.BookWorm_library.service.SuperService;

import java.util.ArrayList;
import java.util.List;

public interface BranchService extends SuperService {


    String saveBranch(BranchDTO branchDTO);

    List<String> getBranchId();

    BranchDTO getBranch(String branchId);


    boolean deleteBranch(BranchDTO existingBranch);

    List<Branchs> getAllBranches();

    boolean updateBranch(BranchDTO branchDTO1);
}
