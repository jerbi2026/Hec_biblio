package com.example.Library.Auteur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuteurRepositry extends JpaRepository<auteur,Integer> {
    List<auteur> findByNomContainingOrPrenomContaining(String nom, String prenom);
    List<auteur> findByNationalite(String nationalite);

    @Query("SELECT a FROM auteur a WHERE CONCAT(a.nom, ' ', a.prenom) LIKE %:name%")
    auteur findByNomAndPrenom(@Param("name") String name);

}
