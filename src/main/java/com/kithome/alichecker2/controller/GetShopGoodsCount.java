package com.kithome.alichecker2.controller;

import com.kithome.alichecker2.model.Shop;
import com.kithome.alichecker2.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping("/getShopGoodsCount")
public class GetShopGoodsCount {


    @Autowired
    ShopService service;

    @RequestMapping(method= RequestMethod.GET)
    public @ResponseBody
    String getShopGoodsCount()
    {
        String result="";
        //Shop shop1 = new Shop();
        //shop1.setCount(100);
        //shop1.setTimestamp(new Timestamp(System.currentTimeMillis()));
        //shop1.setShop_id(BigInteger.valueOf(1802865));
        //service.addRecord(shop1);

        //List<Shop> shops = service.getShopByShopId(BigInteger.valueOf(1802865));
        //for (Shop sh1:shops) {
        //    result=result.concat(sh1.toString());
        //}
        //return result;

        return service.getLastcheckByShopId(BigInteger.valueOf(1802865)).toString();
    }
}
