package com.example.maha.newloginwithadaptersharedprefsql;

/**
 * Created by Maha on 22/09/2017.
 */

public class TvEdModel {

    String note, state;


    public TvEdModel(String note, String state) {
        this.note = note;
        this.state = state;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setState(String state) {
        this.state = state;
    }


    public String getNote() {
        return note;
    }

    public String getState() {
        return state;
    }
}
