package com.kimnux.portfolio.controller;

import com.kimnux.portfolio.service.RedisSampleService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private RedisSampleService redisSampleService;

    @PostMapping(value = "/getRedisStringValue")
    public void getRedisStringValue(String key) {
        System.out.println("key : " + key);
        redisSampleService.getRedisStringValue(key);
    }

    @GetMapping(value = "/getRedisStringValue")
    public void test(String key) {
        System.out.println("key : " + key);
        redisSampleService.getRedisStringValue(key);
    }

}
