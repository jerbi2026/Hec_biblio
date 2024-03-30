package com.example.Library.Auteur;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Auteur_Service {
    private final AuteurRepositry repositry;

    public Auteur_Service(AuteurRepositry repositry) {
        this.repositry = repositry;
    }

    public List<auteur> get_auteurs(){
        return repositry.findAll();
    }
    public List<auteur> find_by_name(Find_Request fr){
        return repositry.findByNomContainingOrPrenomContaining(fr.getNom(), fr.getNom());

    }
    public List<auteur> find_by_nationalite(String nationalite){
        return repositry.findByNationalite(nationalite);

    }

    public auteur find_auteur_by_id(int id){

        if(repositry.findById(id)!=null && id!=0){
            Optional<auteur> optionalAuteur = repositry.findById(id);
            auteur aut = optionalAuteur.orElseThrow(() -> new RuntimeException("Auteur non trouvé pour l'ID : " + id));
            return aut;

        }
        else{
            return null;
        }

    }

    public int nb_auteurs(){
        return repositry.findAll().size();
    }


    public List<String> auteurs_nom_prenom(){
        List<String> liste_auteurs_ret = new ArrayList<String>();
        List<auteur> liste_auteurs = repositry.findAll();
        for(int i=0;i<liste_auteurs.size();i++){
            liste_auteurs_ret.add(liste_auteurs.get(i).getPrenom()+" "+liste_auteurs.get(i).getNom());
        }
        return liste_auteurs_ret;

    }

    public int retourner_id_auteur(String name){

        List<auteur> liste_auteurs = get_auteurs();
        for(int i=0;i<liste_auteurs.size();i++){
            String username = liste_auteurs.get(i).getPrenom()+' '+liste_auteurs.get(i).getNom();


            if(username.equals(name)==true){

                return liste_auteurs.get(i).getId_auteur();
            }
        }
        return 0;

    }

    public void update_auteur(auteur aut){
        auteur autr = find_auteur_by_id(aut.getId_auteur());
        if(autr!=null){
            autr.setImage(aut.getImage());
            autr.setNom(aut.getNom());
            autr.setPrenom(aut.getPrenom());
            autr.setNationalite(aut.getNationalite());
            repositry.save(autr);
        }


    }

    public void delete_auteur(auteur aut){
        auteur autr = find_auteur_by_id(aut.getId_auteur());
        if(autr!=null){
            repositry.delete(autr);
        }
    }

    public void add_auteur(auteur aut){
        repositry.save(aut);

    }


}
