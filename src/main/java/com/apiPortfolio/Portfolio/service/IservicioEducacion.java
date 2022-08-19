/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.apiPortfolio.Portfolio.service;

import com.apiPortfolio.Portfolio.model.Educacion;
import java.util.List;


public interface IservicioEducacion {
    public List <Educacion> getEducacion();
    
    public void guardarEducacion(Educacion edu);
    
    public void eliminarEducacion(Long id);
    
    public Educacion buscarEducacion(Long id);
    
}
