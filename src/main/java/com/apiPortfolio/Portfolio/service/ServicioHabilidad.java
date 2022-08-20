/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apiPortfolio.Portfolio.service;

import com.apiPortfolio.Portfolio.model.Habilidad;
import com.apiPortfolio.Portfolio.repository.habilidadRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioHabilidad implements IservicioHabilidad {
    
    @Autowired
    private habilidadRepositorio repositorio;
    
    @Override
    public List<Habilidad> getHabilidad() {
        List <Habilidad> hab = repositorio.findAll();
        return hab;
    }

    @Override
    public void guardarHabilidad(Habilidad hab) {
        repositorio.save(hab);

    }

    @Override
    public void eliminarHabilidad(Long id) {
        repositorio.deleteById(id);
    }

    @Override
    public Habilidad buscarHabilidad(Long id) {
        Habilidad hab = repositorio.findById(id).orElse(null);
        return hab;
    }
    
}
