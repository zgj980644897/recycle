package com.qianfeng.phone.controller;

import com.qianfeng.phone.service.IBrandService;
import com.qianfeng.phone.vo.BrandVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/phone")
public class IndexController {
    @Autowired
    private IBrandService brandServiceImpl;
//    @ResponseBody
//    @RequestMapping("/brand")
    public List<BrandVO> queryBrand(){
        List<BrandVO> list = brandServiceImpl.queryBrand();
        return list;
    }
}
