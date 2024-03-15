package lk.ijse.BookWorm_library.repository;

import org.hibernate.Session;

public interface SuperRepository {
    void setSession(Session session);
    //mekata Session set karala
    //meka crud save,delete a crud repoisto intref face akata extend katala
}
