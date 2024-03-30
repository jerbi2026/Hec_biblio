package com.example.Library.Manager;

import com.example.Library.Abonné.abonné;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Manager_repositry extends JpaRepository<manager,Integer> {
    @Query("SELECT a FROM manager a WHERE a.adresse_mail = :email")
    manager findByEmail(@Param("email") String email);

    @Query("SELECT a FROM manager a WHERE a.id_manager = :id")
    manager findByID(@Param("id") int id);
}
