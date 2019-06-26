package com.example.finacceluitest.models;

public class NominalModel {

    String nominal;
    String nominalRupiah;
    String phoneNumber;

    public NominalModel(String nominal, String nominalRupiah, String phoneNumber) {
        this.nominal = nominal;
        this.nominalRupiah = nominalRupiah;
        this.phoneNumber = phoneNumber;
    }

    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    public String getNominalRupiah() {
        return nominalRupiah;
    }

    public void setNominalRupiah(String nominalRupiah) {
        this.nominalRupiah = nominalRupiah;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
