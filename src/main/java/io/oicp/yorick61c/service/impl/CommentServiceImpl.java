package io.oicp.yorick61c.service.impl;

import com.github.pagehelper.PageHelper;
import io.oicp.yorick61c.domain.EbComment;
import io.oicp.yorick61c.domain.PageBean;
import io.oicp.yorick61c.mapper.CommentMapper;
import io.oicp.yorick61c.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Resource(name = "commentMapper")
    private CommentMapper commentMapper;

    @Override
    public PageBean<EbComment> findCommentByPage(Integer currentPage, Integer row) {
        PageBean<EbComment> ebCommentPageBean = new PageBean<>();
        ebCommentPageBean.setCurrentPage(currentPage);
        ebCommentPageBean.setRows(3);
        PageHelper.startPage(currentPage,row);
        ebCommentPageBean.setItems(commentMapper.findAll());
        int countComments = commentMapper.countComments();
        ebCommentPageBean.setTotalItems(countComments);
        int totalPages = countComments % row == 0 ? countComments/row : (countComments/row) + 1;
        ebCommentPageBean.setTotalPages(totalPages);
        return ebCommentPageBean;
    }

    @Override
    public void saveComment(EbComment comment) {
        commentMapper.insert(comment);
    }

    @Override
    public void delete(Integer ecId) {
        EbComment ebComment = new EbComment();
        ebComment.setEcId(ecId);
        commentMapper.delete(ebComment);
    }

    @Override
    public EbComment findCommentById(Integer ecId) {
        EbComment ebComment = new EbComment();
        ebComment.setEcId(ecId);
        return commentMapper.findEbComment(ebComment);
    }

    @Override
    public void updateComment(EbComment ebComment) {
        commentMapper.update(ebComment);
    }
}
