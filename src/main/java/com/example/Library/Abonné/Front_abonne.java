package com.example.Library.Abonné;

public class Front_abonne {
    private int id_abonne;
    private String nom;
    private String prenom;
    private String adresse;
    private String numero;
    private String adresse_mail;
    private  String image;

    public Front_abonne(int id_abonne, String nom, String prenom, String adresse, String numero, String adresse_mail, String image) {
        this.id_abonne = id_abonne;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.numero = numero;
        this.adresse_mail = adresse_mail;
        this.image = image;
    }

    public int getId_abonné() {
        return id_abonne;
    }

    public void setId_abonné(int id_abonne) {
        this.id_abonne = id_abonne;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Front_abonne{" +
                "id_abonné=" + id_abonne +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", numero='" + numero + '\'' +
                ", adresse_mail='" + adresse_mail + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
