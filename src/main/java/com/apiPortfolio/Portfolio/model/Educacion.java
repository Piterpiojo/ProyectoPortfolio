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

@Getter
@Setter
@Entity
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long edu_id;

    private String institucion;
    private String carrera;
    private String desde;
    private String hasta;
    private String logo;
    private Long persona_id;

    public Educacion() {
    }

    public Educacion(Long id, String Institucion, String Carrera, String desde, String hasta, String Logo) {
        this.edu_id = id;
        this.institucion = Institucion;
        this.carrera = Carrera;
        this.desde = desde;
        this.hasta = hasta;
        this.logo = Logo;

    }

}
