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
public class Experiencia_laboral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long exp_id;
    
    private String empresa;
    private String puesto;
    private String desde;
    private String hasta;
    private String Logo;

    private Long persona_id;

    public Experiencia_laboral() {
    }

    public Experiencia_laboral(Long id, String empresa, String puesto, String desde, String hasta,String Logo,Long persona_id) {
        this.exp_id = id;
        this.empresa = empresa;
        this.puesto = puesto;
        this.desde = desde;
        this.hasta = hasta;
        this.Logo = Logo;
        this.persona_id=persona_id;
    }
    
    
}

