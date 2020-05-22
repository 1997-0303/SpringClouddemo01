package com.qfedu.goods.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 再梦一生
 * 日期:2020/5/14
 */
@Controller
public class PageController {

    @RequestMapping("index.html")
    public String index(){
        return "index";
    }


    @RequestMapping("goods-add.html")
    public String goodsadd(){
        return "goods-add";
    }

}
