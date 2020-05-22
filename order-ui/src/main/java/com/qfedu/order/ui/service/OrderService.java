package com.qfedu.order.ui.service;

import beans.Order;
import com.qfedu.order.ui.service.fallback.OrderUIServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import vo.ResultVO;

import java.util.List;

/**
 * @author 再梦一生
 * 日期:2020/5/15
 * 服务的调用如果失败，则调用falback指定类的同名方法。
 */
@FeignClient(value = "order-provider",fallback = OrderUIServiceFallBack.class)
public interface OrderService {

    @RequestMapping(value = "order/list",method = RequestMethod.GET)
    public List<Order> ListOrder(@RequestParam("pageNum")Integer pageNum,@RequestParam("pageSize")Integer pageSize);

    @RequestMapping(value = "order/add",method = RequestMethod.POST)
    public ResultVO addOrder(Order order);

    @RequestMapping(value = "order/add",method = RequestMethod.POST)
    public ResultVO test(@RequestBody Order order,@RequestParam Integer pageNum,@RequestParam Integer pageSize);


    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value = "order/remove",method = RequestMethod.DELETE)
    public ResultVO delete(@RequestParam Integer id);

    /**
     * 修改
     */
    @RequestMapping(value = "order/update",method = RequestMethod.PUT)
    public ResultVO update(Order order);

}
