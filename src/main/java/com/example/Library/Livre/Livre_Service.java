package com.example.Library.Livre;

import com.example.Library.Auteur.Auteur_Service;
import com.example.Library.Auteur.auteur;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Livre_Service {

    private final Livre_Repositry repositry;

    private final Auteur_Service auteur_service;


    public Livre_Service(Livre_Repositry repositry, Auteur_Service auteurService) {
        this.repositry = repositry;
        auteur_service = auteurService;
    }

    public List<livre> get_livres(){
        return repositry.findAll();
    }


    public void add_livre(livre livre){
        repositry.save(livre);


    }


    public List<livre> find_by_titre(String titre){
        return repositry.findByTitreContainingIgnoreCase(titre);

    }
    public List<String> getDistinctGenres() {
        List<String> genres = repositry.findAll()
                .stream()
                .map(livre::getGenre)
                .distinct()
                .collect(Collectors.toList());
        return genres;
    }


    public livre get_livre_by_id(int id){
        if(repositry.findById(id)!=null){
            Optional<livre> optionallivre = repositry.findById(id);
            livre livre = optionallivre.orElseThrow(() -> new RuntimeException("livre non trouvé pour l'ID : " + id));
            return livre;

        }
        else{
            return null;
        }
    }

    public List<livre> get_livres_by_id_auteur(int id){
        return repositry.findByAuteurId(id);
    }

    public List<livre> get_livre_by_genre(String genre){
        return repositry.findByGenre(genre);
    }

    public int nb_livres(){
        return repositry.findAll().size();
    }

    public int nb_genres(){
        return getDistinctGenres().size();
    }


    public void update_livre(livre l){
        livre liv = (livre) repositry.FindByID(l.getId_livre());
        liv.setDescription(l.getDescription());
        liv.setGenre(l.getGenre());
        liv.setPrix(l.getPrix());
        liv.setImage(l.getImage());
        liv.setTitre(l.getTitre());
        liv.setNb_copie(l.getNb_copie());
        liv.setId_auteur(l.getId_auteur());
       repositry.save(liv);

    }

    public void delete_livre(livre l){
        livre liv = (livre) repositry.FindByID(l.getId_livre());
        repositry.delete(liv);
    }

    public Map<String, List<livre>> getLivresByGenres() {
        Map<String, List<livre>> livresByGenres = new HashMap<>();
        List<String> genres = getDistinctGenres();

        for (String genre : genres) {
            List<livre> livres = repositry.findByGenre(genre);
            livresByGenres.put(genre, livres);
        }

        return livresByGenres;
    }

    public Map<String, Integer> getNombreLivresParAuteurs() {
        List<Object[]> results = repositry.countLivresByAuteur();
        Map<String, Integer> nbLivresParAuteurs = new HashMap<>();

        for (Object[] result : results) {

            Integer auteurId = (Integer) result[0];
            if(auteurId!=0){
                auteur a = auteur_service.find_auteur_by_id(auteurId);

                String auteur = a.getNom()+" "+a.getPrenom();

                Long nbLivres = (Long) result[1];
                nbLivresParAuteurs.put(auteur, nbLivres.intValue());

            }

        }

        return nbLivresParAuteurs;
    }

    public Map<String, Integer> getNombreLivresParGenre() {
        List<Object[]> results = repositry.findNombreLivresParGenre();
        Map<String, Integer> nombreLivresParGenre = new HashMap<>();
        for (Object[] row : results) {
            String genre = (String) row[0];
            Long nombreLivres = (Long) row[1];
            nombreLivresParGenre.put(genre, nombreLivres.intValue());
        }
        return nombreLivresParGenre;
    }

    public List<String> get_titres_livre(){
        return repositry.get_livres_titres();
    }








}
