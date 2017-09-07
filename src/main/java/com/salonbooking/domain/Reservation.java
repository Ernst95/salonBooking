package com.salonbooking.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by Ernst on 2017/08/07.
 */

@Entity
public class Reservation {

    @Id
    private String id;
    private String date;
    private String time;
    @ManyToOne
    private Style style;
    @ManyToOne
    private Customer cust;
    @ManyToOne
    private Employee emp;

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
        this.style = builder.style;
        this.cust = builder.cust;
        this.emp = builder.emp;

    }

    public static class Builder{

        private String id;
        private String date;
        private String time;
        private Style style;
        private Customer cust;
        private Employee emp;

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

        public Builder style(Style style){
            this.style = style;
            return this;
        }

        public Builder cust(Customer cust){
            this.cust = cust;
            return this;
        }

        public Builder emp(Employee emp){
            this.emp = emp;
            return this;
        }

        public Reservation build(){
            return new Reservation(this);
        }
    }
}
