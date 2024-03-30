package com.example.Library.Proposition;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class proposition {
    @Id
    private int id_prop;
    private String titre;
    private String genre;
    private String auteur;
    private int id_abonne;

    public proposition() {

    }

    public int getId_abonné() {
        return id_abonne;
    }

    public void setId_abonné(int id_abonné) {
        this.id_abonne = id_abonné;
    }

    public int getId_prop() {
        return id_prop;
    }

    public void setId_prop(int id_prop) {
        this.id_prop = id_prop;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public proposition(String titre, String genre, String auteur,int id_abonne) {
        this.titre = titre;
        this.genre = genre;
        this.auteur = auteur;
        this.id_abonne=id_abonne;
    }
}
