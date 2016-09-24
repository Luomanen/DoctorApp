package com.mycompany.doctorapp.domain;

import java.util.List;

public class Sickness {
private List<String> oireet;
private String nimi;
private String hoitoOhje;

    public List<String> getOireet() {
        return oireet;
    }

    public void setOireet(List<String> oireet) {
        this.oireet = oireet;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getHoitoOhje() {
        return hoitoOhje;
    }

    public void setHoitoOhje(String hoitoOhje) {
        this.hoitoOhje = hoitoOhje;
    }

}
