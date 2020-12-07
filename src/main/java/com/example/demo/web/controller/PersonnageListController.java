package com.example.demo.web.controller;

import com.example.demo.model.Personnage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonnageListController {
    //Personnage/list
    @GetMapping(value ="Personnage/list")
    public Personnage[] afficherListePersonnages(){
        Personnage personnage0 = new Personnage ( 0, new String ("Gerard"),new String("Guerrier") );
        Personnage personnage1 = new Personnage ( 1, new String ("Gerard"),new String("Guerrier") );
        Personnage personnage2 = new Personnage ( 2, new String ("Gerard"),new String("Guerrier") );

        Personnage[] listPersonnages = {personnage0, personnage1, personnage2};

        return listPersonnages;
    }

}