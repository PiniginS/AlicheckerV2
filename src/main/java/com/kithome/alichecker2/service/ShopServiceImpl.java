package com.kithome.alichecker2.service;

import com.kithome.alichecker2.dao.ShopDao;
import com.kithome.alichecker2.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

@Service("shopService")
@Transactional
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDao dao;
    @Override
    public void addRecord(Shop shop) {
        dao.addRecord(shop);
    }

    @Override
    public Timestamp getLastcheckByShopId(BigInteger shopId) {
        return dao.getLastcheckByShopId(shopId);
    }

    @Override
    public List<Shop> getShopByShopId(BigInteger shopId) {
        return dao.getShopByShopId(shopId);
    }

    @Override
    public int getCountByShopId(BigInteger shopId) {
        return 0;
    }

    @Override
    public void deleteRecordById(int id) {

    }
}
