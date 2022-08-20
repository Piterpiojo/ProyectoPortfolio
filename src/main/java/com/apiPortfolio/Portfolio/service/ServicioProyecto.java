/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apiPortfolio.Portfolio.service;

import com.apiPortfolio.Portfolio.model.Proyecto;
import com.apiPortfolio.Portfolio.repository.proyectoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioProyecto implements IservicioProyecto {

    @Autowired
    private proyectoRepositorio Repositorio;

    @Override
    public List<Proyecto> getProyecto() {
        List <Proyecto> pro = Repositorio.findAll();
        return pro;
    }

    @Override
    public void eliminarProyecto(Long id) {
        Repositorio.deleteById(id);
    }

    @Override
    public void guardarProyecto(Proyecto pro) {
        Repositorio.save(pro);
    }

    @Override
    public Proyecto buscarProyecto(Long id) {
        Proyecto pro = Repositorio.findById(id).orElse(null);
        return pro;
    }
    

}
