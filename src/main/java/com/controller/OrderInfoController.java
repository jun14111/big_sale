package com.controller;

import com.model.Orderinfo;
import com.service.OrderinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/orderInfo")
@RestController
public class OrderInfoController {
    @Autowired
    OrderinfoService orderinfoService;

    @RequestMapping("/list")
    public List<Orderinfo> list(int userid) {
        return orderinfoService.listOrderinfoByUserid(userid);
    }
}
