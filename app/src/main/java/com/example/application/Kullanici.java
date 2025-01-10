package com.example.application;

public abstract class Kullanici {
    private String ad;
    private String telefon;
    private String dogumTarihi;

    public Kullanici(String ad, String telefon, String dogumTarihi) {
        this.ad = ad;
        this.telefon = telefon;
        this.dogumTarihi = dogumTarihi;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public abstract void kullaniciBilgileriniGoster();
}
