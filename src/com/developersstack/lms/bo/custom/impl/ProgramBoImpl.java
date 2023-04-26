package com.developersstack.lms.bo.custom.impl;

import com.developersstack.lms.bo.custom.ProgramBo;
import com.developersstack.lms.dao.DaoFactory;
import com.developersstack.lms.dao.custom.ProgramDao;
import com.developersstack.lms.dto.ProgramDto;
import com.developersstack.lms.entity.Program;
import java.sql.SQLException;
import java.util.List;

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

    @Override
    public List<Long> findAllStudentIds() {
        return programDao.findAllProgramIds();
    }

}
