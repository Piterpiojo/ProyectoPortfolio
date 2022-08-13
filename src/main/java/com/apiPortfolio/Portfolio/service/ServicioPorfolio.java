/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apiPortfolio.Portfolio.service;

import com.apiPortfolio.Portfolio.model.Persona;
import com.apiPortfolio.Portfolio.repository.repositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioPorfolio implements IservicePorfolio {

    @Autowired
    private repositorio repo;

    @Override
    public List<Persona> getPersona(){
        List<Persona> listaPersonas = repo.findAll();
        return listaPersonas;
    }
    
    @Override
    public void savePersona(Persona perso){
        repo.save(perso);
    }
    
    @Override
    public void deletePersona(Long id){
        repo.deleteById(id);
    }
    
    @Override
    public Persona findPersona(Long id){
        Persona perso= repo.findById(id).orElse(null);
        return perso;
    }
    

    
}
