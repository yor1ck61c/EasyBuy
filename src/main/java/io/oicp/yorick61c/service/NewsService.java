package io.oicp.yorick61c.service;

import io.oicp.yorick61c.domain.EbNews;
import io.oicp.yorick61c.domain.PageBean;

import java.util.List;


public interface NewsService {

    PageBean<EbNews> findNewsListByPage(Integer currentPage, Integer rows);

    void delNewsById(Integer id);

    EbNews findNews(EbNews ebNews);

    void updateNews(EbNews news);

    void addNews(EbNews news);

    List<EbNews> findAll();
}
