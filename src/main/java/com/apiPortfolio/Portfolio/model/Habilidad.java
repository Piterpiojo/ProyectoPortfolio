/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apiPortfolio.Portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Getter @Setter
@Entity
public class Habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long hab_id;
    
    private String nombre;
    private int valor;
    private Long persona_id;


    public Habilidad() {
    }

    public Habilidad(Long id, String nombre, int valor) {
        this.hab_id = id;
        this.nombre = nombre;
        this.valor = valor;

    }
    
}
