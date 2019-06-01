package com.hfut.service.impl;

import com.hfut.pojo.People;
import com.hfut.service.PeopleService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/*
* 在数据库访问层处理异常，和在控制器中处理异常，service中只抛出异常*/
public class PeopleServiceImpl implements PeopleService {
    @Override
    public List<People> show() throws IOException {
        InputStream is=Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
        SqlSession session=factory.openSession();
        List<People>list=session.selectList("com.hfut.mapper.PeopleMapper.selAll");
        session.close();
        return list;
    }
}
