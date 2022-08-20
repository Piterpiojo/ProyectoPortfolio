/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apiPortfolio.Portfolio.service;

import com.apiPortfolio.Portfolio.model.Educacion;
import com.apiPortfolio.Portfolio.repository.educacionRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioEducacion implements IservicioEducacion {
    @Autowired
    private educacionRepositorio Repositorio;
    
    
    
    @Override
    public List<Educacion> getEducacion() {
        List<Educacion> edu = Repositorio.findAll();
        return edu;
        
    }

    @Override
    public void guardarEducacion(Educacion edu) {
        Repositorio.save(edu);
    }

    @Override
    public void eliminarEducacion(Long id) {
        Repositorio.deleteById(id);
    }

    @Override
    public Educacion buscarEducacion(Long id) {
        Educacion edu = Repositorio.findById(id).orElse(null);
        return edu;
    }
    
}
