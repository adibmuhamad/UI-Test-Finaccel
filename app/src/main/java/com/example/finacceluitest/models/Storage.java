package com.example.finacceluitest.models;

public class Storage {

    private String nominal;
    private String phoneNumber;

    public Storage() {
        this.nominal = "";
        this.phoneNumber = "";
    }

    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
