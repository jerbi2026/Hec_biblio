package com.example.Library.Livre;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class livre {
    @Id
    private int id_livre;
    private String titre;

    private int id_auteur;
    private String genre;
    private int nb_copie;
    private String image;
    private String description;
    private float prix;

    public livre() {

    }

    public int getId_livre() {
        return id_livre;
    }

    public void setId_livre(int id_livre) {
        this.id_livre = id_livre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getId_auteur() {
        return id_auteur;
    }

    public void setId_auteur(int id_auteur) {
        this.id_auteur = id_auteur;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getNb_copie() {
        return nb_copie;
    }

    public void setNb_copie(int nb_copie) {
        this.nb_copie = nb_copie;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public livre(String titre, int id_auteur, String genre, int nb_copie, String image, String description, float prix) {
        this.titre = titre;
        this.id_auteur = id_auteur;
        this.genre = genre;
        this.nb_copie = nb_copie;
        this.image = image;
        this.description=description;
        this.prix=prix;
    }

    @Override
    public String toString() {
        return "livre{" +
                "id_livre=" + id_livre +
                ", titre='" + titre + '\'' +
                ", id_auteur=" + id_auteur +
                ", genre='" + genre + '\'' +
                ", nb_copie=" + nb_copie +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                '}';
    }
}
