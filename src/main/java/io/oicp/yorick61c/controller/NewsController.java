package io.oicp.yorick61c.controller;


import io.oicp.yorick61c.domain.EbNews;
import io.oicp.yorick61c.domain.PageBean;
import io.oicp.yorick61c.service.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.jws.WebParam;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Resource(name = "NewsService")
    private NewsService newsService;

    @RequestMapping("/list/{currentPage}/{rows}")
    public ModelAndView findNewsByPage(@PathVariable Integer currentPage, @PathVariable Integer rows) {
        if (currentPage == null)
            currentPage = 1;
        if (rows == null)
            rows = 4;

        PageBean<EbNews> newsList = newsService.findNewsListByPage(currentPage, rows);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("newsList",newsList);
        modelAndView.setViewName("/manage/news");

        return modelAndView;
    }

    @RequestMapping("/lists/{currentPage}/{rows}")
    public ModelAndView findNewsByPage2(@PathVariable Integer currentPage, @PathVariable Integer rows) {
        if (currentPage == null)
            currentPage = 1;
        if (rows == null)
            rows = 5;

        PageBean<EbNews> newsList = newsService.findNewsListByPage(currentPage, rows);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("newsList",newsList);
        modelAndView.setViewName("/news-view");

        return modelAndView;
    }

    @RequestMapping("/delete/{enId}")
    public String delNewsById(@PathVariable Integer enId){
        newsService.delNewsById(enId);
        return "redirect:/news/list/1/3";
    }

    @RequestMapping("/beforeUpdateNews/{enId}")
    public ModelAndView beforeUpdate(@PathVariable Integer enId){
        EbNews ebNews = new EbNews();
        ebNews.setEnId(enId);
        EbNews news = newsService.findNews(ebNews);
        System.out.println(news);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("news",news);
        modelAndView.setViewName("manage/news-modify");
        return modelAndView;
    }

    @RequestMapping("/update/{enId}")
    public String updateNews(EbNews news,@PathVariable Integer enId){
        news.setEnId(enId);
        newsService.updateNews(news);
        return "redirect:/news/list/1/3";
    }

    @RequestMapping("/add")
    public String addNews(EbNews news) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        news.setEnCreateTime(df.format(new Date()));
        newsService.addNews(news);
        return "redirect:/news/list/1/3";
    }
}
