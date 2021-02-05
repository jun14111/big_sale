package com.controller;

import com.model.Killgoods;
import com.model.Killorderinfo;
import com.model.Orderinfo;
import com.service.KillGoodsService;
import com.service.KillorderinfoService;
import com.service.OrderinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RequestMapping("/buy")
@RestController
public class BuyController {
    @Autowired
    KillGoodsService killGoodsService;

    @Autowired
    KillorderinfoService killorderinfoService;

    @Autowired
    OrderinfoService orderinfoService;

    @RequestMapping("/check")
    public int check(int killid, int goodsid, int userid) {
        Killgoods killgoods = killGoodsService.selectByPrimaryKey(killid);
        // 1.判断秒杀商品的库存是否大于零
        if(killgoods.getStockcount() <= 0){
            return 1;
        }
        // 2.判断此秒杀商品的秒杀时间
        long currentDate = System.currentTimeMillis();
        long startdate = killgoods.getStartdate().getTime();
        long enddate = killgoods.getEnddate().getTime();
        if(!(startdate <= currentDate && currentDate <= enddate)){
            return 2;
        }


        List<Killorderinfo> killorderinfoList = killorderinfoService.selectByUseridAndKillid(userid, goodsid);
        // 3.判断用户是否已经秒杀过此商品，如果购买过将无法秒杀
        if(killorderinfoList.size() > 0){
            return 3;
        }

        // 可以购买
        return 0;
    }

    @RequestMapping("/buy")
    public void buy(int killid, int goodsid, int userid) {
        Killgoods killgoods = killGoodsService.selectByPrimaryKey(killid);
        killGoodsService.subStockcount(killid);

        Orderinfo orderinfo = new Orderinfo();
        orderinfo.setGoodsid(goodsid);
        orderinfo.setUserid(userid);
        orderinfo.setGoodsname(killgoods.getGoodsName());
        orderinfo.setGoodscount(1);
        orderinfo.setGoodsprice(killgoods.getKillprice());
        orderinfoService.insertSelective(orderinfo);

        Killorderinfo killorderinfo = new Killorderinfo();
        killorderinfo.setUserid(userid);
        killorderinfo.setGoodsid(goodsid);
        killorderinfoService.insertSelective(killorderinfo);
    }
}

