package com.developersstack.lms.bo.custom.impl;

import com.developersstack.lms.bo.custom.StudentBo;
import com.developersstack.lms.dao.DaoFactory;
import com.developersstack.lms.dao.custom.StudentDao;
import com.developersstack.lms.dto.StudentDto;
import com.developersstack.lms.entity.Student;
import javassist.NotFoundException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentBoImpl implements StudentBo {
    private final StudentDao studentDao = DaoFactory.getInstance().getDao(DaoFactory.DaoType.STUDENT);

    @Override
    public void saveStudent(StudentDto dto) throws SQLException, ClassNotFoundException {
        Student student = new Student();
        student.setName(dto.getName());
        student.setContact(dto.getContact());
        studentDao.save(student);
    }

    @Override
    public List<StudentDto> findAll() throws SQLException, ClassNotFoundException {
        ArrayList<StudentDto> dtos = new ArrayList<>();
        for (Student s : studentDao.findAll()) {
            StudentDto studentDto = new StudentDto(s.getId(), s.getName(), s.getContact());
            studentDto.setBooks(s.getBooks());
            studentDto.setLaptop(s.getLaptop());
            dtos.add(studentDto);
        }
        return dtos;
    }

    @Override
    public void deleteStudentById(long id) throws SQLException, ClassNotFoundException {
        studentDao.delete(id);
    }

    @Override
    public void updateStudent(StudentDto dto) throws SQLException, ClassNotFoundException, NotFoundException {
        Student student = new Student();
        student.setId(dto.getId());
        student.setName(dto.getName());
        student.setContact(dto.getContact());
        studentDao.update(student);
    }
}
