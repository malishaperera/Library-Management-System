package lk.ijse.BookWorm_library.entity.id;

import lk.ijse.BookWorm_library.service.ServiceFactory;
import lk.ijse.BookWorm_library.service.custom.BookService;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BookIdGenerator implements IdentifierGenerator {

    BookService bookService = (BookService) ServiceFactory.getBoFactory().getService(ServiceFactory.ServiceTypes.Book);

    private static final String PREFIX = "BO";
    private static final AtomicInteger count = new AtomicInteger(1);



    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {

        List<String> existingIds = checkBookID();
        String generatedId;

        // Generate a new ID until it's not found in the existing IDs
        do {
            generatedId = String.format("%s%03d", PREFIX, count.getAndIncrement());
        } while (existingIds.contains(generatedId));

        return generatedId;
    }
    private List<String> checkBookID() {
        List<String> bookId = bookService.getBookId();
        System.out.println("currently  " +bookId);
        return bookId;
    }
}



// List<String> branchId = branchService.getBranchId();
//        System.out.println("currently  " +branchId);
//        return branchId;