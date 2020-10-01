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
        /*
        * 使用PageHelper插件来实现更加便捷的limit条件查询。参数1：起始页数 参数2：查询行数
        * 使用方法：1.首先在mybatis的配置文件中加入PageHelper插件，并在pom.xml中引入对应坐标
        * 2.在查询前调用静态方法startPage设置好查询条件
        * 3.进行数据查询
        */
        PageBean<EbUser> ebUserPageBean = new PageBean<>();
        ebUserPageBean.setCurrentPage(currentPage);
        //设置当前页数
        ebUserPageBean.setRows(rows);
        //设置查询行数
        ebUserPageBean.setItems(mapper.findAll());
        //调用dao层中的方法进行数据查询
        int totalItems = mapper.countUser();
        ebUserPageBean.setTotalItems(totalItems);
        //获取总个数
        int totalPages = totalItems % rows == 0 ? totalItems/rows : (totalItems/rows) + 1;
        ebUserPageBean.setTotalPages(totalPages);
        //获取总页数
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
