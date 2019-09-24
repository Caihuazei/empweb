package com.liu.service.impl;

import com.liu.entity.Emp;
import com.liu.mapper.EmpMapper;
import com.liu.service.EmpService;
import com.liu.until.MyBatisUntils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class EmpServiceImpl implements EmpService {
    @Override
    public List<Emp> listemp() {
        SqlSession sqlSession = MyBatisUntils.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> empList = empMapper.listemp();
        sqlSession.close();
        return empList;
    }

    @Override
    public void addEmp(Emp emp) {
        SqlSession sqlSession = MyBatisUntils.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        empMapper.addEmp(emp);
        sqlSession.close();
    }

    @Override
    public int deleteEmpById(Integer id) {
        SqlSession sqlSession = MyBatisUntils.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        int a = empMapper.deleteEmpById(id);
        sqlSession.close();
        return a;
    }

    @Override
    public Emp getEmpById(Integer id) {
        SqlSession sqlSession = MyBatisUntils.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp a = empMapper.getEmpById(id);
        sqlSession.close();
        return a;
    }

    @Override
    public int updateEmp(Emp emp) {
        SqlSession sqlSession = MyBatisUntils.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        int a = empMapper.updateEmp(emp);
        sqlSession.close();
        return a;

    }


}
