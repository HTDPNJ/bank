package com.hfut.test;

import com.hfut.pojo.People;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws IOException {
      // selbyid(); //按条件查询
      //  selPage();//测试分页查询
        insert();  //插入数据
    }
    public static void selbyid() throws IOException {
        InputStream is= Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
        SqlSession session=factory.openSession();
        People p=session.selectOne("a.b.selById",2);
        System.out.println(p.toString());

        Map<String,Object> map=new HashMap<>();
        map.put("id",1);
        map.put("name","张三");
        p=session.selectOne("a.b.selByIdandName",map);
        System.out.println(p.toString());
        session.close();

    }
    public static void selPage() throws IOException {
        InputStream is= Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
        SqlSession session=factory.openSession();
        int pageSize=2;
        int pageNumber=1;
        Map<String,Object> map=new HashMap<>();
        map.put("pageSize",pageSize);
        map.put("pageStart",pageSize*(pageNumber-1));
        List<People> list=session.selectList("a.b.page",map);
        for(People tem:list){
            System.out.println(tem.toString());
        }
    }

    public static void insert() throws IOException {
        InputStream is= Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
        SqlSession session=factory.openSession();
        People p=new People();
        p.setName("新增name");
        p.setAge(88);
        try {
            int index=session.insert("a.b.ins",p);
            if(index>0){
                System.out.println("插入成功");
            }else{
                System.out.println("插入失败");
            }
        }catch (Exception e){
            session.rollback();
        }
        session.commit();
        session.close();
    }
}
