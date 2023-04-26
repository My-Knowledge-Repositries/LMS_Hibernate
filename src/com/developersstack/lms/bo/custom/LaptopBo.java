package com.developersstack.lms.bo.custom;

import com.developersstack.lms.dto.CreateLaptopDto;

import java.sql.SQLException;

public interface LaptopBo {
    public void saveLaptop(CreateLaptopDto dto) throws SQLException, ClassNotFoundException;
}
