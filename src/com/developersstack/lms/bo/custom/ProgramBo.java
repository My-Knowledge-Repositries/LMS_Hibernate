package com.developersstack.lms.bo.custom;

import com.developersstack.lms.dto.ProgramDto;

import java.sql.SQLException;
import java.util.List;

public interface ProgramBo {
    public void saveProgram(ProgramDto dto) throws SQLException, ClassNotFoundException;

    List<Long> findAllStudentIds();
}

