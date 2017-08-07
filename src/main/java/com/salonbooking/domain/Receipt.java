package com.salonbooking.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Ernst on 2017/08/07.
 */
public class Receipt implements Print{

    private String id;
    private Date date;
    private DateFormat dateFormat;
    private Customer cust;
    private Employee emp;

    public String getId() {
        return id;
    }

    public Date getDate(){
        return date;
    }

    public void print()
    {
        System.out.println("Receipt\n\t\t\t\t"+dateFormat.format(date));
        System.out.println("Employee: " + emp.getName());
        System.out.println("Customer: " + cust.getName());
    }

    private Receipt(){

    }

    public Receipt(Builder builder){

        this.id = builder.id;
        this.date = builder.date;
        this.dateFormat = builder.dateFormat;
        this.cust = builder.cust;
        this.emp = builder.emp;

    }

    public static class Builder{

        private String id;
        private Date date;
        private DateFormat dateFormat;
        private Customer cust;
        private Employee emp;


        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder date() {
            this.date = new Date();
            return this;
        }

        public Builder dateFormat(){
            dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            return this;
        }

        public Builder cust(Customer cust) {
            this.cust = cust;
            return this;
        }

        public Builder emp(Employee emp) {
            this.emp = emp;
            return this;
        }

        public Receipt build(){
            return new Receipt(this);
        }
    }
}
