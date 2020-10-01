package io.oicp.yorick61c.controller;


import io.oicp.yorick61c.domain.EbOrder;
import io.oicp.yorick61c.domain.PageBean;
import io.oicp.yorick61c.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Resource(name = "orderService")
    private OrderService orderService;

    @RequestMapping("/findOrder")
    public ModelAndView findOrder(EbOrder ebOrder,ModelAndView modelAndView){
        List<EbOrder> orders = orderService.findOrdersByIdAndName(ebOrder);
        modelAndView.addObject("orders",orders);
        modelAndView.setViewName("manage/order_by_id");
        return modelAndView;
    }
    @RequestMapping("/list/{currentPage}/{rows}")
    public ModelAndView findOrderList(@PathVariable Integer currentPage, @PathVariable Integer rows){
        if (currentPage == null)
            currentPage = 1;
        if (rows == null)
            rows = 5;
        PageBean<EbOrder> orderByPage = orderService.findOrderByPage(currentPage, rows);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("manage/order");
        modelAndView.addObject("orderList",orderByPage);
        return modelAndView;
    }

    @RequestMapping("/delete/{eoId}")
    public String deleteOrder(@PathVariable Integer eoId){
        orderService.delete(eoId);
        return "manage/order_deleteStatus_result";
    }

    @RequestMapping("/beforeUpdate/{eoId}")
    public ModelAndView beforeUpdate(@PathVariable Integer eoId){
        EbOrder orderById = orderService.findOrderById(eoId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("order",orderById);
        modelAndView.setViewName("manage/order-modify");
        return modelAndView;
    }

    @RequestMapping("/update/{eoId}")
    public String updateOrder(EbOrder ebOrder,@PathVariable Integer eoId){
        ebOrder.setEoId(eoId);
        orderService.update(ebOrder);
        return "manage/order_deleteStatus_result";
    }
}
