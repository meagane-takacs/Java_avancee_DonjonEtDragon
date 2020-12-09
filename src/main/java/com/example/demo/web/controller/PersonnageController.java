package com.example.demo.web.controller;
import com.example.demo.dao.PersonnageDao;
import com.example.demo.exception.ResourceNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Personnage;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public Personnage findById(@PathVariable int id) throws ResourceNotFoundException {
        //Personnage personnage = new Personnage ( id, new String ("Gerard"),new String("Guerrier") );
        //return personnage;
        Personnage resultat = personnageDao.findById(id);

        if( resultat == null )
        {
            throw new ResourceNotFoundException("Pas de personnage id "+id);
        }

        return resultat ;
    }

    //tous les personnages
    //Personnage/list
    @GetMapping(value ="Personnage/list")
    public List<Personnage> afficherListePersonnages()
    {
        RestTemplate restTemplate = new RestTemplate();

        return personnageDao.findAll().stream().map( perso -> {
            // Pour tous les personnages renvoyés par personnageDao.finAll(), qu'on manipule un par un
            // On appelle sur ce serveur "Personnage/id", et on s'attend à avoir en retour un personnage
            Personnage personnage = restTemplate.getForObject("http://localhost:8081/Personnage/"+perso.getId(), Personnage.class);
            // On retourne une copie de ce personnage
            return new Personnage(personnage.getId(), personnage.getNom(), personnage.getType());
        }).collect(Collectors.toList());
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

