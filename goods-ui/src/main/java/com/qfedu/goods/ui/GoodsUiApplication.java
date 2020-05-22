package com.qfedu.goods.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableDiscoveryClient
@SpringBootApplication
@EnableHystrix
public class GoodsUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsUiApplication.class, args);
    }

}
