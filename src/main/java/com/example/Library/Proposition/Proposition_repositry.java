package com.example.Library.Proposition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Proposition_repositry extends JpaRepository<proposition,Integer> {
    List<proposition> findByTitreContainingIgnoreCase(String titre);

    @Query("SELECT p FROM proposition p WHERE p.id_prop = :id")
    proposition findByID(@Param("id") int id);

    @Query("SELECT a.nom, a.prenom, COUNT(p) FROM proposition p JOIN abonné a ON p.id_abonne = a.id_abonne GROUP BY a.nom, a.prenom")
    List<Object[]> findNomsAbonnesProposants();

}
