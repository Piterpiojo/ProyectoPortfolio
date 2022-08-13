/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apiPortfolio.Portfolio.model;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long edu_id;
    
    private String Institucion;
    private String Carrera;
    private String desde;
    private String hasta;
    private String Logo;
    private Long persona_id;


    public Educacion() {
    }

    public Educacion(Long id, String Institucion, String Carrera, String desde, String hasta,String Logo ) {
        this.edu_id = id;
        this.Institucion = Institucion;
        this.Carrera = Carrera;
        this.desde = desde;
        this.hasta = hasta;

        this.Logo = Logo;
        
    }
    
    
}
