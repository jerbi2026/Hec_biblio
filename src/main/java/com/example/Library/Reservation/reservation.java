package com.example.Library.Reservation;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;
@Entity
public class reservation {
    @Id
    private int id_res;
    private int id_livre;
    private int id_abonne;

    private Date date_res;
    private Date date_retour;
    private String code;
    private boolean statut=false;

    public int getId_res() {
        return id_res;
    }

    public void setId_res(int id_res) {
        this.id_res = id_res;
    }

    public int getId_livre() {
        return id_livre;
    }

    public void setId_livre(int id_livre) {
        this.id_livre = id_livre;
    }

    public int getId_abonné() {
        return id_abonne;
    }

    public void setId_abonné(int id_abonné) {
        this.id_abonne = id_abonné;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    public reservation(int id_livre, int id_abonné, Date date_res, Date date_retour, String code, boolean statut) {
        this.id_livre = id_livre;
        this.id_abonne = id_abonné;
        this.date_res = date_res;
        this.date_retour = date_retour;
        this.code = code;
        this.statut = statut;
    }
    public reservation(){

    }

    @Override
    public String toString() {
        return "reservation{" +
                "id_res=" + id_res +
                ", id_livre=" + id_livre +
                ", id_abonné=" + id_abonne +
                ", date_res=" + date_res +
                ", date_retour=" + date_retour +
                ", code='" + code + '\'' +
                ", statut=" + statut +
                '}';
    }
}
