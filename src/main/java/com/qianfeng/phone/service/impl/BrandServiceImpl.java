package com.qianfeng.phone.service.impl;

import com.qianfeng.phone.mapper.BrandMapper;
import com.qianfeng.phone.po.TbPhone;
import com.qianfeng.phone.service.IBrandService;
import com.qianfeng.phone.vo.BrandVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BrandServiceImpl implements IBrandService {
    @Autowired
    private BrandMapper brandMapper;
    @Override
    public List<BrandVO> queryBrand() {
        return brandMapper.queryBrand();
    }

    @Override
    public List<TbPhone> queryPhone() {
        return brandMapper.queryPhone();
    }

    @Override
    public List<TbPhone> queryBrandPhone(int brandId) {
        return brandMapper.queryBrandPhone(brandId);
    }

    @Override
    public List<TbPhone> queryPhoneByPhoneName(String seek,String seek1) {
        return brandMapper.queryPhoneByPhoneName(seek,seek1);
    }
}
