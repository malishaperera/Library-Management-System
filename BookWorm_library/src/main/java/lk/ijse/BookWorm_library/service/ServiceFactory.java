package lk.ijse.BookWorm_library.service;

import lk.ijse.BookWorm_library.service.custom.impl.BookServiceImpl;
import lk.ijse.BookWorm_library.service.custom.impl.BranchServiceImpl;
import lk.ijse.BookWorm_library.service.custom.impl.UserServiceImpl;

public class ServiceFactory {

    private static ServiceFactory serviceFactory;


    public ServiceFactory() {
    }

    public static ServiceFactory getBoFactory(){
        return (serviceFactory == null)? new ServiceFactory():serviceFactory;
    }

    public enum ServiceTypes{
        Book,Branch,User
    }

    public SuperService getService(ServiceTypes serviceTypes){
        switch (serviceTypes){

            case Book:
                return new BookServiceImpl();

            case Branch:
                return new BranchServiceImpl();

            case User:
                return new UserServiceImpl();



            default:
                return null;
        }
    }
}
