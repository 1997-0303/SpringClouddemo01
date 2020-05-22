package com.qfedu.goods.prodiver.Controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.qfedu.goods.prodiver.beans.Goods;
import com.qfedu.goods.prodiver.service.GoodsService;
import org.springframework.web.bind.annotation.*;
import vo.ResultVO;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 再梦一生
 * 日期:2020/5/14
 */
@RestController
@RequestMapping("goods")
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public List<Goods> list(Integer pageNum,Integer pageSize) {
        return goodsService.listGoods(pageNum,pageSize);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallback_getGoods",commandProperties ={
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1000")
    } )
    public Goods getGoods(@PathVariable String id) {
        System.out.println(id.equals("1"));
        if (id.equals("1")) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {

            }
        }
        return new Goods(id,"查询商品",33.33);

    }
    public Goods fallback_getGoods(@PathVariable String id) {
        System.out.println("降级");
        return new Goods(id,"降级服务",23.23);
    }


    @RequestMapping(value = "add",method = RequestMethod.POST)
    public ResultVO addGoods(@RequestBody Goods goods) {
        System.out.println(goods);

        return new ResultVO(0,"success",null);
    }
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ResultVO update(@RequestBody Goods goods) {
        System.out.println(goods);
        return new ResultVO(0,"success",null);
    }

    @RequestMapping(value = "remove",method = RequestMethod.GET)
    public ResultVO remove(@RequestParam Integer id){
        System.out.println(id);

        return new ResultVO(0,"success",null);

    }


}
