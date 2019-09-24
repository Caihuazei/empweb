package com.liu.service;

import com.liu.entity.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> listemp();

    void addEmp(Emp emp);

    int deleteEmpById(Integer id);

    //获取删除元素所有信息
    Emp getEmpById(Integer id);

    int updateEmp(Emp emp);

}
