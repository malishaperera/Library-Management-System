package lk.ijse.BookWorm_library.repository;

import lk.ijse.BookWorm_library.repository.custom.impl.BookRepositoryImpl;
import lk.ijse.BookWorm_library.repository.custom.impl.BranchRepositoryImpl;
import lk.ijse.BookWorm_library.repository.custom.impl.UserRepositoryImpl;

public class RepositoryFactory {
    private static RepositoryFactory repositoryFactory;

    public RepositoryFactory() {
    }

    public static RepositoryFactory getRepositoryFactory(){
        return (repositoryFactory == null)?new RepositoryFactory():repositoryFactory;
    }

    public enum RepositoryTypes{
        Book,Branch,User
    }

    public SuperRepository getRepository(RepositoryTypes repositoryTypes){
        switch (repositoryTypes){
            case Book:
                return new BookRepositoryImpl();

            case Branch:
                return new BranchRepositoryImpl();
            case User:
                return new UserRepositoryImpl();

            default:
                return null;
        }
    }
}
