package com.kithome.alichecker2.controller;

import com.kithome.alichecker2.model.Item;
import com.kithome.alichecker2.service.ItemService;
import org.json.JSONArray;
import org.json.JSONObject;
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
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/getPriceHistoryController")
public class GetPriceHistoryController {

    @Autowired
    ItemService service;

    private String ID;

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    String getPriceHistory(@RequestParam(value = "id", required = true) String id) {

        ID=id;
        //JSONArray ar = new JSONArray();
        JSONObject obj = new JSONObject();
        JSONObject resultJson = new JSONObject();

        String url ="https://ru.aliexpress.com/wholesale?SearchText="+ID;

        Item newItem = getItemFromUrl(url);//get item info from url

        Timestamp lastcheck = service.getLastcheckByItemId(newItem.getItem_id());

        if (lastcheck == null) {
            service.addRecord(newItem);
            lastcheck = service.getLastcheckByItemId(newItem.getItem_id());
        }

        Timestamp now = new Timestamp(System.currentTimeMillis() - 1 * 60 * 1000);

        if (lastcheck.before(now)) {
            service.addRecord(newItem);
            List<Item> items = service.getItembyItemId(newItem.getItem_id());
            for (Item it1 : items) {
                obj= new JSONObject();
                obj.put("item_price",it1.getItem_price());
                obj.put("timestamp",it1.getTimestamp());
                resultJson.append(it1.getItem_id().toString(),obj);
            }
        } else {
            List<Item> items = service.getItembyItemId(newItem.getItem_id());
            for (Item it1 : items) {
                obj= new JSONObject();
                obj.put("item_price",it1.getItem_price());
                obj.put("timestamp",it1.getTimestamp());
                resultJson.append(it1.getItem_id().toString(),obj);
            }
        }
        return resultJson.toString();
    }

    private Item getItemFromUrl(String url) {
        Document doc;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            System.out.println("Can't get document from url");
            e.printStackTrace();
            return null;
        }

        Item item = new Item();
        item.setItem_id(new BigInteger(ID));
        item.setItem_price(getItemPrice(doc));
        item.setTimestamp(new Timestamp(System.currentTimeMillis()));
        return item;
    }

    private BigDecimal getItemPrice(Document doc) {
        Element element = doc.getElementsByClass("p-current-price").get(0);

        if (element.getElementById("j-sku-price") == null) {
            element = element.getElementById("j-sku-discount-price");
        } else {
            element = element.getElementById("j-sku-price");
        }
        String price = element.toString();

        price = price.replaceAll("&nbsp;", "");

        Pattern p = Pattern.compile("(\\d*)(&nbsp;)?(,?)(\\d+)");
        Matcher m = p.matcher(price);

        if (m.find()) {
            return new BigDecimal(m.group().replaceAll(",","."));
        }
        return new BigDecimal(0);
    }
}
