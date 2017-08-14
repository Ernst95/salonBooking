package com.salonbooking.domain;

import java.util.ArrayList;

/**
 * Created by Ernst on 2017/08/07.
 */
public class Customer {

    private String id;
    private String name;
    private String surname;
    private int age;
    private String gender;
    private String cellNumber;
    private String email;
    private Employee emp;
    //ArrayList<Receipt> receiptList;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public String getEmail() {
        return email;
    }

    private Customer(){

    }

    public Customer(Builder builder){

        this.id = builder.id;
        this.name = builder.name;
        this.surname = builder.surname;
        this.age = builder.age;
        this.gender = builder.gender;
        this.cellNumber = builder.cellNumber;
        this.email = builder.email;
        this.emp = builder.emp;
        //this.receiptList = builder.receiptList;

    }

    public static class Builder{

        private String id;
        private String name;
        private String surname;
        private int age;
        private String gender;
        private String cellNumber;
        private String email;
        private Employee emp;
        //private ArrayList<Receipt> receiptList;

        public Customer.Builder id(String value) {
            this.id = value;
            return this;
        }

        public Customer.Builder name(String value) {
            this.name = value;
            return this;
        }

        public Builder surname(String value) {
            this.surname = value;
            return this;
        }

        public Builder age(int value) {
            this.age = value;
            return this;
        }

        public Builder gender(String value) {
            this.gender = value;
            return this;
        }

        public Builder cellNumber(String value) {
            this.cellNumber = value;
            return this;
        }

        public Builder email(String value) {
            this.email = value;
            return this;
        }

        public Builder emp(Employee emp){
            this.emp = emp;
            return this;
        }

        /*public Builder receiptList()
        {
            this.receiptList = new ArrayList<Receipt>();
            return this;
        }*/

        public Customer build(){
            return new Customer(this);
        }
    }
}
