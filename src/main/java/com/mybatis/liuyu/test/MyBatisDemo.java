package com.mybatis.liuyu.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Create by liu·yu
 * Date is 2020-06-11
 * Description is :
 */
public class MyBatisDemo {

    public static void main(String[] args) throws IOException {
        InputStream resource = Resources.getResourceAsStream("mybatis/config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);

        //step one: cache id 1 into L2
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BasicMapper mapper = sqlSession.getMapper(BasicMapper.class);
        mapper.queryName(1);
        sqlSession.commit();
        sqlSession.close();

        //step two: flush cache but not commit
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(BasicMapper.class);
        mapper.updateName(1);

        //step three: query id 1.
        //because i have flush cache,so i except no cache hit but actually it still log hit.
        mapper.queryName(1);
        sqlSession.commit();
        sqlSession.close();

    }

}
