/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.apiPortfolio.Portfolio.repository;

import com.apiPortfolio.Portfolio.model.Experiencia_laboral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface experienciaRepositorio extends JpaRepository <Experiencia_laboral, Long> {
    
}
