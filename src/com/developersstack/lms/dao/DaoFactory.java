package com.developersstack.lms.dao;

import com.developersstack.lms.dao.custom.impl.LaptopDaoImpl;
import com.developersstack.lms.dao.custom.impl.ProgramDaoImpl;
import com.developersstack.lms.dao.custom.impl.StudentDaoImpl;

public class DaoFactory {
    private static DaoFactory daoFactory;
    private DaoFactory(){}

    public enum DaoType{
        BOOK,STUDENT,PROGRAM,LAPTOP
    }

    public static DaoFactory getInstance(){
        return daoFactory==null?daoFactory= new DaoFactory():daoFactory;
    }

    public <T> T getDao(DaoType type){
        switch (type){
            case STUDENT:
                return (T) new StudentDaoImpl();
            case BOOK:
                return null;
            case LAPTOP:
                return (T) new LaptopDaoImpl();
            case PROGRAM:
                return (T) new ProgramDaoImpl();
            default:
                return null;
        }
    }

}
