package io.oicp.yorick61c.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.oicp.yorick61c.domain.EbUser;
import io.oicp.yorick61c.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
//导入spring的配置文件
@ContextConfiguration("classpath:spring-mvc.xml")
public class TestConnection {

    @Resource(name = "userMapper")
    private UserMapper userMapper;

    /*SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
    UserMapper mapper = sessionFactory.openSession(true).getMapper(UserMapper.class);*/

    public TestConnection() throws IOException {
    }


    @Test
    public void test4() throws IOException {
        List<EbUser> all = userMapper.findAll();
        System.out.println(all+"qq");
    }


    @Test
    public void test1(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate template = (JdbcTemplate) app.getBean("template");
        String sql = "select * from eb_user";

        List<EbUser> query = template.query(sql, new BeanPropertyRowMapper<EbUser>(EbUser.class));
        System.out.println(query);
    }
    @Test
    public void test2() throws IOException {



        EbUser ebUser = new EbUser();
        ebUser.setEuUserId("test5");
        ebUser.setEuUserName("吴彦祖");
        ebUser.setEuSex("T");
        ebUser.setEuPassword("test123");
        ebUser.setEuAddress("test地址");
        userMapper.register(ebUser);
        /*System.out.println(userMapper);*/
        /*List<EbUser> all = userMapper.findAll();
        System.out.println(all);*/
    }

    @Test
    public void test3(){
        EbUser userByUP = userMapper.findUserByUP("qwe", "qwe");
        System.out.println(userByUP);
    }

    @Test
    public void test5() throws IOException {
        PageHelper.startPage(1,5);

        List<EbUser> users = userMapper.findAll();

        for (EbUser user: users) {
            System.out.println(user.toString());
        }

    }
}
