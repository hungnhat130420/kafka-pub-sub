package com.kafka.producer.api;

import com.kafka.producer.entity.Commodity;
import com.kafka.producer.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/commodity/v1")
public class CommodityApi {

    private CommodityService commodityService;

    @Autowired
    public CommodityApi(CommodityService commodityService) {
        this.commodityService = commodityService;
    }

    @GetMapping("/all")
    public List<Commodity> getAllCommodities() {
        return commodityService.createDummyCommodities();
    }
}
