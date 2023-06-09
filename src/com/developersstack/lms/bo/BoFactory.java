package com.developersstack.lms.bo;

import com.developersstack.lms.bo.custom.impl.StudentBoImpl;

public class BoFactory {
    private static BoFactory boFactory;
    private BoFactory(){}

    public enum BoType{
        BOOK,STUDENT,PROGRAM,LAPTOP
    }

    public static BoFactory getInstance(){
        return boFactory==null?boFactory= new BoFactory():boFactory;
    }

    public <T> T getBo(BoType type){
        switch (type){
            case STUDENT:
                return (T) new StudentBoImpl();
            case BOOK:
                return null;
            case LAPTOP:
                return null;
            case PROGRAM:
                return null;
            default:
                return null;
        }
    }
}
