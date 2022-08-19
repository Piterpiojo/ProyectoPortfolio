/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.apiPortfolio.Portfolio.service;

import com.apiPortfolio.Portfolio.model.Proyecto;
import java.util.List;


public interface IservicioProyecto {
    public List<Proyecto> getProyecto();
    
    public void eliminarProyecto(Long id);
    
    public void guardarProyecto(Proyecto pro);
    
    public Proyecto buscarProyecto(Long id);
}
