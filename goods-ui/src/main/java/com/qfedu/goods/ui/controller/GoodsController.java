package com.qfedu.goods.ui.controller;

import beans.Goods;
import com.qfedu.goods.ui.serive.GoodsUiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vo.ResultVO;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 再梦一生
 * 日期:2020/5/14
 */
@Controller
public class GoodsController {


    @Resource
    private GoodsUiService goodsUiService;

    @RequestMapping("goodsList")
    public String listGoods(Integer pageNum, Integer pageSize, Model model){
        System.out.println("==========="+pageNum+pageSize);
        List<Goods> goods = goodsUiService.visitGoodsList(pageNum, pageSize);
        System.out.println(goods);
        model.addAttribute("goods",goods);
        return "goodsList";
    }

    @RequestMapping("goodsAdd")
    public String addGoods(Goods goods, Model model) {
        System.out.println(goods);
        ResultVO resultVO = goodsUiService.visitGoodsAdd(goods);
        model.addAttribute("vo",resultVO);
        return "tips";
    }

    @RequestMapping("update")
    public String update(){
        Goods goods = new Goods();
        goods.setGoodsId("1");
        goods.setGoodsName("nishi");
        goods.setPrice(22.22);
        goodsUiService.update(goods);
        System.out.println("----------------------------update");
        return "index";
    }

    @RequestMapping("remove")
    public String remove(@RequestParam("id") Integer id){
        System.out.println(id);
        goodsUiService.remove(id);
        return "index";
    }


    @RequestMapping("goodsQuery")
    @ResponseBody
    public ResultVO getGoods(String id) {
        Goods goods = goodsUiService.getGoods(id);
           if (goods!=null) {
               return new ResultVO(0,"success",goods);
           } else {
               return new ResultVO(0,"false",goods);
           }

    }



}
