package com.example.Library.Manager;


import com.example.Library.Abonné.abonné;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class Manager_service {
    private final Manager_repositry repositry;

    public Manager_service(Manager_repositry repositry) {
        this.repositry = repositry;
    }



    public Front_Manager login(LoginRequest lr){
        manager manager = repositry.findByEmail(lr.getEmail());
        if(manager!=null){

            if(BCrypt.checkpw(lr.getPassword(),manager.getMot_de_passe())==true){
                return new Front_Manager(manager.getId_manager(),manager.getNom(),manager.getPrenom(),manager.getAdresse(),manager.getNumero(),manager.getAdresse_mail(),manager.getImage());
            }
            else{

                return null;
            }


        }
        else{
            return null;
        }

    }


    public Front_Manager get_front_manager(String mail){
        manager manager = repositry.findByEmail(mail);
        if(manager!=null){
            return new Front_Manager(manager.getId_manager(),manager.getNom(),manager.getPrenom(),manager.getAdresse(),manager.getNumero(),manager.getAdresse_mail(),manager.getImage());
 }
        else{
            return null;
        }

    }

    public int update_manager(Front_Manager fr){
        manager ab = repositry.findByEmail(fr.getAdresse_mail());

        if(ab!=null){
            ab.setAdresse(fr.getAdresse());
            ab.setImage(fr.getImage());
            ab.setNumero(fr.getNumero());
            ab.setNom(fr.getNom());
            ab.setPrenom(fr.getPrenom());
            repositry.save(ab);
            return 1;
        }
        else{
            return 0;
        }

    }







}
