package lk.ijse.BookWorm_library.TM;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BranchTM {
    String  branchId;
    String branchLocation;
    String branchOpenTime;
    String branchCloseTime;
    String branchContact;
}
