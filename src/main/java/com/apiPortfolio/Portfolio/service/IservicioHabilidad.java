/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.apiPortfolio.Portfolio.service;


import com.apiPortfolio.Portfolio.model.Habilidad;
import java.util.List;

/**
 *
 * @author delgado
 */
public interface IservicioHabilidad {
    public List <Habilidad> getHabilidad();
    
    public void guardarHabilidad(Habilidad hab);
    
    public void eliminarHabilidad(Long id);
    
    public Habilidad buscarHabilidad(Long id);
}
