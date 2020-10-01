package io.oicp.yorick61c.mapper;

import io.oicp.yorick61c.domain.EbOrderDetail;

import java.util.List;

public interface OrderDetailMapper {

    List<EbOrderDetail> findAll();

    EbOrderDetail findOrderDetail();

    void insert(EbOrderDetail orderDetail);

    void update(EbOrderDetail orderDetail);

    void delete(EbOrderDetail orderDetail);

}
