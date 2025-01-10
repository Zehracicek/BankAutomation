package com.example.application;

import java.io.Serializable;
import java.util.Random;

public abstract class Hesap implements Serializable {
    private String kartNumarasi;
    private String iban;
    private String kartTipi;
    private String sonKullanmaTarihi;
    private double bakiye;

    public Hesap(String kartTipi, double bakiye) {
        this.kartTipi = kartTipi;
        this.bakiye = bakiye;

        this.kartNumarasi = generateRandomNumber(16);
        this.iban = "TR" + generateRandomNumber(24);
        this.sonKullanmaTarihi = "11/2029";
    }

    public String getKartNumarasi() {
        return kartNumarasi;
    }

    public void setKartNumarasi(String kartNumarasi) {
        this.kartNumarasi = kartNumarasi;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getKartTipi() {
        return kartTipi;
    }

    public String getSonKullanmaTarihi() {
        return sonKullanmaTarihi;
    }

    public double getBakiye() {
        return bakiye;
    }

    public void setBakiye(double bakiye) {
        this.bakiye = bakiye;
    }

    private String generateRandomNumber(int length) {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(random.nextInt(10));
        }
        return builder.toString();
    }

    public abstract void odemeYap(double miktar);

    public abstract void paraGonder(double miktar);
}