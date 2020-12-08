package com.example.demo.dao;


import com.example.demo.model.Personnage;

import java.util.List;

public interface PersonnageDao {
    public List<Personnage>findAll();
    public Personnage findById(int id);
    public Personnage save(Personnage personnage);
    public void delete(int id);
    public void modify(int id, Personnage personnage);
}
