package com.liu.service.impl;

import com.liu.entity.Dept;
import com.liu.mapper.DeptMapper;
import com.liu.service.DeptService;
import com.liu.until.MyBatisUntils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DeptServiceImpl implements DeptService {
    @Override
    public List<Dept> listdept() {

        SqlSession sqlSession = MyBatisUntils.getSqlSession();
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        List<Dept> deptList = deptMapper.listdept();

        sqlSession.close();
        return deptList;
    }
}
