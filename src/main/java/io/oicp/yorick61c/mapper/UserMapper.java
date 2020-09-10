package io.oicp.yorick61c.mapper;

import io.oicp.yorick61c.domain.EbUser;

import java.io.IOException;
import java.util.List;


public interface UserMapper {

    void register(EbUser user);

    List<EbUser> findAll() throws IOException;
}
