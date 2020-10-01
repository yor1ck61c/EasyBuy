package io.oicp.yorick61c.controller;


import io.oicp.yorick61c.domain.EbComment;
import io.oicp.yorick61c.domain.PageBean;
import io.oicp.yorick61c.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.jws.WebParam;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Resource(name = "commentService")
    private CommentService commentService;

    @RequestMapping("/replyInfo")
    public String reply2(EbComment ebComment){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ebComment.setEcReplyTime(df.format(new Date()));
        commentService.updateComment(ebComment);
        return "redirect:/comment/list/1/5";
    }

    @RequestMapping("/reply/{ecId}")
    public ModelAndView reply(@PathVariable Integer ecId, ModelAndView modelAndView){
        modelAndView.setViewName("manage/guestbook-modify");
        modelAndView.addObject("comment",commentService.findCommentById(ecId));
        return modelAndView;
    }

    @RequestMapping("/delete/{ecId}")
    public String delete(@PathVariable Integer ecId){
        commentService.delete(ecId);
        return "redirect:/comment/list/1/5";
    }

    @RequestMapping("/save")
    public String saveComment(EbComment comment){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        comment.setEcCreateTime(df.format(new Date()));
        commentService.saveComment(comment);
        return "redirect:/comment/list/1/5";
    }

    @RequestMapping("/saveU")
    public String saveUComment(EbComment comment){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        comment.setEcCreateTime(df.format(new Date()));
        commentService.saveComment(comment);
        return "redirect:/comment/u_list/1/5";
    }

    @RequestMapping("/list/{currentPage}/{row}")
    public ModelAndView getCommentList(@PathVariable Integer currentPage, @PathVariable Integer row){
        if (currentPage == null)
            currentPage = 1;
        if (row == null){
            row = 5;
        }
        PageBean<EbComment> commentList = commentService.findCommentByPage(currentPage,row);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("commentPageBean",commentList);
        modelAndView.setViewName("guestbook");
        return modelAndView;
    }
    @RequestMapping("/u_list/{currentPage}/{row}")
    public ModelAndView getCommentUList(@PathVariable Integer currentPage, @PathVariable Integer row){
        if (currentPage == null)
            currentPage = 1;
        if (row == null){
            row = 5;
        }
        PageBean<EbComment> commentList = commentService.findCommentByPage(currentPage,row);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("commentPageBean",commentList);
        modelAndView.setViewName("guestbook_for_user");
        return modelAndView;
    }

}
