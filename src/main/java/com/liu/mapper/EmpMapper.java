package com.liu.mapper;

import com.liu.entity.Emp;

import java.util.List;

public interface EmpMapper {

    List<Emp> listemp();

    void addEmp(Emp emp);

    int deleteEmpById(Integer id);

    Emp getEmpById(Integer id);

    int updateEmp(Emp emp);

}
