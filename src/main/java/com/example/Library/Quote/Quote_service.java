package com.example.Library.Quote;

import com.example.Library.Auteur.auteur;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class Quote_service {
    private final quote_repositry repositry;


    public Quote_service(quote_repositry service) {
        this.repositry = service;
    }

    public List<quote> get_quotes(){
        return repositry.findAll();
    }

    public quote get_quote_by_id(int id){
        if(repositry.findById(id)!=null){
            Optional<quote> optionalQuote = repositry.findById(id);
            quote quote = optionalQuote.orElseThrow(() -> new RuntimeException("Auteur non trouvé pour l'ID : " + id));
            return quote;

        }
        else{
            return null;
        }
    }

    public List<quote> get_quotes_livre(int id){
        return repositry.findByIdLivre(id);
    }

    public List<quote> get_quotes_id_auteur(int id){
        return repositry.findByIdAuteur(id);
    }

    public int nb_quotes(){
        return repositry.findAll().size();
    }

    public List<quote> get_all_quotes(){
        return repositry.findAll();
    }


    public  void delete_quote(quote q){
        repositry.delete(q);
    }

    public  void add_quote(quote q){
        repositry.save(q);
    }










}
