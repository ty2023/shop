package com.yj.shop_goods_service;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.yj")
@MapperScan("com.yj.dao")
@DubboComponentScan("com.yj.service.impl")
public class ShopGoodsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopGoodsServiceApplication.class, args);
    }

}
