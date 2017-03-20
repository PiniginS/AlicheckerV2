package com.kithome.alichecker2.dao.implementations;

import com.kithome.alichecker2.dao.AbstractDao;
import com.kithome.alichecker2.dao.ShopDao;
import com.kithome.alichecker2.model.Shop;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

@Repository("shopDao")
public class ShopDaoImpl extends AbstractDao implements ShopDao {
    @Override
    public void addRecord(Shop shop) {
        persist(shop);
    }

    @Override
    public Timestamp getLastcheckByShopId(BigInteger shopId) {
        Criteria criteria = getSession().createCriteria(Shop.class);
        criteria.add(Restrictions.eq("shop_id", shopId));
        criteria.addOrder(Order.desc("timestamp"));
        criteria.setMaxResults(1);
        Shop result = (Shop) criteria.uniqueResult();
        if (result != null) {
            return result.getTimestamp();
        } else {
            return null;
        }

    }

    @Override
    public List<Shop> getShopByShopId(BigInteger shopId) {
        Criteria criteria = getSession().createCriteria(Shop.class);
        criteria.add(Restrictions.eq("shop_id", shopId));
        return (List<Shop>) criteria.list();
    }

    @Override
    public int getCountByShopId(BigInteger shopId) {
        return 0;
    }

    @Override
    public void deleteRecordById(int id) {

    }
}
