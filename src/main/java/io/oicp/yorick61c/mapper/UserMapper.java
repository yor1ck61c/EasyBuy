package io.oicp.yorick61c.mapper;

import io.oicp.yorick61c.domain.EbUser;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.List;


public interface UserMapper {

    void insert(EbUser user);

    void deleteUserById(String id);;

    List<EbUser> findAll() throws IOException;

    void updateUserById(EbUser user);

    EbUser findUser(EbUser user);
}
