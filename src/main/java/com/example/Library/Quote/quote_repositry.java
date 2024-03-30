package com.example.Library.Quote;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface quote_repositry extends JpaRepository<quote,Integer> {
    @Query("SELECT q FROM quote q WHERE q.id_livre = :idLivre")
    List<quote> findByIdLivre(Integer idLivre);

    @Query("SELECT q FROM quote q WHERE q.id_auteur = :idAuteur")
    List<quote> findByIdAuteur(Integer idAuteur);

}
