package com.example.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class KullaniciGiris extends Kullanici {

    public KullaniciGiris(String ad, String telefon, String dogumTarihi) {
        super(ad, telefon, dogumTarihi);
    }

    @Override
    public void kullaniciBilgileriniGoster() {
        System.out.println("Ad: " + getAd());
        System.out.println("Telefon: " + getTelefon());
        System.out.println("Doğum Tarihi: " + getDogumTarihi());
    }

    public static boolean kullaniciDogrula(String email, String sifre) {
        return true;
    }
}


