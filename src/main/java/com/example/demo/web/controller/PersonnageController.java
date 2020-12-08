package com.example.demo.web.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Personnage;
import java.util.ArrayList;

//affichage d'un personnage par son id
@RestController
public class PersonnageController
{
    // Membres
    private ArrayList<Personnage> listPersonnages;

    // Constructeur
    public PersonnageController()
    {
        this.listPersonnages = new ArrayList<>();

        Personnage personnage0 = new Personnage ( 0, new String ("Gerard"),new String("Guerrier") );
        Personnage personnage1 = new Personnage ( 1, new String ("Jose"),new String("Magicien") );
        Personnage personnage2 = new Personnage ( 2, new String ("Bernard"),new String("Guerrier") );

        this.listPersonnages.add(personnage0);
        this.listPersonnages.add(personnage1);
        this.listPersonnages.add(personnage2);

    }

    // Methodes

    //Personnage/{id}
    @GetMapping(value ="Personnage/{id}")
    public Personnage findById(@PathVariable int id)
    {
        //Personnage personnage = new Personnage ( id, new String ("Gerard"),new String("Guerrier") );
        //return personnage;

        return listPersonnages.get(id);
    }

    //tous les personnages
    //Personnage/list
    @GetMapping(value ="Personnage/list")
    public ArrayList<Personnage> afficherListePersonnages()
    {
        return listPersonnages;
    }

    //Personnages en post qui sert à ajouter un personnage
    @PostMapping(value = "Personnage/list")
    public void creerPersonnage( @RequestBody Personnage personnage)
    {
        listPersonnages.add(personnage);
    }

    @PutMapping(value = "Personnage/modifier/{id}")
    public void modifierPersonnage( @RequestBody Personnage personnage, @PathVariable int id)
    {
        listPersonnages.set(id, personnage);
    }

    @DeleteMapping(value= "Personnage/supprimer/{id}")
    public void supprimerPersonnage(@PathVariable int id)
    {
        listPersonnages.remove(id);
    }

}

