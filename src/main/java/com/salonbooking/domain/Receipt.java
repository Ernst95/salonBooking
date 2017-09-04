package com.salonbooking.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Ernst on 2017/08/07.
 */

@Entity
public class Receipt implements Print{

    @Id
    private String id;
    private Date date;
    private DateFormat dateFormat;

    /*private Customer customer;
    private Employee employee;*/

    public String getId() {
        return id;
    }

    public Date getDate(){
        return date;
    }

    public DateFormat getDateFormat()
    {
        return dateFormat;
    }

    public void print()
    {
        System.out.println("Receipt\n\t\t\t\t"+dateFormat.format(date));
        /*System.out.println("Employee: " + employee.getName());
        System.out.println("Customer: " + customer.getName());*/
    }

    private Receipt(){

    }

    public Receipt(Builder builder){

        this.id = builder.id;
        this.date = builder.date;
        /*this.dateFormat = builder.dateFormat;
        this.customer = builder.customer;
        this.employee = builder.employee;*/

    }

    public static class Builder{

        private String id;
        private Date date;
        /*private DateFormat dateFormat;
        private Customer customer;
        private Employee employee;
        private Receipt receipt*/

        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder date(Date date) {
            this.date = date;
            return this;
        }

        /*public Builder dateFormat(DateFormat dateFormat){
            this.dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            return this;
        }*/

        /*public Builder cust(Customer cust) {
            this.customer = cust;
            return this;
        }

        public Builder emp(Employee emp) {
            this.employee = emp;
            return this;
        }*/

        public Receipt build(){
            return new Receipt(this);
        }
    }
}
