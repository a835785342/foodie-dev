package com.imooc.controller;

import com.imooc.pojo.bo.ShopcartBO;
import com.imooc.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(value = "购物车接口controller", tags = {"购物车接口controller"})
@RestController
@RequestMapping("shopcart")
public class ShopCatController {


    @ApiOperation(value = "添加商品到购物车", notes = "添加商品到购物车", httpMethod = "POST")
    @PostMapping("/add")
    public IMOOCJSONResult add(@ApiParam(name = "userId", value = "用户id", required = true)
                               @RequestParam String userId,
                               @RequestBody ShopcartBO shopcartBO, HttpServletRequest request
            , HttpServletResponse response) {

        if (StringUtils.isBlank(userId)) {
            return IMOOCJSONResult.errorMsg("");
        }
        System.out.println(shopcartBO.toString());
        //TODO 前端用户在登录的情况下，添加商品到购物车，会同时在后端同步购物车到redis缓存

        return IMOOCJSONResult.ok();

    }

    @ApiOperation(value = "删除购物车商品", notes = "删除购物车商品", httpMethod = "POST")
    @PostMapping("/del")
    public IMOOCJSONResult del(@ApiParam(name = "userId", value = "用户id", required = true)
                               @RequestParam String userId,
                               @ApiParam(name = "itemSpecId", value = "商品规格id", required = true)
                               @RequestParam String itemSpecId,
                               HttpServletRequest request,
                               HttpServletResponse response) {

        if (StringUtils.isBlank(userId) || StringUtils.isBlank(itemSpecId)) {
            return IMOOCJSONResult.errorMsg("参数不能为空");
        }
        //TODO 前端用户在登录的情况下，删除购物车商品，会同时在后端删除购物车redis缓存

        return IMOOCJSONResult.ok();

    }
}
