package com.example.Library.Abonné;
import com.example.Library.Auteur.Find_Request;
import com.example.Library.Proposition.Proposition_repositry;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class Abonne_service {

    private final Abonne_repositry repositry ;

    private final Proposition_repositry proposition_repositry;



    public Abonne_service(Abonne_repositry repositry, Proposition_repositry propositionRepositry) {
        this.repositry = repositry;
        proposition_repositry = propositionRepositry;
    }

    public int find_abonne_by_mail(String email){


        abonné abonne = repositry.findByEmail(email);
        if (abonne != null) {
            return 1;
        } else {
            return 0;
        }
    }

    public int change_password(String password,String email){
        abonné abonne = repositry.findByEmail(email);

        if (abonne != null) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(password);

            abonne.setMot_de_passe(hashedPassword);
            repositry.save(abonne);
            return 1;
        } else {
            return 0;
        }


    }

    public int add_user(abonné new_abonne){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(new_abonne.getMot_de_passe());
        new_abonne.setMot_de_passe(hashedPassword);
        int find = find_abonne_by_mail(new_abonne.getAdresse_mail());
        if(find==1){
            System.out.println("Mail existe deja ");
        }
        else{
            repositry.save(new_abonne);

        }
        return find;

    }

    public Front_abonne login(LoginRequest lr){
        abonné abn = repositry.findByEmail(lr.getEmail());
        if(BCrypt.checkpw(lr.getPassword(),abn.getMot_de_passe())==true){
            return new Front_abonne(abn.getId_abonne(),abn.getNom(),abn.getPrenom(),abn.getAdresse(),abn.getNumero(),abn.getAdresse_mail(),abn.getImage());
        }
        else{
            return null;
        }

    }

    public abonne_connected get_abonne_connected(String mail){
        abonné ab = repositry.findByEmail(mail);
        if(ab!=null){
            return new abonne_connected(ab.getId_abonne(),ab.getNom(), ab.getPrenom(), ab.getAdresse(),ab.getNumero(),ab.getAdresse_mail(),ab.getImage());
        }
        else{
            return null;
        }


    }

    public abonne_connected get_abonne_by_id(int id){
        abonné ab = repositry.findByID(id);
        if(ab!=null){
            return new abonne_connected(ab.getId_abonne(),ab.getNom(), ab.getPrenom(), ab.getAdresse(),ab.getNumero(),ab.getAdresse_mail(),ab.getImage());
        }
        else{
            return null;
        }


    }


    public int update_abonne(abonne_connected abonneConnected){
        abonné ab = repositry.findByEmail(abonneConnected.getAdresse_mail());

        if(ab!=null){
            ab.setAdresse(abonneConnected.getAdresse());
            ab.setImage(abonneConnected.getImage());
            ab.setNumero(abonneConnected.getNumero());
            ab.setNom(abonneConnected.getNom());
            ab.setPrenom(abonneConnected.getPrenom());
            repositry.save(ab);
            return 1;
        }
        else{
            return 0;
        }



    }

    public int get_nb_abonne(){
        return repositry.findAll().size();

    }


    public List<Front_abonne> get_abonne_by_name(Find_Request fr){
        List<abonné> liste_abonne= repositry.findByNomContainingOrPrenomContaining(fr.getNom(), fr.getPrenom());
        List<Front_abonne> front_list = new ArrayList<Front_abonne>();

        for(int i =0;i<liste_abonne.size();i++){

            Front_abonne frnt_ab = new Front_abonne(liste_abonne.get(i).getId_abonne(),liste_abonne.get(i).getNom(),liste_abonne.get(i).getPrenom(),liste_abonne.get(i).getAdresse(),liste_abonne.get(i).getNumero(),liste_abonne.get(i).getAdresse_mail(),liste_abonne.get(i).getImage());
            front_list.add(frnt_ab);
        }
        return front_list;
    }



    public List<Front_abonne> get_all(){
        List<abonné> liste_abonne= repositry.findAll();
        List<Front_abonne> front_list = new ArrayList<Front_abonne>();
        for(int i =0;i<liste_abonne.size();i++){
            Front_abonne frnt_ab = new Front_abonne(liste_abonne.get(i).getId_abonne(),liste_abonne.get(i).getNom(),liste_abonne.get(i).getPrenom(),liste_abonne.get(i).getAdresse(),liste_abonne.get(i).getNumero(),liste_abonne.get(i).getAdresse_mail(),liste_abonne.get(i).getImage());
            front_list.add(frnt_ab);
        }
        return front_list;
    }

    public void delete_user(int id_abonne){
        abonné ab = repositry.findByID(id_abonne);
        repositry.delete(ab);


    }

    public Map<String, Integer> getNomsAbonnesProposants() {
        List<Object[]> results = proposition_repositry.findNomsAbonnesProposants();
        Map<String, Integer> nomsAbonnesProposants = new HashMap<>();
        for (Object[] row : results) {
            String nomComplet = (String) row[0] + " " + (String) row[1];
            Long nombrePropositions = (Long) row[2];
            nomsAbonnesProposants.put(nomComplet, nombrePropositions.intValue());
        }
        return nomsAbonnesProposants;
    }








}
