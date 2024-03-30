package com.example.Library.Reservation;

import java.util.Date;

public class Reservation_front {
    private String code;
    private String livre;
    private Date date_res;
    private Date date_retour;
    private String statut;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLivre() {
        return livre;
    }

    public void setLivre(String livre) {
        this.livre = livre;
    }

    public Date getDate_res() {
        return date_res;
    }

    public void setDate_res(Date date_res) {
        this.date_res = date_res;
    }

    public Date getDate_retour() {
        return date_retour;
    }

    public void setDate_retour(Date date_retour) {
        this.date_retour = date_retour;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Reservation_front(String code, String livre, Date date_res, Date date_retour, String statut) {
        this.code = code;
        this.livre = livre;
        this.date_res = date_res;
        this.date_retour = date_retour;
        this.statut = statut;
    }
    public Reservation_front(){

    }
}
