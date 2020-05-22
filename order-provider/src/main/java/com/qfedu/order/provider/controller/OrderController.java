package com.qfedu.order.provider.controller;

import com.qfedu.order.provider.beans.Order;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import vo.ResultVO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 再梦一生
 * 日期:2020/5/14
 */
@RestController
@RequestMapping("order")
public class OrderController {


    /**
     * 查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public List<Order> ListOrder(Integer pageNum,Integer pageSize) {
        System.out.println(pageNum);
        System.out.println(pageSize);
        ArrayList<Order> orders = new ArrayList<>();
        orders.add(new Order(1,"nihao"));
        orders.add(new Order(2,"nihao"));
        orders.add(new Order(3,"nihao"));
        orders.add(new Order(4,"nihao"));
        orders.add(new Order(5,"nihao"));
        return orders;
    }

    /**
     * 添加
     * @param order
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public ResultVO addOrder(@RequestBody Order order,Integer pageNum,Integer pageSize) {
        System.out.println(order);
        System.out.println(pageNum);
        System.out.println(pageSize);
        return new ResultVO(0,"success",null);
    }

    /**
     * 删除
     */
    @RequestMapping(value = "remove",method = RequestMethod.DELETE)
    public ResultVO delete(Integer id) {

        System.out.println(id);
        return new ResultVO(0,"success",null);

    }

    /**
     * 修改
     * @param order
     * @return
     */
    @RequestMapping(value = "update",method = RequestMethod.PUT)
    public ResultVO update(@RequestBody Order order){
        System.out.println(order);
        return new ResultVO(0,"success",null);
    }




}
