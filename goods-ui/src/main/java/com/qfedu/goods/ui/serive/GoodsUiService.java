package com.qfedu.goods.ui.serive;

import beans.Goods;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import vo.ResultVO;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 再梦一生
 * 日期:2020/5/14
 */
@Service
public class GoodsUiService {

    // 通过服务的调用获取数据信息
    @Resource
    private RestTemplate restTemplate;


    /**
     * 访问goods-provider服务的goods/list
     */
    public List<Goods> visitGoodsList(Integer pageNum, Integer pageSize) {
        String params = "pageNum=" + pageNum + "&pageSize=" + pageSize;
        Goods[] data = restTemplate.getForObject("http://goods-provider/goods/list?" + params, Goods[].class);
        List<Goods> goods = Arrays.asList(data);
        System.out.println(goods);
        return goods;
    }

    /**
     * 请求时间过长，就采用降级方案
     * @param goodsId
     * fallbackMethod = "fallback_getGoods"  如果请求时间超过1秒，就采用降级服务，访问fallback_getGoods。
     * 降级的方法，参数，返回值必须和么有降级的一样，
     * @return
     */
    @HystrixCommand(fallbackMethod = "fallback_getGoods",commandProperties = {
            // 设置属性
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1000")
    })
    public Goods getGoods(String goodsId) {
        Goods data = restTemplate.getForObject("http://goods-provider/goods/" + goodsId, Goods.class);
        System.out.println(data);
        return data;
    }

    public Goods fallback_getGoods(String goodsId) {
        System.out.println("降级ui");
        return new Goods("1","降级服务商品",33.33);
    }



    /**
     * 访问goods-provider服务的goods/add
     */
    public ResultVO visitGoodsAdd(Goods goods) {
        ResultVO resultVO = restTemplate.postForObject("http://goods-provider/goods/add", goods, ResultVO.class);
        return resultVO;
    }


    /**
     * 修改
     *
     * @param goods
     * @return
     */
    public ResultVO update(Goods goods) {
        ResultVO resultVO = restTemplate.postForObject("http://goods-provider/goods/update", goods, ResultVO.class);
        return resultVO;
    }

    /**
     * 删除
     */
    public ResultVO remove(Integer id) {
//        ResultVO resultVO = restTemplate.("http://goods-provider/goods/update",id,ResultVO.class);
        System.out.println("--------------service"+id);
        restTemplate.getForObject("http://goods-provider/goods/remove?id="+id,ResultVO.class);
        return null;
    }
}
