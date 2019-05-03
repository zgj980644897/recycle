package com.qianfeng;

import com.qianfeng.commons.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

public class Test1 {
    @Autowired
    private static StringRedisTemplate redisTemplate;
    public static void test2(){
        redisTemplate.boundValueOps("qian").set("jaav22");
        String qianfeng = redisTemplate.boundValueOps("qian").get();
        System.out.println(qianfeng);
    }
    public static void main(String[] args) {
        test2();
    }
}
