package com.qfedu.goods.prodiver.service;

import com.qfedu.goods.prodiver.beans.Goods;

import java.util.List;

/**
 * @author 再梦一生
 * 日期:2020/5/14
 */
public interface GoodsService {

    public List<Goods> listGoods(Integer pageNum, Integer pageSize);




}
