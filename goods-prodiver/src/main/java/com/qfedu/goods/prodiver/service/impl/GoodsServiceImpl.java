package com.qfedu.goods.prodiver.service.impl;

import com.qfedu.goods.prodiver.beans.Goods;
import com.qfedu.goods.prodiver.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 再梦一生
 * 日期:2020/5/14
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Override
    public List<Goods> listGoods(Integer pageNum, Integer pageSize){
        // 调用dao查询商品信息
        List<Goods> goods = new ArrayList<>();

        goods.add(new Goods("101","笔记本",66.66));
        goods.add(new Goods("101","笔记本",66.66));
        goods.add(new Goods("101","笔记本",66.66));
        goods.add(new Goods("101","笔记本",66.66));
        goods.add(new Goods("101","笔记本",66.66));
        goods.add(new Goods("101","笔记本",66.66));

        return goods;
    }


}
