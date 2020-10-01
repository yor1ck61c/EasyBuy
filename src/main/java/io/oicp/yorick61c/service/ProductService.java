package io.oicp.yorick61c.service;

import io.oicp.yorick61c.domain.EbProduct;
import io.oicp.yorick61c.domain.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

    void saveProduct(EbProduct product);

    PageBean<EbProduct> findProductByPage(Integer currentPage, Integer row);

    void deleteProduct(Integer epId);

    EbProduct findProduct(Integer epId);

    void updateProduct(EbProduct product);

    List<EbProduct> findCPLById(Integer epcId);
}
