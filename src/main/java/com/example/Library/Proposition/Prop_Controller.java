package com.example.Library.Proposition;

import com.example.Library.Quote.quote;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class Prop_Controller {
    private final Proposition_service service;

    public Prop_Controller(Proposition_service service) {
        this.service = service;
    }

    @PostMapping("/add_proposition")
    public void find_quote_id(@RequestBody proposition p){
        service.add_proposition(p);
    }

    @GetMapping("/get_proposition")
    public List<proposition> get_proposition(){
        return service.get_all();
    }
    @PostMapping("/find_prop_by_titre")
    public List<proposition> find_prop_by_titre(@RequestBody String p){
        return  service.get_prop_by_titre(p);
    }
    @PostMapping("/find_prop_by_id")
    public proposition find_prop_by_id(@RequestBody int p){
        return  service.get_prop_by_id(p);
    }

    @PostMapping("/delete_prop_by_id")
    public void delete_prop_by_id(@RequestBody int p){
          service.delete_prop_by_id(p);
    }




}
