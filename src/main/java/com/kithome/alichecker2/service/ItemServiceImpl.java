package com.kithome.alichecker2.service;

import com.kithome.alichecker2.dao.ItemDao;
import com.kithome.alichecker2.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

@Service("itemService")
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao dao;

    @Override
    public void addRecord(Item item) {
    dao.addRecord(item);
    }

    @Override
    public Timestamp getLastcheckByItemId(BigInteger itemId) {
        return dao.getLastcheckByItemId(itemId);
    }

    @Override
    public List<Item> getItembyItemId(BigInteger itemId) {
        return dao.getItembyItemId(itemId);
    }

    @Override
    public int getPriceByItemId(BigInteger itemId) {
        return dao.getPriceByItemId(itemId);
    }

    @Override
    public void deleteRecordById(int id) {

    }
}
