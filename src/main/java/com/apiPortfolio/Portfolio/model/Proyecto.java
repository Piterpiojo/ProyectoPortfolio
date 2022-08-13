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
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long pro_id;
    
    private String titulo;
    private String descripcion;
    private String link;
    private String img;
    private Long persona_id;
 
    public Proyecto(Long id, String titulo, String descripcion, String link, String img) {
        this.pro_id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.link = link;
        this.img = img;
  
    }

    public Proyecto() {
    }
    
    
}
