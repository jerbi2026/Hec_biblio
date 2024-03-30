package com.example.Library.Reservation;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class Reservation_Controller {
    private final Reservation_service service;


    public Reservation_Controller(Reservation_service service) {
        this.service = service;
    }

    @PostMapping("/add_reservation")
    public void add_reservation(@RequestBody reservation r){
        service.add_reservation(r);
    }

    @PostMapping("/get_reservation_id_abonne")
    public List<Reservation_front> get_reservation_id_abonne(@RequestBody int id_abonne){
        return service.send_reservation(id_abonne);
    }

    @PostMapping("/get_nb_reservation_abonne")
    public int get_nb_reservation_abonne(@RequestBody int id_abonne){
        return service.nb_reservation_abonne(id_abonne);
    }

    @PostMapping("/delete_reservation_code")
    public int delete_reservation(@RequestBody String code){
        return service.delete_reservation(code);
    }

    @PostMapping("/get_nb_reservation_abonne_valide")
    public int get_nb_reservation_abonne_valide(@RequestBody int id_abonne){
        return service.nb_reservation_abonne_valide(id_abonne);
    }

    @PostMapping("/get_nb_reservation_abonne_non_valide")
    public int get_nb_reservation_abonne_non_valide(@RequestBody int id_abonne){
        return service.nb_reservation_abonne_non_valide(id_abonne);
    }

    @GetMapping("/get_all_reservation")
    public List<reservation> get_all_reservation(){
        return service.get_all_reservation();
    }

    @GetMapping("/get_reservation_date_limite")
    public List<reservation> get_reservation_date_limite(){
        return service.getReservationsDue();
    }

    @PostMapping("/valider_reservation")
    public void valider_reservation(@RequestBody Integer id_res){
        System.out.println(id_res);
         service.valider_reservation(id_res);
    }

    @PostMapping("/get_reservation_by_code")
    public List<reservation> get_reservation_by_code(@RequestBody String code){
        return service.get_reservation_by_code(code);
    }

    @GetMapping("/nb_reservations/livre")
    public Map<String, Integer> nb_reservations_per_livre() {
        return service.getNombreReservationsParLivre();
    }

    @GetMapping("/nb_reservations/genre")
    public Map<String, Integer> nb_reservations_per_genre() {
        return service.getNombreReservationsParGenre();
    }

    @PostMapping("/get_reservation_by_id")
    public reservation get_reservation_by_id(@RequestBody int id){
        return service.find_reservation_by_id(id);
    }
}
