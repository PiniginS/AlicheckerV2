package com.kithome.alichecker2.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "item_id", nullable = false, unique = true)
    private BigInteger item_id;

    @Column(name = "item_price", nullable = false, unique = true)
    private BigDecimal item_price;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    public BigInteger getItem_id() {
        return item_id;
    }

    public void setItem_id(BigInteger id) {
        this.item_id = id;
    }

    public BigDecimal getItem_price() { return item_price; }

    public void setItem_price(BigDecimal price) {
        this.item_price = price;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp tmstmp) {
        this.timestamp = tmstmp;
    }

    @Override
    public String toString() {
        return "Id = "+item_id+" price = "+item_price+" timestamp = "+timestamp;
    }
}
