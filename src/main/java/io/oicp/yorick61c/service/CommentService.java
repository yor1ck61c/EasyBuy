package io.oicp.yorick61c.service;

import io.oicp.yorick61c.domain.EbComment;
import io.oicp.yorick61c.domain.EbProduct;
import io.oicp.yorick61c.domain.PageBean;
import org.springframework.stereotype.Service;


public interface CommentService {

    PageBean<EbComment> findCommentByPage(Integer currentPage, Integer row);

    void saveComment(EbComment comment);

    void delete(Integer ecId);

    EbComment findCommentById(Integer ecId);

    void updateComment(EbComment ebComment);
}
