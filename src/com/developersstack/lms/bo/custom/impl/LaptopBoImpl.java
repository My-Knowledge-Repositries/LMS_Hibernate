package com.developersstack.lms.bo.custom.impl;

import com.developersstack.lms.bo.custom.LaptopBo;
import com.developersstack.lms.dao.DaoFactory;
import com.developersstack.lms.dao.custom.LaptopDao;
import com.developersstack.lms.dto.CreateLaptopDto;
import com.developersstack.lms.entity.Laptop;

import java.sql.SQLException;

public class LaptopBoImpl implements LaptopBo {
    LaptopDao laptopDao = DaoFactory.getInstance().getDao(DaoFactory.DaoType.LAPTOP);
    @Override
    public void saveLaptop(CreateLaptopDto dto) throws SQLException, ClassNotFoundException {
        Laptop laptop = new Laptop();
        laptop.setBrand(dto.getBrand());
        laptopDao.saveLaptopWithStudentId(dto.getStudentId(), laptop);
    }
}
