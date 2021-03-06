package io.oicp.yorick61c.test;

import com.github.pagehelper.PageHelper;
import io.oicp.yorick61c.domain.EbOrderDetail;
import io.oicp.yorick61c.domain.EbProductCategory;
import io.oicp.yorick61c.domain.EbUser;
import io.oicp.yorick61c.mapper.OrderDetailMapper;
import io.oicp.yorick61c.mapper.ProductCategoryMapper;
import io.oicp.yorick61c.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
//导入spring的配置文件
@ContextConfiguration("classpath:spring-mvc.xml")
public class TestConnection {

    @Resource(name = "userMapper")
    private UserMapper userMapper;

    @Resource(name = "orderDetailMapper")
    private OrderDetailMapper orderDetailMapper;

    @Resource(name = "productCategoryMapper")
    private ProductCategoryMapper productCategoryMapper;

    /*SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
    UserMapper mapper = sessionFactory.openSession(true).getMapper(UserMapper.class);*/

    public TestConnection() throws IOException {
    }


    @Test
    public void test4() throws IOException {
        PageHelper.startPage(1,1);
        List<EbUser> all = userMapper.findAll();
        EbUser user = all.get(0);

        EbUser user1 = userMapper.findUser(user);

        System.out.println(user1.toString());
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
        userMapper.deleteUserById("test4");
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
