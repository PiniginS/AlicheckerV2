package com.kithome.alichecker2.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "shop_id", nullable = false, unique = true)
    private BigInteger shop_id;

    @Column(name = "count", nullable = false, unique = true)
    private int count;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    public BigInteger getShop_id() {
        return shop_id;
    }

    public void setShop_id(BigInteger id) {
        this.shop_id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp tmstmp) {
        this.timestamp = tmstmp;
    }

    @Override
    public String toString() {
        return "Id = "+shop_id+" count = "+count+" timestamp = "+timestamp;
    }
}
