package com.salonbooking.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
    //private DateFormat dateFormat;

    /*@ManyToOne
    private Style style;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Employee employee;*/

    @OneToOne
    private Reservation reservation;

    public String getId() {
        return id;
    }

    public Date getDate(){
        return date;
    }

    /*public DateFormat getDateFormat()
    {
        return dateFormat;
    }*/

    public void print()
    {
        /*System.out.println("Receipt\n\t\t\t\t"+dateFormat.format(date));
        System.out.println("Employee: " + employee.getName());
        System.out.println("Customer: " + customer.getName());*/
    }

    private Receipt(){

    }

    public Receipt(Builder builder){

        this.id = builder.id;
        this.date = builder.date;
        this.reservation = builder.reservation;
    }

    public static class Builder{

        private String id;
        private Date date;
        private Reservation reservation;

        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder date(Date date) {
            this.date = date;
            return this;
        }

        public Builder reservation(Reservation reservation)
        {
            this.reservation = reservation;
            return this;
        }

        public Receipt build(){
            return new Receipt(this);
        }
    }
}
