package io.oicp.yorick61c.service.impl;

import com.github.pagehelper.PageHelper;
import io.oicp.yorick61c.domain.EbUser;
import io.oicp.yorick61c.domain.PageBean;
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

    @Override
    public PageBean<EbUser> findUserByPage(Integer currentPage, Integer rows) throws IOException {
        PageHelper.startPage(currentPage,rows);
        PageBean<EbUser> ebUserPageBean = new PageBean<>();
        ebUserPageBean.setCurrentPage(currentPage);
        ebUserPageBean.setRows(rows);
        ebUserPageBean.setItems(mapper.findAll());
        int totalItems = mapper.countUser();
        ebUserPageBean.setTotalItems(totalItems);
        int totalPages = totalItems % rows == 0 ? totalItems/rows : (totalItems/rows) + 1;
        ebUserPageBean.setTotalPages(totalPages);

        return ebUserPageBean;
    }

    @Override
    public void deleteUserById(String id) {
        mapper.deleteUserById(id);
    }

    @Override
    public void updateUser(EbUser user) {
        mapper.updateUserById(user);
    }

    @Override
    public EbUser findUserById(String userId) {
        EbUser user = new EbUser();
        user.setEuUserId(userId);
        return mapper.findUser(user);
    }
}
