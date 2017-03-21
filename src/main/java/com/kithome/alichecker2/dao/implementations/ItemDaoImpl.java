package com.kithome.alichecker2.dao.implementations;

import com.kithome.alichecker2.dao.AbstractDao;
import com.kithome.alichecker2.dao.ItemDao;
import com.kithome.alichecker2.model.Item;
import com.kithome.alichecker2.model.Shop;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

@Repository("itemDao")
public class ItemDaoImpl extends AbstractDao implements ItemDao{
    @Override
    public void addRecord(Item item) { persist(item); }

    @Override
    public Timestamp getLastcheckByItemId(BigInteger itemId) {
        Criteria criteria = getSession().createCriteria(Item.class);
        criteria.add(Restrictions.eq("item_id", itemId));
        criteria.addOrder(Order.desc("timestamp"));
        criteria.setMaxResults(1);
        Item result = (Item) criteria.uniqueResult();
        if (result != null) {
            return result.getTimestamp();
        } else {
            return null;
        }
    }

    @Override
    public List<Item> getItembyItemId(BigInteger shopId) {
        Criteria criteria = getSession().createCriteria(Item.class);
        criteria.add(Restrictions.eq("item_id", shopId));
        return (List<Item>) criteria.list();
    }

    @Override
    public int getPriceByItemId(BigInteger shopId) {
        return 0;
    }

    @Override
    public void deleteRecordById(int id) {

    }
}
