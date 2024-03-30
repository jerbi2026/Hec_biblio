package com.example.Library.Abonné;

import com.example.Library.Auteur.auteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Abonne_repositry extends JpaRepository <abonné ,Integer >{
    @Query("SELECT a FROM abonné a WHERE a.adresse_mail = :email")
    abonné findByEmail(@Param("email") String email);

    @Query("SELECT a FROM abonné a WHERE a.id_abonne = :id")
    abonné findByID(@Param("id") int id);

    @Query("SELECT a FROM abonné a WHERE LOWER(a.nom) LIKE CONCAT('%', LOWER(:nom), '%') AND LOWER(a.prenom) LIKE CONCAT('%', LOWER(:prenom), '%')")
    List<abonné> findByNomContainingOrPrenomContaining(@Param("nom") String nom, @Param("prenom") String prenom);


}
