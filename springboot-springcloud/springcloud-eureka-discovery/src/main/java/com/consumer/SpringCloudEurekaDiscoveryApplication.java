package com.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @EnableDiscoveryClient 开启发现服务功能。
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudEurekaDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaDiscoveryApplication.class, args);
    }

    /**
     * 启用负载均衡机制（默认是轮询方式调用多台服务器，这里是通过多个provider的jar包启动来模拟集群）
     * @return
     */
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
