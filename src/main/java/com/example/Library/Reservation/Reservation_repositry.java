package com.example.Library.Reservation;

import com.example.Library.Abonné.abonné;
import com.example.Library.Livre.livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface Reservation_repositry extends JpaRepository<reservation,Integer> {
    @Query("SELECT r FROM reservation r WHERE r.id_abonne = :id_abonne")
    List<reservation> findByAbonne_id(@Param("id_abonne") int id_abonne);

    @Query("SELECT r FROM reservation r WHERE r.id_res = :id_res")
    reservation find_by_id(@Param("id_res") int id_res);


    @Query("SELECT l.titre FROM livre l WHERE l.id_livre = ?1")
    String find_by_livre_id(int id);

    @Query("SELECT r FROM reservation r WHERE r.code = :code")
    reservation find_by_code(@Param("code") String code);


    @Query("SELECT r FROM reservation r WHERE r.date_retour < :date")
    List<reservation> findByDateRetourBefore(@Param("date") Date date);

    List<reservation> findByCodeContaining(String code);


    @Query("SELECT r.id_livre, COUNT(r) FROM reservation r GROUP BY r.id_livre")
    List<Object[]> countReservationsByLivre();

    @Query("SELECT l.genre, COUNT(r) FROM reservation r JOIN livre l ON r.id_livre = l.id_livre GROUP BY l.genre")
    List<Object[]> countReservationsByGenre();


}
