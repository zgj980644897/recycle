package com.qianfeng.phone.controller;

import com.qianfeng.phone.po.TbPhone;
import com.qianfeng.phone.service.IBrandService;
import com.qianfeng.phone.vo.BrandIdVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin //允许跨域。。前端解决跨域是jsonp
@RestController
@RequestMapping("/callphone")
public class BrandController {
    @Autowired
    private IBrandService brandServiceImpl;
    @RequestMapping(method = RequestMethod.POST)
    public List<TbPhone> queryPhone(@RequestBody BrandIdVO brandId){
        System.out.println("品牌id："+brandId);
        if (brandId==null||"0".equals(brandId.getBrandId())){
            List<TbPhone> list=brandServiceImpl.queryPhone();
            System.out.println(list);
            return list;
        }else{
            int parentId = Integer.parseInt(brandId.getBrandId());
            List<TbPhone> phones = brandServiceImpl.queryBrandPhone(parentId);
            return phones;
        }
    }
}
