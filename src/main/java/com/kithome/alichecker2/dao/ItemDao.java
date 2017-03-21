package com.kithome.alichecker2.dao;

import com.kithome.alichecker2.model.Item;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

public interface ItemDao {

    void addRecord (Item item);

    Timestamp getLastcheckByItemId (BigInteger shopId);

    List<Item> getItembyItemId (BigInteger shopId);

    int getPriceByItemId (BigInteger shopId);

    void deleteRecordById (int id);
}
