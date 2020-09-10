package io.oicp.yorick61c.test;

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

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
public class TestConnection {

    @Resource(name = "userMapper")
    private UserMapper userMapper;


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

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
        UserMapper mapper = sessionFactory.openSession(true).getMapper(UserMapper.class);

        List<EbUser> all = mapper.findAll();
        System.out.println(all);
        /*System.out.println(userMapper);*/
        /*List<EbUser> all = userMapper.findAll();
        System.out.println(all);*/
    }
}
