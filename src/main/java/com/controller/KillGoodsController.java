package com.controller;

import com.model.Killgoods;
import com.service.KillGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author HuangCJ
 */
@RequestMapping("/killGoods")
@RestController
public class KillGoodsController {
    @Autowired
    KillGoodsService killGoodsService;

    @RequestMapping("/list")
    public List<Killgoods> list(){
        return killGoodsService.listKillGoods();
    }

    @RequestMapping("/selectOneByPk")
    Killgoods selectByPrimaryKey(Integer killid){
        return killGoodsService.selectByPrimaryKey(killid);
    };
}
