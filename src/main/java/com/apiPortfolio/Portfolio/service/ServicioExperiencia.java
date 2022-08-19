/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apiPortfolio.Portfolio.service;

import com.apiPortfolio.Portfolio.model.Experiencia_laboral;
import com.apiPortfolio.Portfolio.repository.experienciaRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author delgado
 */
public class ServicioExperiencia implements IservicioExperiencia {

    @Autowired
    private experienciaRepositorio repositorioExperiencia;

    @Override
    public List<Experiencia_laboral> getExperiencia() {
        List<Experiencia_laboral> exps = repositorioExperiencia.findAll();
        return exps;
    }

    @Override
    public void eliminarExperiencia(Long id) {
        repositorioExperiencia.deleteById(id);
    }

    @Override
    public void GuardarExperiencia(Experiencia_laboral exp) {
        repositorioExperiencia.save(exp);
    }

    @Override
    public Experiencia_laboral buscarExperiencia(Long id) {
      Experiencia_laboral exp = repositorioExperiencia.findById(id).orElse(null);
      return exp;
    }

}
