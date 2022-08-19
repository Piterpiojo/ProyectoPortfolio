/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apiPortfolio.Portfolio.service;

import com.apiPortfolio.Portfolio.model.Educacion;
import com.apiPortfolio.Portfolio.repository.educacionRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author delgado
 */
public class ServicioEducacion implements IservicioEducacion {
    @Autowired
    private educacionRepositorio repositorioEducacion;
    
    
    
    @Override
    public List<Educacion> getEducacion() {
        List<Educacion> edu = repositorioEducacion.findAll();
        return edu;
        
    }

    @Override
    public void guardarEducacion(Educacion edu) {
        repositorioEducacion.save(edu);
    }

    @Override
    public void eliminarEducacion(Long id) {
        repositorioEducacion.deleteById(id);
    }

    @Override
    public Educacion buscarEducacion(Long id) {
        Educacion edu = repositorioEducacion.findById(id).orElse(null);
        return edu;
    }
    
}
