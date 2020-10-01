package io.oicp.yorick61c.service;

import io.oicp.yorick61c.domain.EbOrder;
import io.oicp.yorick61c.domain.PageBean;

import java.util.List;


public interface OrderService {
    PageBean<EbOrder> findOrderByPage(Integer currentPage, Integer rows);

    void delete(Integer eoId);

    EbOrder findOrderById(Integer eoId);

    void update(EbOrder ebOrder);

    List<EbOrder> findOrdersByIdAndName(EbOrder ebOrder);
}
