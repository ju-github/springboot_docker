package com.atguigu.gulimall.product.dao;

import com.atguigu.gulimall.product.entity.AttrEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品属性
 * 
 * @author le.ju
 * @email le.ju@gmail.com
 * @date 2021-01-03 19:11:14
 */
@Mapper
public interface AttrDao extends BaseMapper<AttrEntity> {
	
}
