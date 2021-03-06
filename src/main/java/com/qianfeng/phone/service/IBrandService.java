package com.qianfeng.phone.service;

import com.qianfeng.phone.po.TbPhone;
import com.qianfeng.phone.vo.BrandVO;

import java.util.List;

public interface IBrandService {
    List<BrandVO> queryBrand();
    List<TbPhone> queryPhone();
    List<TbPhone> queryBrandPhone(int brandId);
    List<TbPhone> queryPhoneByPhoneName(String seek,String seek1);
    List<TbPhone> queryPagePhone(int page);
}
