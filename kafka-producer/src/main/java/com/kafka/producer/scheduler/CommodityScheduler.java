package com.kafka.producer.scheduler;

import com.kafka.producer.entity.Commodity;
import com.kafka.producer.producer.CommodityProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CommodityScheduler {

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private CommodityProducer commodityProducer;

    @Scheduled(fixedRate = 5000)
    public void fetchCommodities() {
        List<Commodity> commodities = restTemplate
                .exchange("http://localhost:8080/api/commodity/v1/all", HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Commodity>>() {}).getBody();

        commodities.forEach(t-> commodityProducer.sendMessage(t));
    }
}
