package com.liu.until;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUntils {

    private static final SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(
            MyBatisUntils.class.getClassLoader().getResourceAsStream("mybatis.xml"));

    public static SqlSession getSqlSession(boolean a) {
        return factory.openSession(a);
    }

    public static SqlSession getSqlSession() {
        return factory.openSession(true);
    }
}
