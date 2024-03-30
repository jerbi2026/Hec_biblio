package com.example.Library.Proposition;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Proposition_service {
    private final Proposition_repositry repositry;

    public Proposition_service(Proposition_repositry repositry) {
        this.repositry = repositry;
    }

    public void add_proposition(proposition p){
        this.repositry.save(p);
    }

    public List<proposition> get_all(){
        return repositry.findAll();
    }

    public List<proposition> get_prop_by_titre(String titre){
        System.out.println(titre);
        return repositry.findByTitreContainingIgnoreCase(titre);
    }

    public proposition get_prop_by_id(int id){
        return (proposition) repositry.findByID(id);

    }

    public void delete_prop_by_id(int id){
        proposition p =  repositry.findByID(id);
        repositry.delete(p);

    }




}
