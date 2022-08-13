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
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long dom_id;
    
        @OneToOne
    @JoinColumn(name="Id")
    Persona persona;
    
        
    private String ciudad;
 

    public Domicilio() {
    }

    public Domicilio(Long id, String ciudad) {
        this.dom_id = id;
        this.ciudad = ciudad;

    }
    
    
}
