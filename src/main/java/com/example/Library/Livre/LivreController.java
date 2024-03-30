package com.example.Library.Livre;

import com.example.Library.Auteur.auteur;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class LivreController {
    private final Livre_Service service;

    public LivreController(Livre_Service service) {
        this.service = service;
    }

    @GetMapping("/get_livres")
    public List<livre> find_mail(){
        return service.get_livres();

    }

    @PostMapping("/add_livre")
    public void add_livre(@RequestBody livre livre)
    {
        service.add_livre(livre);
    }

    @PostMapping("/find_livre_1")
    public List<livre> find_livre_titre(@RequestBody String titre){
        return  service.find_by_titre(titre);
    }

    @GetMapping("/get_genres")
    public List<String> get_genres(){
        return service.getDistinctGenres();
    }

    @PostMapping("/find_livre_id")
    public livre find_livre_id(@RequestBody int id){
        return service.get_livre_by_id(id);

    }

    @PostMapping("/find_livre_id_auteur")
    public List<livre> find_livre_id_auteur(@RequestBody int id){
        return service.get_livres_by_id_auteur(id);

    }

    @PostMapping("/find_livre_by_genre")
    public List<livre> find_livre_by_genre(@RequestBody String genre){
        return service.get_livre_by_genre(genre);

    }

    @GetMapping("/get_nb_livres")
    public int get_nb_livres(){
        return service.nb_livres();
    }

    @GetMapping("/get_nb_genres")
    public int get_nb_genres(){
        return service.nb_genres();
    }

    @PostMapping("/update_livre")
    public void find_livre_by_genre(@RequestBody livre l){
         service.update_livre(l);

    }

    @PostMapping("/delete_livre")
    public void delete_livre(@RequestBody livre l){
        service.delete_livre(l);

    }

    @GetMapping("/livres/genres")
    public Map<String, List<livre>> getLivresByGenres() {
        return service.getLivresByGenres();
    }

    @GetMapping("/livres/nb_auteurs")
    public Map<String, Integer>  nb_auteurs_per_livre() {
        return service.getNombreLivresParAuteurs();
    }

    @GetMapping("/nombre-par-genre")
    public ResponseEntity<Map<String, Integer>> getNombreLivresParGenre() {
        Map<String, Integer> nombreLivresParGenre = service.getNombreLivresParGenre();
        return ResponseEntity.ok().body(nombreLivresParGenre);
    }

    @GetMapping ("/get_livres_titres")
    public List<String> get_livres_titres(){
        return service.get_titres_livre();
    }


    





}
