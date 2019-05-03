package com.qianfeng.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class test2 {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Test
    public void text1(){
        redisTemplate.boundValueOps("qian").set("jaav22");

    }
    @Test
    public void text3(){
        String qianfeng = redisTemplate.boundValueOps("qian").get();
        System.out.println(qianfeng);
    }
}
