package com.example.Library.Quote;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class quote {
    @Id
    private int id_quote;
    private String quote;
    private int id_auteur;
    private int id_livre;

    public int getId_quote() {
        return id_quote;
    }

    public void setId_quote(int id_quote) {
        this.id_quote = id_quote;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public int getId_auteur() {
        return id_auteur;
    }

    public void setId_auteur(int id_auteur) {
        this.id_auteur = id_auteur;
    }

    public int getId_livre() {
        return id_livre;
    }

    public void setId_livre(int id_livre) {
        this.id_livre = id_livre;
    }

    public quote(String quote, int id_auteur, int id_livre) {
        this.quote = quote;
        this.id_auteur = id_auteur;
        this.id_livre = id_livre;
    }
    public quote(){

    }
}
