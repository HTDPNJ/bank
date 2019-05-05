package hfut;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class TestMyBatis
{
    public static void main(String[] args) throws IOException
    {
       // addPerson();
       // deltePersonById();
        updatePersonById();
        queryAllPerson();
    }
    //查询单个学生
    public static void queryPersonByid() throws IOException
    {
        //加载MyBatiss配置文件（为了访问数据库）
        Reader reader= Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
        SqlSession session=sessionFactory.openSession();
        String statement="hfut.personMapper.queryPersonById";
        Person person=session.selectOne(statement,2);
        System.out.println(person.toString());
        session.close();
    }

    //增加学生
    public static void addPerson() throws IOException
    {
        //加载MyBatiss配置文件（为了访问数据库）
        Reader reader= Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
        SqlSession session=sessionFactory.openSession();
        String statement="hfut.personMapper.addPerson";
        Person person=new Person(3,"zs",25);
        int count=session.insert(statement,person);
        session.commit();//提交事务
        System.out.println("增加学生数目:"+count);
        session.close();
    }
    //增加学生
    public static void deltePersonById() throws IOException
    {
        //加载MyBatiss配置文件（为了访问数据库）
        Reader reader= Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
        SqlSession session=sessionFactory.openSession();
        String statement="hfut.personMapper.deletePersonByid";
        int count=session.delete(statement,2);
        System.out.println("删除人数："+count);
        session.commit();//提交事务
        session.close();
    }

    //修改学生
    public static void updatePersonById() throws IOException
    {
        //加载MyBatiss配置文件（为了访问数据库）
        Reader reader= Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
        SqlSession session=sessionFactory.openSession();
        String statement="hfut.personMapper.updateStudentByid";

        Person person=new Person();
        person.setId(3);
        person.setName("zxs");
        person.setAge(44);
        int count=session.update(statement,person);

        System.out.println("修改人数："+count);
        session.commit();//提交事务
        session.close();
    }

    //查询全部学生
    public static void queryAllPerson() throws IOException
    {
        //加载MyBatiss配置文件（为了访问数据库）
        Reader reader= Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
        SqlSession session=sessionFactory.openSession();
        String statement="hfut.personMapper.queryAllStudents";
        List<Person> list=session.selectList(statement);
        System.out.println(list);
        session.close();
    }
}
