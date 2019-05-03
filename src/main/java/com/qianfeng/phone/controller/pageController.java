package com.qianfeng.phone.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.qianfeng.phone.po.TbPhone;
import com.qianfeng.phone.service.IBrandService;

import com.qianfeng.phone.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin //允许跨域。。前端解决跨域是jsonp
@RestController
@RequestMapping("/phonePage")
public class pageController {
    @Autowired
    private IBrandService brandServiceImpl;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping(method = RequestMethod.POST)
    public List<TbPhone> queryPage(@RequestBody PageVO page) {
        String page2 = page.getPage2();
        System.out.println(page2);
        int page1 = 1;
        if (page2 != null) {
            page1 = Integer.parseInt(page2);

        }
        Gson gson = new Gson();
        //redisTemplate.boundValueOps("java").set("hahaha");

           String s = redisTemplate.boundValueOps("phone-page-" + page1).get();

        if (s== null) {
            List<TbPhone> list = brandServiceImpl.queryPagePhone(page1);

            String strList = gson.toJson(list);
            redisTemplate.boundValueOps("phone-page-" + page1).set(strList);
            return list;
        } else {
            String strList = redisTemplate.boundValueOps("phone-page-" + page1).get();

            JsonParser jsonParser = new JsonParser();
            JsonArray jsonElements = jsonParser.parse(strList).getAsJsonArray();//获取JsonArray对象
            ArrayList<TbPhone> list = new ArrayList<>();
            for (JsonElement tbPhone : jsonElements) {
                TbPhone phone = gson.fromJson(tbPhone, TbPhone.class);//解析
                list.add(phone);

            }
            return list;
        }

    }
}
