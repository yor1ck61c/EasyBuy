package io.oicp.yorick61c.mapper;

import io.oicp.yorick61c.domain.EbOrder;

import java.util.List;

public interface OrderMapper {

    Integer countOrder();

    List<EbOrder> findAll();

    EbOrder findOrder(EbOrder order);

    void insert(EbOrder order);

    void delete(EbOrder order);

    void update(EbOrder order);

    List<EbOrder> findOrders(EbOrder ebOrder);
}
