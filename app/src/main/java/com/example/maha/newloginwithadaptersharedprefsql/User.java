package com.example.maha.newloginwithadaptersharedprefsql;

import java.io.Serializable;

/**
 * Created by Maha on 22/09/2017.
 */


public class User implements Serializable {

    String name;
    int pass;

    public User(String name, int pass) {

        this.name = name;
        this.pass = pass;
    }


    public String getName() {
        return name;
    }

    public int getPass() {
        return pass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }











}
