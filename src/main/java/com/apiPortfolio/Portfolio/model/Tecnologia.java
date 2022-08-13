/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apiPortfolio.Portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Tecnologia {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long tec_id;
    
    private String nombre;

            
    @ManyToOne
    @JoinColumn(name="Id")
    Persona persona;

    public Tecnologia() {
    }

    public Tecnologia(Long id, String nombre) {
        this.tec_id = id;
        this.nombre = nombre;
       
    }
    
}
