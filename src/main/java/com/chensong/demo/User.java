package com.chensong.demo;

import java.math.BigDecimal;

public class User {
    Integer id;
    BigDecimal height;//身高

    public User(Integer id, BigDecimal height) {
        this.id = id;
        this.height = height;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", height=" + height +
                '}';
    }

}
