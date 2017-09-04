package com.salonbooking.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Ernst on 2017/08/07.
 */

@Entity
public class Style implements Cost{

    @Id
    private String id;
    private String name;
    private double price;
    private int hairLength;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getHairLength() {
        return hairLength;
    }

    public double calculateAmount()
    {
        return getPrice() * getHairLength();
    }

    private Style(){

    }

    public Style(Builder builder){

        this.id = builder.id;
        this.name = builder.name;
        this.price = builder.price;
        this.hairLength = builder.hairLength;

    }

    public static class Builder{

        private String id;
        private String name;
        private double price;
        private int hairLength;

        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder name(String value) {
            this.name = value;
            return this;
        }

        public Builder price(double value) {
            this.price = value;
            return this;
        }

        public Builder hairLength(int value) {
            this.hairLength = value;
            return this;
        }

        public Style build(){
            return new Style(this);
        }
    }
}
