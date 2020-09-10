package io.oicp.yorick61c.service.impl;

import io.oicp.yorick61c.domain.EbUser;
import io.oicp.yorick61c.mapper.UserMapper;
import io.oicp.yorick61c.service.UserService;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service("UserService")
public class UserServiceImpl implements UserService {

    SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
    UserMapper mapper = sessionFactory.openSession(true).getMapper(UserMapper.class);

    public UserServiceImpl() throws IOException {
    }


    @Override
    public void register(EbUser user) throws IOException {
        mapper.register(user);
    }
}
