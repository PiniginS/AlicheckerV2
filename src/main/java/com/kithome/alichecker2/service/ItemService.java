package com.kithome.alichecker2.service;

import com.kithome.alichecker2.model.Item;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

public interface ItemService {

    void addRecord (Item item);

    Timestamp getLastcheckByItemId (BigInteger itemId);

    List<Item> getItembyItemId (BigInteger itemId);

    int getPriceByItemId (BigInteger itemId);

    void deleteRecordById (int id);
}
