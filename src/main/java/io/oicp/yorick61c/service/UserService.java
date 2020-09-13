package io.oicp.yorick61c.service;

import io.oicp.yorick61c.domain.EbUser;

import java.io.IOException;

public interface UserService {


    void register(EbUser user) throws IOException;

    EbUser loginCheck(EbUser user);
}
