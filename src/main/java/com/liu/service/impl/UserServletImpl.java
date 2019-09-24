package com.liu.service.impl;

import com.liu.entity.User;
import com.liu.mapper.UserMapper;
import com.liu.service.UserService;
import com.liu.until.MyBatisUntils;
import org.apache.ibatis.session.SqlSession;

public class UserServletImpl implements UserService {
    @Override
    public User listUserByName(String name) {
        SqlSession sqlSession = MyBatisUntils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.listUserByName(name);
        sqlSession.close();
        return user;
    }
}
