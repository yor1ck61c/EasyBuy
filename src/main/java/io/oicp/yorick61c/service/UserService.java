package io.oicp.yorick61c.service;

import io.oicp.yorick61c.domain.EbUser;

import java.io.IOException;
import java.util.List;

public interface UserService {


    void register(EbUser user) throws IOException;

    EbUser loginCheck(EbUser user);

    List<EbUser> findAll() throws IOException;
}
