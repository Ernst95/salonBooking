package com.salonbooking.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Ernst on 2017/08/07.
 */

@Entity
public class Admin {

    @Id
    private String id;
    private String name;
    private String password;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    private Admin() {
    }

    public Admin(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.password = builder.password;
    }

    public static class Builder{
        private String id;
        private String name;
        private String password;

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder name(String value){
            this.name = value;
            return this;
        }

        public Builder password(String value){
            this.password = value;
            return this;
        }

        public Admin build(){

            return new Admin(this);
        }

    }
}
