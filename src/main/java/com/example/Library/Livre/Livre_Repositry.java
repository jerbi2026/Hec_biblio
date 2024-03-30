package com.example.Library.Livre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Livre_Repositry extends JpaRepository<livre,Integer> {
    List<livre> findByTitreContainingIgnoreCase(String titre);

    @Query("SELECT l FROM livre l WHERE l.id_auteur = ?1")
    List<livre> findByAuteurId(int idAuteur);

    @Query("SELECT l FROM livre l WHERE LOWER(l.genre) = LOWER(?1)")
    List<livre> findByGenre(String genre);

    @Query("SELECT l FROM livre l WHERE l.id_livre = ?1")
    livre FindByID(int id_livre);


    @Query("SELECT l.id_auteur, COUNT(l) FROM livre l GROUP BY l.id_auteur")
    List<Object[]> countLivresByAuteur();

    @Query("SELECT l.genre, COUNT(l) FROM livre l GROUP BY l.genre")
    List<Object[]> findNombreLivresParGenre();

    @Query("SELECT l.titre FROM livre l")
    List<String> get_livres_titres();


}
