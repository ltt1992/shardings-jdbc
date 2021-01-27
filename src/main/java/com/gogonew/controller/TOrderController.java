package com.gogonew.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gogonew.mapper.TConfigMapper;
import com.gogonew.mapper.TOrderItemMapper;
import com.gogonew.mapper.TOrderMapper;
import com.gogonew.model.TConfig;
import com.gogonew.model.TOrder;
import com.gogonew.model.TOrderItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/jdbc")
public class TOrderController {
    @Autowired
    private TOrderMapper tOrderMapper;
    @Autowired
    private TOrderItemMapper tOrderItemMapper;
    @Autowired
    private TConfigMapper tConfigMapper;

    @GetMapping("/save")
    public void saveOrder(){
        log.info("connection...");
        for (int i = 4; i < 1000000; i++) {
            TOrder order = new TOrder();
            order.setOrderNo("A000" + i);
            order.setCreateName("订单 " + i);
            order.setPrice(new BigDecimal("" + i));
            tOrderMapper.insert(order);
            TOrderItem orderItem = new TOrderItem();
            orderItem.setOrderId(order.getOrderId());
            orderItem.setOrderNo("A000" + i);
            orderItem.setItemName("服务项目" + i);
            orderItem.setPrice(new BigDecimal("" + i));
            tOrderItemMapper.insert(orderItem);
        }
    }

    @GetMapping("/config")
    public String config() {
        TConfig tConfig = new TConfig();
        tConfig.setRemark("我是广播表");
        tConfig.setCreateTime(new Date());
        tConfig.setLastModifyTime(new Date());
        tConfigMapper.insert(tConfig);
        return "success";
    }

    @GetMapping("/get")
    public String get(@RequestParam("orderId") Long orderId) {
        List<String> orderItemList = tOrderMapper.selectOrderAndItemByOrderId(orderId);
        System.out.println(orderItemList);
        return "success";
    }

    @GetMapping("/getpage")
    public List<TOrder> getPage() {
        IPage<TOrder> iPage = new Page<>(10000,10);
        iPage = tOrderMapper.selectPage(iPage,null);
        return iPage.getRecords();
    }

    @GetMapping("/getlist")
    public List<TOrder> getList() {
        long startTime = System.currentTimeMillis();
        int size = tOrderMapper.selectList(null).size();
        System.out.println(size+"条");
        System.out.println(System.currentTimeMillis()-startTime);
        return null;
    }

    @GetMapping("/getdetail")
    public TOrder getdetail() {
        final TOrder tOrder = tOrderMapper.selectById(1336728584550522882L);
        return tOrder;
    }

}
