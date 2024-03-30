package com.example.Library.Auteur;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class auteur {
    @Id
    private int id_auteur;
    private String nom;
    private String prenom;
    private String nationalite;
    private String image;

    public int getId_auteur() {
        return id_auteur;
    }

    public void setId_auteur(int id_auteur) {
        this.id_auteur = id_auteur;
    }

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

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public auteur(String nom, String prenom, String nationalite, String image) {
        this.nom = nom;
        this.prenom = prenom;
        this.nationalite = nationalite;
        this.image = image;
    }
    public auteur(){

    }
}
