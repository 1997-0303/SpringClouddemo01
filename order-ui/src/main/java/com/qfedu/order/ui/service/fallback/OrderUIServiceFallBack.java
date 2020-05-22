package com.qfedu.order.ui.service.fallback;

import beans.Order;
import com.qfedu.order.ui.service.OrderService;
import org.springframework.stereotype.Component;
import vo.ResultVO;

import java.util.List;

/**
 * @author 再梦一生
 * 日期:2020/5/16
 * 服务降级的业务逻辑。
 */
@Component
public class OrderUIServiceFallBack implements OrderService {
    @Override
    public List<Order> ListOrder(Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public ResultVO addOrder(Order order) {
        return null;
    }

    @Override
    public ResultVO test(Order order, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public ResultVO delete(Integer id) {
        return null;
    }

    @Override
    public ResultVO update(Order order) {
        return null;
    }
}
