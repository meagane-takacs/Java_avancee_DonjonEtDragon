package com.example.demo.web.controller;
import com.example.demo.dao.PersonnageDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Personnage;
import java.util.ArrayList;
import java.util.List;

//affichage d'un personnage par son id
@Api(description = "coucou")
@RestController

public class PersonnageController
{
    // Membres
    private ArrayList<Personnage> listPersonnages;


    // Methodes

    @Autowired
    private PersonnageDao personnageDao;

    //Personnage/{id}
    //@ApiOperation(value ="coucou2")
    @GetMapping(value ="Personnage/{id}")
    public Personnage findById(@PathVariable int id)
    {
        //Personnage personnage = new Personnage ( id, new String ("Gerard"),new String("Guerrier") );
        //return personnage;

        return personnageDao.findById(id);
    }

    //tous les personnages
    //Personnage/list
    @GetMapping(value ="Personnage/list")
    public List<Personnage> afficherListePersonnages()
    {
        return personnageDao.findAll();
    }

    //Personnages en post qui sert à ajouter un personnage
    @PostMapping(value = "Personnage/list")
    public void creerPersonnage( @RequestBody Personnage personnage)
    {
        personnageDao.save(personnage);
    }

    @PutMapping(value = "Personnage/modifier/{id}")
    public void modifierPersonnage( @RequestBody Personnage personnage, @PathVariable int id)
    {
        personnageDao.modify(id, personnage);
    }

    @DeleteMapping(value= "Personnage/supprimer/{id}")
    public void supprimerPersonnage(@PathVariable int id)
    {
        personnageDao.delete(id);
    }

}

