package com.qfedu.order.ui.controller;

import beans.Order;
import com.qfedu.order.ui.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 再梦一生
 * 日期:2020/5/15
 */
@Controller
public class OrderController {

    @Resource
    private OrderService orderService;

    @RequestMapping("listOrders")
    public String orderList(Integer pageNum,Integer pageSize){

        List<Order> orders = orderService.ListOrder(pageNum,pageSize);
        System.out.println("===============");
        System.out.println(orders);
        System.out.println("===============");
        return "index";
    }

    @RequestMapping("/add")
    public String addOrder(){
        Order order = new Order();
        order.setId(1);
        order.setDescropt("添加的订单");
        System.out.println("dingdna");
        orderService.addOrder(order);
        return "index";
    }

    @RequestMapping("test")
    public String test(){
        Integer pageNum = 1;
        Integer pageSize = 3;
        Order order = new Order();
        order.setDescropt("dingdan");
        order.setId(3);
        orderService.test(order,pageNum,pageSize);
        return "index";
    }

    @RequestMapping("update")
    public String update(){
        Order order = new Order();
        order.setId(1);
        order.setDescropt("修改订单");
        orderService.update(order);
        return "index";
    }

    @RequestMapping("remove")
    public String delete(Integer id){
        orderService.delete(id);
        return "index";
    }

}
