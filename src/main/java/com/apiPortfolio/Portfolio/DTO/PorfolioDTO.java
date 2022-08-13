/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apiPortfolio.Portfolio.DTO;

import com.apiPortfolio.Portfolio.model.Educacion;
import com.apiPortfolio.Portfolio.model.Experiencia_laboral;
import com.apiPortfolio.Portfolio.model.Habilidad;
import com.apiPortfolio.Portfolio.model.Proyecto;

import java.util.List;

public class PorfolioDTO {
    private String nombre;
    private String apeliido;
    private String foto;
    private String descripcion;
    private String titulo;
    private String ciudad;
    private String banner;
    private List <Educacion> ledu ;
    private List <Experiencia_laboral> lexp ;
    private List <Habilidad> lhabl ;
    private List <Proyecto> lpro ;

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }
    


    public PorfolioDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApeliido() {
        return apeliido;
    }

    public void setApeliido(String apeliido) {
        this.apeliido = apeliido;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<Educacion> getLedu() {
        return ledu;
    }

    public void setLedu(List<Educacion> ledu) {
        this.ledu = ledu;
    }

    public List<Experiencia_laboral> getLexp() {
        return lexp;
    }

    public void setLexp(List<Experiencia_laboral> lexp) {
        this.lexp = lexp;
    }

    public List<Habilidad> getLhabl() {
        return lhabl;
    }

    public void setLhabl(List<Habilidad> lhabl) {
        this.lhabl = lhabl;
    }

    public List<Proyecto> getLpro() {
        return lpro;
    }

    public void setLpro(List<Proyecto> lpro) {
        this.lpro = lpro;
    }

    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
        
    
}
