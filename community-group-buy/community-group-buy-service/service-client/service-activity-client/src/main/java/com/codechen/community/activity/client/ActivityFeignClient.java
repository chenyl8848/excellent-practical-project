package com.codechen.community.activity.client;

import com.codechen.community.model.activity.CouponInfo;
import com.codechen.community.model.order.CartInfo;
import com.codechen.community.vo.order.CartInfoVo;
import com.codechen.community.vo.order.OrderConfirmVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@FeignClient("service-activity")
public interface ActivityFeignClient {

    //获取购物车里面满足条件优惠卷和活动的信息
    @PostMapping("/api/activity/inner/findCartActivityAndCoupon/{userId}")
    public OrderConfirmVo findCartActivityAndCoupon(@RequestBody List<CartInfo> cartInfoList,
                                                    @PathVariable("userId") Long userId);

    @GetMapping("/api/activity/inner/findActivityAndCoupon/{skuId}/{userId}")
    public Map<String,Object> findActivityAndCoupon(@PathVariable("skuId") Long skuId,
                                                    @PathVariable("userId") Long userId);

    @PostMapping("/api/activity/inner/findActivity")
    public Map<Long, List<String>> findActivity(@RequestBody List<Long> skuIdList);

    @PostMapping("/api/activity/inner/findRangeSkuIdList/{couponId}")
    public CouponInfo findRangeSkuIdList(@RequestBody List<CartInfo> cartInfoList,
                                         @PathVariable("couponId") Long couponId);

    @GetMapping("/api/activity/inner/updateCouponInfoUseStatus/{couponId}/{userId}/{orderId}")
    public Boolean updateCouponInfoUseStatus(@PathVariable("couponId") Long couponId,
                                             @PathVariable("userId") Long userId,
                                             @PathVariable("orderId") Long orderId);

    //获取购物车对应规则数据
    @PostMapping("/api/activity/inner/findCartActivityList")
    public List<CartInfoVo> findCartActivityList(@RequestBody List<CartInfo> cartInfoList);
}
