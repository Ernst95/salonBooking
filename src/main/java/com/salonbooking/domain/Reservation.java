package com.salonbooking.domain;

/**
 * Created by Ernst on 2017/08/07.
 */
public class Reservation {

    private String id;
    private String date;
    private String time;
    private Employee emp;
    private Customer cust;
    private Style style;
    private Receipt receipt;

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    private Reservation(){

    }

    public Reservation(Builder builder){

        this.id = builder.id;
        this.date = builder.date;
        this.time = builder.time;
        this.emp = builder.emp;
        this.cust = builder.cust;
        this.style = builder.style;
        this.receipt = builder.receipt;

    }

    public static class Builder{

        private String id;
        private String date;
        private String time;
        private Employee emp;
        private Customer cust;
        private Style style;
        private Receipt receipt;

        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder date(String value) {
            this.date = value;
            return this;
        }

        public Builder time(String value) {
            this.time = value;
            return this;
        }

        public Builder emp(Employee emp){
            this.emp = emp;
            return this;
        }

        public Builder cust(Customer cust){
            this.cust = cust;
            return this;
        }

        public Builder style(Style style){
            this.style = style;
            return this;
        }

        public Builder receipt(Receipt receipt){
            this.receipt = receipt;
            return this;
        }

        public Reservation build(){
            return new Reservation(this);
        }
    }
}
