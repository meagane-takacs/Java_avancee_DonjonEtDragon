package com.example.demo.web.controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Personnage;


//affichage d'un personnage par son id
@RestController
public class PersonnageController {
    //Personnage/{id}
    @GetMapping(value ="Personnage/{id}")
    public Personnage afficherUnPersonnage(@PathVariable int id){
        Personnage personnage = new Personnage ( id, new String ("Gerard"),new String("Guerrier") );
        return personnage;
    }

}
