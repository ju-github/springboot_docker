package com.atguigu.gulimall.member.feign;

/*
远程调用
1.引入openFeign
2.编写一个接口，告诉springCloud 这个接口需要远程调用
3.声明一个借口，每一个接口都是调用哪一个远程服务的请求
4.在main（）开启远程调用功能 @EnableFeignClients(basePackages="com.atguigu.gulimall.member.feign")
* */

import com.atguigu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 这是一个声明式的远程调用
*/
@FeignClient("gulimall-coupon")
public interface CouponFeignService {

    @RequestMapping("/coupon/coupon/member/list")
    public R memberCoupons();
}
