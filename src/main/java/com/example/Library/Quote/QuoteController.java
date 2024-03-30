package com.example.Library.Quote;

import com.example.Library.Auteur.auteur;
import com.example.Library.Livre.livre;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping
public class QuoteController {
    private final Quote_service service;

    public QuoteController(Quote_service service) {
        this.service = service;
    }
    @GetMapping("/get_quotes")
    public List<quote> get_quotes(){
        return service.get_quotes();

    }

    @PostMapping("/find_quote_id")
    public quote find_quote_id(@RequestBody int id){
        return service.get_quote_by_id(id);

    }

    @PostMapping("/find_quote_livre_id")
    public List<quote> find_quote_livre_id(@RequestBody int id){
        return service.get_quotes_livre(id);

    }
    @PostMapping("/find_quote_auteur_id")
    public List<quote> find_quote_auteur_id(@RequestBody int id){
        return service.get_quotes_id_auteur(id);

    }


    @GetMapping("get_all_quotes")
    public List<quote> get_all_quotes(){
        return service.get_all_quotes();
    }

    @PostMapping("/delete_quote")
    public void delete_quote(@RequestBody quote quote){
         service.delete_quote(quote);

    }

    @PostMapping("/add_quote")
    public void add_quote(@RequestBody quote quote){
        service.add_quote(quote);

    }
}
