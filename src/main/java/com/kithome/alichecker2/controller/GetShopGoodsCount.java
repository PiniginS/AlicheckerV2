package com.kithome.alichecker2.controller;

import com.kithome.alichecker2.model.Shop;
import com.kithome.alichecker2.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping("/getShopGoodsCount")
public class GetShopGoodsCount {


    @Autowired
    ShopService service;

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    String getShopGoodsCount(@RequestParam(value = "shop_id", required = true) BigInteger shop_id) {
        String result = "Проверка...";

        Timestamp lastcheck = service.getLastcheckByShopId(shop_id);
        if (lastcheck == null) {
            result += "Нет данных добавляю ...";
            addRecord(shop_id, 100, new Timestamp(System.currentTimeMillis()));
            lastcheck = service.getLastcheckByShopId(shop_id);
        }
        Timestamp now = new Timestamp(System.currentTimeMillis() - 1 * 10 * 1000);
        if (lastcheck.before(now)) {
            result += "добавляю запись... ";
            addRecord(shop_id, 100, new Timestamp(System.currentTimeMillis()));
            List<Shop> shops = service.getShopByShopId(shop_id);
            for (Shop sh1 : shops) {
                result = result.concat(sh1.toString() + " ");
            }
        } else {
            result += "актуально... ";
            List<Shop> shops = service.getShopByShopId(shop_id);
            for (Shop sh1 : shops) {
                result = result.concat(sh1.toString() + " ");
            }
        }
        return result;
    }

    private void addRecord(BigInteger shop_id, int counter, Timestamp timestamp) {
        Shop shop = new Shop();
        shop.setShop_id(shop_id);
        shop.setCount(counter);
        shop.setTimestamp(timestamp);
        service.addRecord(shop);
    }
}
