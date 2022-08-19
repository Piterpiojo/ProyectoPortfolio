/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.apiPortfolio.Portfolio.service;

import com.apiPortfolio.Portfolio.model.Experiencia_laboral;
import java.util.List;

/**
 *
 * @author delgado
 */
public interface IservicioExperiencia {
    public List <Experiencia_laboral> getExperiencia();
            
    public void eliminarExperiencia(Long id);
    
    public void GuardarExperiencia(Experiencia_laboral exp);
    
    public Experiencia_laboral buscarExperiencia(Long id);
}
