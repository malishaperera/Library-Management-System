package lk.ijse.BookWorm_library.entity.id;

import lk.ijse.BookWorm_library.service.ServiceFactory;
import lk.ijse.BookWorm_library.service.custom.BranchService;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BranchIdGenerator implements IdentifierGenerator {


    BranchService branchService = (BranchService) ServiceFactory.getBoFactory().getService(ServiceFactory.ServiceTypes.Branch);




    private static final String PREFIX = "BR";
    private static final AtomicInteger count = new AtomicInteger(1);



    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {

        List<String> existingIds = checkBranchID();
        String generatedId;

        // Generate a new ID until it's not found in the existing IDs
        do {
            generatedId = String.format("%s%03d", PREFIX, count.getAndIncrement());
        } while (existingIds.contains(generatedId));

        return generatedId;
    }

    private List<String> checkBranchID() {
        List<String> branchId = branchService.getBranchId();
        System.out.println("currently  " +branchId);
        return branchId;
    }
}
