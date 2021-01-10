package com.atguigu.gulimall.product;

import com.atguigu.gulimall.product.entity.BrandEntity;
import com.atguigu.gulimall.product.service.BrandService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
class GulimallProductApplicationTests {

    @Autowired
    BrandService brandService;
    @Test
    public void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        //保存
//        brandEntity.setDescript("华为");
//        brandEntity.setName("华为2");
//        brandService.save(brandEntity);
//        System.out.println("保存成功....");
//        brandService.updateById(brandEntity);
        //新增
//        brandEntity.setBrandId(2L);
//        brandEntity.setDescript("华为手机");
//        brandService.updateById(brandEntity);
//        System.out.println("修改成功");
        // 查询
        BrandEntity brand = brandService.getOne(new QueryWrapper<BrandEntity>().eq("brand_id", 2L));
        System.out.println(brand);

    }

}
