package com.developersstack.lms.dao.custom;

import com.developersstack.lms.dao.CrudDao;
import com.developersstack.lms.entity.Laptop;

public interface LaptopDao extends CrudDao<Laptop, Long> {
    public void saveLaptopWithStudentId(long studentId, Laptop laptop);
}
