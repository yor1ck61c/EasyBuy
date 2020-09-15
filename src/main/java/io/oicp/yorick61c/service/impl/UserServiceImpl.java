package io.oicp.yorick61c.service.impl;

import io.oicp.yorick61c.domain.EbUser;
import io.oicp.yorick61c.mapper.UserMapper;
import io.oicp.yorick61c.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Resource(name = "userMapper")
    private UserMapper mapper;

    public UserServiceImpl() throws IOException {
    }


    @Override
    public void register(EbUser user) throws IOException {
        mapper.insert(user);
    }

    @Override
    public EbUser loginCheck(EbUser user) {
        return mapper.findUser(user);
    }

    @Override
    public List<EbUser> findAll() throws IOException {
        return mapper.findAll();
    }
}
