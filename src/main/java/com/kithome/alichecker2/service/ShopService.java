package com.kithome.alichecker2.service;

import com.kithome.alichecker2.model.Shop;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

public interface ShopService {

    void addRecord (Shop shop);

    Timestamp getLastcheckByShopId (BigInteger shopId);

    List<Shop> getShopByShopId (BigInteger shopId);

    int getCountByShopId (BigInteger shopId);

    void deleteRecordById (int id);
}
