package com.hfut.test;

import com.hfut.pojo.Flower;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws IOException {
        //使用工厂设计模式
        InputStream is=Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
        //生产sqlsession
        SqlSession session=factory.openSession();
        List<Flower> list=session.selectList("com.hfut.selAll");
        for(Flower flower:list){
            System.out.println(flower.toString());
        }

        //第二种查询方式
        int count=session.selectOne("com.hfut.selById");
        System.out.println(count);

        //第三种查询方式
        Map<Object,Object>map=session.selectMap("com.hfut.c","name");
        System.out.println(map);
        session.close();
    }
}
