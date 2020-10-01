package io.oicp.yorick61c.service;

import io.oicp.yorick61c.domain.EbProduct;
import io.oicp.yorick61c.domain.EbProductCategory;
import io.oicp.yorick61c.domain.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductCategoryService {
    PageBean<EbProductCategory> findProductByPage(Integer currentPage, Integer row);

    void delete(Integer epcId);

    EbProductCategory findPCById(Integer epcId);

    void update(EbProductCategory pc);

    void insert(EbProductCategory ebProductCategory);

    List<EbProductCategory> findAll();

    List<EbProductCategory> findParent();

    List<EbProductCategory> findChild();
}
