package com.developersstack.lms.bo.custom;

import com.developersstack.lms.dto.StudentDto;

import java.sql.SQLException;
import java.util.List;

public interface StudentBo {
    public void saveStudent(StudentDto dto) throws SQLException, ClassNotFoundException;
    public List<StudentDto> findAll() throws SQLException, ClassNotFoundException;
}
