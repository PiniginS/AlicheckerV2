package com.kithome.alichecker2.controller;

import com.kithome.alichecker2.model.Shop;
import com.kithome.alichecker2.service.ShopService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/getShopGoodsCount")
public class GetShopGoodsCount {


    @Autowired
    ShopService service;

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    String getShopGoodsCount(@RequestParam(value = "url", required = true) String url) {

        Shop newShop = getShopFromUrl(url);//get shop info from url

        String result = "Проверка...";

        Timestamp lastcheck = service.getLastcheckByShopId(newShop.getShop_id());

        if (lastcheck == null) {
            result += "Нет данных добавляю ...";
            addRecord(newShop.getShop_id(), newShop.getCount(), newShop.getTimestamp());
            lastcheck = service.getLastcheckByShopId(newShop.getShop_id());
        }

        Timestamp now = new Timestamp(System.currentTimeMillis() - 3 * 10 * 1000);

        if (lastcheck.before(now)) {
            result += "добавляю запись... ";
            addRecord(newShop.getShop_id(), newShop.getCount(), newShop.getTimestamp());
            List<Shop> shops = service.getShopByShopId(newShop.getShop_id());
            for (Shop sh1 : shops) {
                result = result.concat(sh1.toString() + " ");
            }
        } else {
            result += "актуально... ";
            List<Shop> shops = service.getShopByShopId(newShop.getShop_id());
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

    private Shop getShopFromUrl(String url) {
        Document doc;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            System.out.println("Can't get document from url");
            e.printStackTrace();
            return null;
        }

        Shop shop = new Shop();
        shop.setShop_id(getShopId(doc));
        shop.setCount(getItemCount(shop.getShop_id()));
        shop.setTimestamp(new Timestamp(System.currentTimeMillis()));
        return shop;
    }

    private BigInteger getShopId(Document doc) {

        List<Element> elements = doc.getElementsByClass("shop-name");
        String shop = elements.get(0).getElementsByAttribute("href").get(0).toString();
        Pattern p = Pattern.compile("\\d*\\d");
        Matcher m = p.matcher(shop);

        if (m.find()) {
            return new BigInteger(m.group());
        }
        return null;
    }

    private int getItemCount(BigInteger shopId) {
        String url = "https://ru.aliexpress.com/store/all-wholesale-products/" + shopId.toString() + ".html";
        Document doc = new Document("");
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            System.out.println("Can't shop's item counter from url");
            e.printStackTrace();
        }

        String counter = doc.getElementById("result-info").toString();
        counter = counter.replaceAll("\\,", "");
        Pattern p = Pattern.compile("\\d*\\d");
        Matcher m = p.matcher(counter);

        if (m.find()) {
            return Integer.parseInt(m.group());
        }
        return 0;
    }
}
