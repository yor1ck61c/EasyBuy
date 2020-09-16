package io.oicp.yorick61c.mapper;

import io.oicp.yorick61c.domain.EbComment;

import java.util.List;

public interface CommentMapper {

    EbComment findEbComment(EbComment ebComment);

    List<EbComment> findAll();



}
