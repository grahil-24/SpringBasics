package org.example.springdata.model;

import java.math.BigDecimal;

public class Purchase {

    private int id;
    private String product;
    //when working with data which requires very good precision and sensitive data like price
    //use BigDecimal instead of float or double
    private BigDecimal price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
