package com.kithome.alichecker2.dao;

import com.kithome.alichecker2.model.Shop;

import java.math.BigInteger;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by spinigin on 20.03.17.
 */
public interface ShopDao {

    void addRecord (Shop shop);

    Timestamp getLastcheckByShopId (BigInteger shopId);

    List<Shop> getShopByShopId (BigInteger shopId);

    int getCountByShopId (BigInteger shopId);

    void deleteRecordById (int id);
}
