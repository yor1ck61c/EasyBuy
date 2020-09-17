package io.oicp.yorick61c.service.impl;

import com.github.pagehelper.PageHelper;
import io.oicp.yorick61c.domain.EbNews;
import io.oicp.yorick61c.domain.PageBean;
import io.oicp.yorick61c.mapper.NewsMapper;
import io.oicp.yorick61c.service.NewsService;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("NewsService")
public class NewsServiceImpl implements NewsService {

    @Resource(name = "newsMapper")
    private NewsMapper newsMapper;

    @Override
    public PageBean<EbNews> findNewsListByPage(Integer currentPage, Integer rows) {
        PageBean<EbNews> ebNewsPageBean = new PageBean<>();
        ebNewsPageBean.setCurrentPage(currentPage);
        ebNewsPageBean.setRows(rows);
        PageHelper.startPage(currentPage,rows);
        ebNewsPageBean.setItems(newsMapper.findAll());
        int totalItems = newsMapper.countNews();
        ebNewsPageBean.setTotalItems(totalItems);
        int totalPages = totalItems % rows == 0 ? totalItems/rows : (totalItems/rows) + 1;
        ebNewsPageBean.setTotalPages(totalPages);
        return ebNewsPageBean;
    }

    @Override
    public void delNewsById(Integer id) {
        newsMapper.delete(id);
    }

    @Override
    public EbNews findNews(EbNews ebNews) {

        return newsMapper.findNews(ebNews);
    }

    @Override
    public void updateNews(EbNews news) {
        newsMapper.update(news);
    }

    @Override
    public void addNews(EbNews news) {
        newsMapper.insert(news);
    }
}
