package com.example.Library.Manager;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class manager {
    @Id
    private int id_manager;
    private String nom;
    private String prenom;
    private String adresse;
    private String numero;
    private String adresse_mail;
    private String mot_de_passe;
    private  String image;


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAdresse_mail() {
        return adresse_mail;
    }

    public void setAdresse_mail(String adresse_mail) {
        this.adresse_mail = adresse_mail;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public manager(String nom, String prenom, String adresse, String numero, String adresse_mail, String mot_de_passe, String image) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.numero = numero;
        this.adresse_mail = adresse_mail;
        this.mot_de_passe = mot_de_passe;
        this.image = image;
    }

    public int getId_manager() {
        return id_manager;
    }

    public void setId_manager(int id_manager) {
        this.id_manager = id_manager;
    }



    public manager(){

    }


}
