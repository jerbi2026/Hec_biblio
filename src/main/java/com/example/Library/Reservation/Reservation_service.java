package com.example.Library.Reservation;

import com.example.Library.Livre.Livre_Repositry;
import com.example.Library.Livre.Livre_Service;
import com.example.Library.Livre.livre;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Reservation_service {
    private final Reservation_repositry repositry;
    private final Livre_Repositry livre_rep;


    private final Livre_Service livre_service;

    public Reservation_service(Reservation_repositry repositry, Livre_Repositry livreRep, Livre_Service livreService) {
        this.repositry = repositry;
        livre_rep = livreRep;
        livre_service = livreService;
    }

    public void add_reservation(reservation r){
        repositry.save(r);
    }

    public List<reservation> get_list_id_abonne(int id_abonne){
        return repositry.findByAbonne_id(id_abonne);

    }

    public int nb_reservation_abonne(int id_abonne){
        List<reservation> list= repositry.findByAbonne_id(id_abonne);
        return list.size();

    }

    public List<Reservation_front> send_reservation(int id_abonne){
        List<reservation> list_res  =repositry.findByAbonne_id(id_abonne);
        List<Reservation_front> list_reservation = new ArrayList<Reservation_front>();

        for(int i =0 ;i<list_res.size();i++){
            String statut = "";
            if(list_res.get(i).isStatut()==true){
                statut="Payed";
            }
            else{
                statut="Not Payed";
            }
            String livre = repositry.find_by_livre_id(list_res.get(i).getId_livre());
            Reservation_front res = new Reservation_front(list_res.get(i).getCode(),livre,list_res.get(i).getDate_res(),list_res.get(i).getDate_retour(),statut);
            list_reservation.add(res);

        }
        return list_reservation;

    }

    public int delete_reservation(String code){
        reservation r = repositry.find_by_code(code);
        if(r!=null){
            repositry.delete(r);
            return 1;
        }
        else{
            return 0;
        }

    }
    public int nb_reservations(){
        return repositry.findAll().size();
    }

    public int nb_reservation_abonne_valide(int id_abonne){
        List<reservation> list= repositry.findByAbonne_id(id_abonne);
        int somme=0;
        for(int i =0 ;i<list.size();i++){
            if(list.get(i).isStatut()==true){
                somme++;
            }
        }
        return somme;

    }

    public int nb_reservation_abonne_non_valide(int id_abonne){
        List<reservation> list= repositry.findByAbonne_id(id_abonne);
        int somme=0;
        for(int i =0 ;i<list.size();i++){
            if(list.get(i).isStatut()==false){
                somme++;
            }
        }
        return somme;

    }

    public List<reservation> get_all_reservation(){
        return repositry.findAll();

    }

    public reservation find_reservation_by_id(int id){
        return repositry.find_by_id(id);
    }
    public  void valider_reservation(int id_res){
        reservation r = repositry.find_by_id(id_res);
        livre l = livre_rep.FindByID(r.getId_livre());
        l.setNb_copie(l.getNb_copie()-1);
        r.setStatut(true);

        repositry.save(r);
        livre_rep.save(l);
    }

    public List<reservation> getReservationsDue() {
        Date today = new Date();
        return repositry.findByDateRetourBefore(today);
    }

    public List<reservation> get_reservation_by_code(String code){
        return repositry.findByCodeContaining(code);

    }

    public Map<String, Integer> getNombreReservationsParLivre() {
        List<Object[]> results = repositry.countReservationsByLivre();
        Map<String, Integer> nbReservationsParLivre = new HashMap<>();


        for (Object[] result : results) {
            Integer livre_id = (Integer) result[0];
            livre l = livre_service.get_livre_by_id(livre_id);

            Long nbReservations = (Long) result[1];

            String titreLivre = l.getTitre();
            nbReservationsParLivre.put(titreLivre, nbReservations.intValue());
        }

        return nbReservationsParLivre;
    }

    public Map<String, Integer> getNombreReservationsParGenre() {
        List<Object[]> results = repositry.countReservationsByGenre();
        Map<String, Integer> nbReservationsParGenre = new HashMap<>();

        for (Object[] result : results) {
            String genre = (String) result[0];
            Long nbReservations = (Long) result[1];
            nbReservationsParGenre.put(genre, nbReservations.intValue());
        }

        return nbReservationsParGenre;
    }







}
