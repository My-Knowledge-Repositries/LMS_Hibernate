package com.developersstack.lms.bo.custom;

import com.developersstack.lms.dto.StudentDto;
import javassist.NotFoundException;

import java.sql.SQLException;
import java.util.List;

public interface StudentBo {
    void saveStudent(StudentDto dto) throws SQLException, ClassNotFoundException;

    List<StudentDto> findAll() throws SQLException, ClassNotFoundException;

    void deleteStudentById(long id) throws SQLException, ClassNotFoundException;
    void updateStudent(StudentDto dto) throws SQLException, ClassNotFoundException, NotFoundException;
}
