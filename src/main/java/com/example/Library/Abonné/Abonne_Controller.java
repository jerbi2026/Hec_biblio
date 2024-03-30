package com.example.Library.Abonné;

import com.example.Library.Auteur.Find_Request;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class Abonne_Controller {
    private final Abonne_service service;

    public Abonne_Controller(Abonne_service service) {
        this.service = service;
    }

    @PostMapping("/find_mail")
    public int find_mail(@RequestBody String email) {
        return service.find_abonne_by_mail(email);

    }

    @PostMapping("/change_password/{email}")
    public int changePassword(@PathVariable String email, @RequestBody Map<String, String> request) {
        String password = request.get("password");
        return service.change_password(password, email);
    }

    @PostMapping("/add_user")
    public int find_mail(@RequestBody abonné new_abonne) {
        return service.add_user(new_abonne);
    }

    @PostMapping("/login")
    public Front_abonne login(@RequestBody LoginRequest log_req) {
        return service.login(log_req);
    }

    @PostMapping("/get_abonne_connected")
    public abonne_connected get_abonne_connected(@RequestBody String mail) {
        return service.get_abonne_connected(mail);
    }

    @PostMapping("/get_abonne_by_id")
    public abonne_connected get_abonne_by_id(@RequestBody int id) {
        return service.get_abonne_by_id(id);
    }


    @PostMapping("/update_abonne")
    public int update_abonne(@RequestBody abonne_connected ab) {
        return service.update_abonne(ab);
    }

    @GetMapping("/get_nb_abonne")
    public int get_nb_abonne() {
        return service.get_nb_abonne();
    }


    @PostMapping("/get_abonne_by_name")
    public List<Front_abonne> get_abonne_by_name(@RequestBody Find_Request fr) {
        return service.get_abonne_by_name(fr);

    }

    @GetMapping("/get_abonne_all")
    public List<Front_abonne> get_all() {
        return service.get_all();

    }
    @PostMapping("/delete_abonne_by_id")
    public void delete_abonne_by_id(@RequestBody int id){
    service.delete_user(id);

    }

    @GetMapping("/nb_propostions/abonne")
    public Map<String, Integer> getNomsAbonnes_Proposants() {
        return service.getNomsAbonnesProposants();
    }








}
