package com.kafka.producer.service;

import com.kafka.producer.entity.Commodity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommodityService {
    private static final Map<String, Commodity> COMMODITY_MAP = new HashMap<>();

    private static final String COPPER = "copper";
    private static final String GOLD = "gold";
    private static final double MAX_PRICE = 1.05d;
    private static final double MIN_PRICE = 0.9d;

    static {
        var timestamp = System.currentTimeMillis();
        COMMODITY_MAP.put(COPPER, new Commodity(COPPER, 5.99, "kg", timestamp));
        COMMODITY_MAP.put(GOLD, new Commodity(GOLD, 10.6, "ton", timestamp));
    }

    public Commodity createCommodity(String name) {
        if (!COMMODITY_MAP.containsKey(name)) {
            throw new IllegalArgumentException("Commodity not found: " + name);
        }

        Commodity commodity = COMMODITY_MAP.get(name);
        var basePrice = commodity.getPrice();
        var newPrice = basePrice * (MIN_PRICE + Math.random() * (MAX_PRICE - MIN_PRICE));

        commodity.setPrice(newPrice);
        commodity.setTimestamp(System.currentTimeMillis());

        return commodity;
    }

    public List<Commodity> createDummyCommodities() {
        var result = new ArrayList<Commodity>();
        COMMODITY_MAP.keySet().forEach(c -> result.add(createCommodity(c)));

        return result;
    }
}