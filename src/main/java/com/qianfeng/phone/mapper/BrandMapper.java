package com.qianfeng.phone.mapper;

import com.qianfeng.phone.po.TbPhone;
import com.qianfeng.phone.vo.BrandVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BrandMapper {
    List<BrandVO> queryBrand();
    List<TbPhone> queryPhone();
}
