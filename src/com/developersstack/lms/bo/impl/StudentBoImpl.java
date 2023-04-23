package com.developersstack.lms.bo.impl;

import com.developersstack.lms.bo.custom.StudentBo;
import com.developersstack.lms.dao.DaoFactory;
import com.developersstack.lms.dao.custom.StudentDao;
import com.developersstack.lms.dto.StudentDto;
import com.developersstack.lms.entity.Student;

import java.sql.SQLException;

public class StudentBoImpl implements StudentBo {
    private final StudentDao studentDao= DaoFactory.getInstance().getDao(DaoFactory.DaoType.STUDENT);

    @Override
    public void saveStudent(StudentDto dto) throws SQLException, ClassNotFoundException {
        Student student = new Student();
        student.setName(dto.getName());
        student.setContact(dto.getContact());
        studentDao.save(student);
    }
}
