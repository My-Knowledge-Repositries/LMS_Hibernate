package com.developersstack.lms.bo.custom.impl;

import com.developersstack.lms.bo.custom.ProgramBo;
import lk.developersstack.lms.dao.DaoFactory;
import lk.developersstack.lms.dao.custom.ProgramDao;
import lk.developersstack.lms.dto.ProgramDto;
import lk.developersstack.lms.entity.Program;

import java.sql.SQLException;

public class ProgramBoImpl implements ProgramBo {
    private final ProgramDao programDao = DaoFactory.getInstance().getDao(DaoFactory.DaoType.PROGRAM);
    @Override
    public void saveProgram(ProgramDto dto) throws SQLException, ClassNotFoundException {
        // MapStruct, model mapper
        Program program = new Program();
        program.setTitle(dto.getTitle());
        program.setCredit(dto.getCredit());
        programDao.save(program);
    }
}
