package io.oicp.yorick61c.mapper;

import io.oicp.yorick61c.domain.EbNews;

import java.util.List;

public interface NewsMapper {

    List<EbNews> findAll();

    Integer countNews();

    void delete(Integer id);

    EbNews findNews(EbNews ebNews);

    void update(EbNews news);

    void insert(EbNews news);
}
