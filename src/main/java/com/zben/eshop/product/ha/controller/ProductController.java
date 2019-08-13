package com.zben.eshop.product.ha.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @DESC:
 * @author: jhon.zhou
 * @date: 2019/8/9 0009 9:38
 */
@RestController
public class ProductController {

    @GetMapping("/getProductInfo/{productId}")
    public String getProductInfo(@PathVariable Long productId){
        return "{\"id\": "+productId+", \"name\": \"iphone7手机\", \"price\": 5599, \"pictureList\":\"a.jpg,b.jpg\", \"specification\": \"iphone7的规格\", \"service\": \"iphone7的售后服务\", \"color\": \"红色,白色,黑色\", \"size\": \"5.5\", \"shopId\": 1, \"modifyTime\":\"2019-07-29 16:30:00\", \"brandId\":1,\"brandName\":\"iphone7 Plus\"}";
    }

    @GetMapping("/getProductInfos")
    public String getProductInfos(String productIds){
        System.out.println("getProductInfos接口，接收到一次请求，productIds=" + productIds);
        JSONArray jsonArray = new JSONArray();
        for (String productId : productIds.split(",")) {
            String json = "{\"id\": "+productId+", \"name\": \"iphone7手机\", \"price\": 5599, \"pictureList\":\"a.jpg,b.jpg\", \"specification\": \"iphone7的规格\", \"service\": \"iphone7的售后服务\", \"color\": \"红色,白色,黑色\", \"size\": \"5.5\", \"shopId\": 1, \"modifyTime\":\"2019-07-29 16:30:00\", \"brandId\":1,\"brandName\":\"iphone7 Plus\"}";
            jsonArray.add(JSONObject.parseObject(json));
        }
        return jsonArray.toJSONString();
    }
}
