package com.example.Library.Auteur;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class AuteurController {
    private final Auteur_Service service;

    public AuteurController(Auteur_Service service) {
        this.service = service;
    }
    @GetMapping("/get_auteurs")
    public List<auteur> get_auteur(){
        return service.get_auteurs();

    }
    @PostMapping("/find_auteur_name")
    public List<auteur> find_auteur(@RequestBody Find_Request fr){
        return service.find_by_name(fr);

    }
    @PostMapping("/find_auteur_nationalite")
    public List<auteur> find_auteur_nationalite(@RequestBody String nationalite){
        return service.find_by_nationalite(nationalite);

    }

    @PostMapping("/find_auteur_id")
    public auteur find_auteur_id(@RequestBody int id){
        return service.find_auteur_by_id(id);

    }

    @GetMapping("/get_liste_auteurs_add")
    public List<String> get_liste_auteurs_add(){
        return service.auteurs_nom_prenom();
    }

    @PostMapping("/get_id_auteur_by_name")
    public int get_id_auteur_by_name(@RequestBody String name){
        return service.retourner_id_auteur(name);

    }

    @GetMapping("/get_nb_auteurs")
    public int get_nb_auteurs()
    {
        return service.get_auteurs().size();
    }

    @PostMapping("/update_auteur")
    public void update_auteur(@RequestBody auteur aut){
        service.update_auteur(aut);

    }

    @PostMapping("/delete_auteur")
    public void delete_auteur(@RequestBody auteur aut){
        service.delete_auteur(aut);
    }

    @PostMapping("/add_auteur")
    public void add_auteur(@RequestBody auteur aut){
        service.add_auteur(aut);
    }




}
