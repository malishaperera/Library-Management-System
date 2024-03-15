package lk.ijse.BookWorm_library;

public class Test1 {
    public void initialize() {

       /* setTable();*/

    }

   /* private void setTable() {
        ObservableList<BooksTM> booksTMS = FXCollections.observableArrayList();
        for (BooksDTO booksDTO : booksBO.getAll()){
            booksTMS.add(new BooksTM(
                    booksDTO.getBooks_id(),
                    booksDTO.getBooks_title(),
                    booksDTO.getBooks_author(),
                    booksDTO.getBooks_genre(),
                    booksDTO.getBooks_avl(),
                    booksDTO.getBranch_id()
            ));
        }
        tblBooks.setItems(booksTMS);
    }*/


  /*  @Override
    public List<BooksDTO> getAll() {
        Session session = Configure.getInstance().getSession();
        booksDAO.setSession(session);
        List<BooksDTO>branchDTOS  = new ArrayList<>();
        for (Books books : booksDAO.getAllBo()){
            branchDTOS.add(new BooksDTO(
                    books.getBooks_id(),
                    books.getBooks_title(),
                    books.getBooks_author(),
                    books.getBooks_genre(),
                    books.getBooks_avl(),
                    books.getBranch().getBranch_id()
            ));
        }
        return branchDTOS;
    }*/

    /*@Override
    public List<Books> getAllBo() {
        Transaction transaction = session.beginTransaction();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Books> query = criteriaBuilder.createQuery(Books.class);
        query.from(Books.class);
        List<Books> resultList = session.createQuery(query).getResultList();
        transaction.commit();
        session.close();
        return resultList;
    }*/
}
