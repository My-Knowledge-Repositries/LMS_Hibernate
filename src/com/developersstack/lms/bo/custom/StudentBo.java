package com.developersstack.lms.bo.custom;

import com.developersstack.lms.dto.StudentDto;

import java.sql.SQLException;

public interface StudentBo {
    public void saveStudent(StudentDto dto) throws SQLException, ClassNotFoundException;
}
