package com.codechen.community.activity.service;

import com.codechen.community.model.activity.ActivityInfo;
import com.codechen.community.model.activity.ActivityRule;
import com.codechen.community.model.order.CartInfo;
import com.codechen.community.model.product.SkuInfo;
import com.codechen.community.vo.activity.ActivityRuleVo;
import com.codechen.community.vo.order.CartInfoVo;
import com.codechen.community.vo.order.OrderConfirmVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 活动表 服务类
 * </p>
 *
 * @author Java陈序员
 * @since 2023-04-07
 */
public interface ActivityInfoService extends IService<ActivityInfo> {

    //列表
    IPage<ActivityInfo> selectPage(Page<ActivityInfo> pageParam);

    //1 根据活动id获取活动规则数据
    Map<String, Object> findActivityRuleList(Long activityId);

    //2 在活动里面添加规则数据
    void saveActivityRule(ActivityRuleVo activityRuleVo);

    //3 根据关键字查询匹配sku信息
    List<SkuInfo> findSkuInfoByKeyword(String keyword);

    //根据skuId列表获取促销信息
    Map<Long, List<String>> findActivity(List<Long> skuIdList);

    //根据skuID获取营销数据和优惠卷
    Map<String, Object> findActivityAndCoupon(Long skuId, Long userId);

    //根据skuId获取活动规则数据
    List<ActivityRule> findActivityRuleBySkuId(Long skuId);

    //获取购物车里面满足条件优惠卷和活动的信息
    OrderConfirmVo findCartActivityAndCoupon(List<CartInfo> cartInfoList, Long userId);

    //获取购物车对应规则数据
    List<CartInfoVo> findCartActivityList(List<CartInfo> cartInfoList);
}
