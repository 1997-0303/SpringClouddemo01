package com.qfedu.goods.prodiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
//EnableHystrix包含（EnableCircuitBreaker）
@EnableCircuitBreaker
public class GoodsProdiverApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsProdiverApplication.class, args);
    }

}
