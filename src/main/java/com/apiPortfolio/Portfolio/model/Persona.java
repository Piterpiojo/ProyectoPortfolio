
package com.apiPortfolio.Portfolio.model;

import com.sun.istack.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    
    private String nombre;
    private String apellido;
    private String foto;
    private String descripcion;
    private String titulo;
    private String banner;
    @NotNull
    @Column(unique = true)
    private String email;

    


    


    public Persona() {
    }

    public Persona(String nombre, String Apellido, String foto, String descripcion, String titulo, String banner) {
        this.nombre = nombre;
        this.apellido = Apellido;
        this.foto = foto;
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.banner = banner;
    }

    
    
    
}
