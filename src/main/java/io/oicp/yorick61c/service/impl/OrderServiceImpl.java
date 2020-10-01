package io.oicp.yorick61c.service.impl;

import com.github.pagehelper.PageHelper;
import io.oicp.yorick61c.domain.EbOrder;
import io.oicp.yorick61c.domain.PageBean;
import io.oicp.yorick61c.mapper.OrderMapper;
import io.oicp.yorick61c.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Resource(name = "orderMapper")
    private OrderMapper orderMapper;

    @Override
    public PageBean<EbOrder> findOrderByPage(Integer currentPage, Integer rows) {

        PageBean<EbOrder> ebOrderPageBean = new PageBean<EbOrder>();
        ebOrderPageBean.setCurrentPage(currentPage);
        ebOrderPageBean.setRows(rows);
        PageHelper.startPage(currentPage,rows);
        ebOrderPageBean.setItems(orderMapper.findAll());
        int totalItems = orderMapper.countOrder();
        ebOrderPageBean.setTotalItems(totalItems);
        ebOrderPageBean.setTotalPages(
                totalItems % rows == 0 ? totalItems / rows : (totalItems / rows) + 1
        );
        return ebOrderPageBean;
    }

    @Override
    public void delete(Integer eoId) {
        EbOrder ebOrder = new EbOrder();
        ebOrder.setEoId(eoId);
        orderMapper.delete(ebOrder);
    }

    @Override
    public EbOrder findOrderById(Integer eoId) {
        EbOrder ebOrder = new EbOrder();
        ebOrder.setEoId(eoId);
        return orderMapper.findOrder(ebOrder);
    }

    @Override
    public void update(EbOrder ebOrder) {
        orderMapper.update(ebOrder);
    }

    @Override
    public List<EbOrder> findOrdersByIdAndName(EbOrder ebOrder) {
        return orderMapper.findOrders(ebOrder);
    }
}
