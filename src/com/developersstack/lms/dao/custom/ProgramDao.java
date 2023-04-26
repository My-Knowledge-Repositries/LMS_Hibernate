package com.developersstack.lms.dao.custom;

import com.developersstack.lms.dao.CrudDao;
import com.developersstack.lms.entity.Program;


import java.util.List;

public interface ProgramDao extends CrudDao<Program, Long> {
    public List<Long> findAllProgramIds();
}

