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
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long Id;
    
    private String nombre;
    private String Apellido;
    private String foto;
    private String descripcion;
    private String titulo;
    private String banner;
    


    


    public Persona() {
    }

    public Persona(Long id, String nombre, String Apellido, String foto, String descripcion, String banner) {
        this.Id = id;
        this.nombre = nombre;
        this.Apellido = Apellido;
        this.foto = foto;
        this.descripcion = descripcion;
        this.banner = banner;
    }
    
    
}
