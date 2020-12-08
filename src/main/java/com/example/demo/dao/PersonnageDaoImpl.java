package com.example.demo.dao;

import com.example.demo.model.Personnage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class PersonnageDaoImpl implements PersonnageDao {

    public static List<Personnage> personnages = new ArrayList<>();
    static
    {
        personnages.add(new Personnage(1, new String("Merlin"), new String("Magicien")));
        personnages.add(new Personnage(2, new String("Bobby"), new String("Warrior")));
        personnages.add(new Personnage(3, new String("Billy"), new String("Warrior")));
    }

    @Override
    public List<Personnage> findAll() {

        return personnages;
    }

    @Override
    public Personnage findById(int id)
    {
        for (int i=0; i<personnages.size();i++)
        {
            Personnage persoCourant = personnages.get(i);
            if (persoCourant.getId() == id) {
                return persoCourant;
            }
        }
        return null;
    }

    @Override
    public Personnage save(Personnage personnage) {
        personnages.add(personnage);
        return personnage;
    }

    @Override
    public void delete(int id) {
        for (int i=0; i<personnages.size();i++)
        {
            Personnage persoCourant = personnages.get(i);
            if (persoCourant.getId() == id) {
                personnages.remove(id);
            }
        }
    }

    @Override
    public void modify(int id, Personnage personnage) {
        for (int i=0; i<personnages.size();i++)
        {
            Personnage persoCourant = personnages.get(i);
            if (persoCourant.getId() == id) {
                personnages.set(i, personnage);
            }
        }
    }
}
