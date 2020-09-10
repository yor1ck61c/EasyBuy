package io.oicp.yorick61c.service.impl;

import io.oicp.yorick61c.domain.EbUser;
import io.oicp.yorick61c.mapper.UserMapper;
import io.oicp.yorick61c.service.UserService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("UserService")
public class UserServiceImpl implements UserService {


    @Resource(name = "userMapper")
    private UserMapper userMapper;

    @Override
    public void register(EbUser user) {
        userMapper.register(user);
    }
}
