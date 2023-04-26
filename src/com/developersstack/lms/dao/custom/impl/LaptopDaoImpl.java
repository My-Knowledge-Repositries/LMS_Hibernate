package com.developersstack.lms.dao.custom.impl;

import com.developersstack.lms.dao.custom.LaptopDao;
import com.developersstack.lms.entity.Laptop;
import com.developersstack.lms.entity.Student;
import com.developersstack.lms.util.HibernateUtil;
import javassist.NotFoundException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class LaptopDaoImpl implements LaptopDao {

    @Override
    public void save(Laptop laptop) throws SQLException, ClassNotFoundException {

    }

    @Override
    public void update(Laptop laptop) throws SQLException, ClassNotFoundException, NotFoundException {

    }

    @Override
    public Laptop find(Long aLong) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public void delete(Long aLong) throws SQLException, ClassNotFoundException {

    }

    @Override
    public List<Laptop> findAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public void saveLaptopWithStudentId(long studentId, Laptop laptop) {
        try(Session session= HibernateUtil.getInstance().openSession()){
            session.beginTransaction();
            Query<Student> query =
                    session.createQuery("FROM Student WHERE student_id=:sId", Student.class);
            query.setParameter("sId",studentId);
            Student student = query.uniqueResult();
            if (student==null){
                throw new RuntimeException("Student not found");
            }

            laptop.setStudent(student);
            session.save(laptop);
            session.getTransaction().commit();
        }
    }
}
