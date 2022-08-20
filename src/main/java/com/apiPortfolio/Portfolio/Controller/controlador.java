/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apiPortfolio.Portfolio.Controller;

import com.apiPortfolio.Portfolio.DTO.PorfolioDTO;

import com.apiPortfolio.Portfolio.model.Educacion;
import com.apiPortfolio.Portfolio.model.Experiencia_laboral;
import com.apiPortfolio.Portfolio.model.Habilidad;
import com.apiPortfolio.Portfolio.model.Persona;
import com.apiPortfolio.Portfolio.model.Proyecto;
import com.apiPortfolio.Portfolio.service.ServicioEducacion;
import com.apiPortfolio.Portfolio.service.ServicioExperiencia;
import com.apiPortfolio.Portfolio.service.ServicioHabilidad;
import com.apiPortfolio.Portfolio.service.ServicioPorfolio;
import com.apiPortfolio.Portfolio.service.ServicioProyecto;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://portfolio-angular-c8e59.firebaseapp.com/")
public class controlador {

    @Autowired
    private ServicioPorfolio servicioPersonas;
    
    @Autowired
    private ServicioEducacion servicioEducacion;
    
    @Autowired
    private ServicioExperiencia servicioExperiencia;
    
    @Autowired
    private ServicioHabilidad servicioHabilidad;
    
    @Autowired
    private ServicioProyecto servicioProyecto;
   
    //------------------Persona--------------------//
   
    @GetMapping("/persona/traer")
    public List<Persona> getPersonas() {
        return servicioPersonas.getPersona();
    }

    @PostMapping("/persona/crear")
    public String crearPersona(@RequestBody Persona persona) {
        if(servicioPersonas.existeEmail(persona)){
            return "ese correo ya esta registrado";
        }else{
                    servicioPersonas.savePersona(persona);
        return "exito";
        }

    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/persona/eliminar/{id}")
    public String eliminarPersona(@PathVariable Long id) {
        servicioPersonas.deletePersona(id);
        return "eliminado con exito";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/persona/editar/{id}")
    public Persona editarPersona(@PathVariable Long id, @RequestBody Persona perso) {
        Persona persEdit = servicioPersonas.findPersona(id);
        if (perso.getNombre() != "") {
            persEdit.setNombre(perso.getNombre());
        }
        if (perso.getApellido() != "") {
            persEdit.setApellido(perso.getApellido());
        }

        if (perso.getDescripcion() != "") {
            persEdit.setDescripcion(perso.getDescripcion());
        }
        if (perso.getFoto() != "") {
            persEdit.setFoto(perso.getFoto());
        }
        if (perso.getBanner() != "") {
            persEdit.setBanner(perso.getBanner());
        }
        if (perso.getTitulo() != "") {
            persEdit.setTitulo(perso.getTitulo());
        }
        servicioPersonas.savePersona(persEdit);
        return persEdit;
    }

    //---------------------Educacion--------------------------------//
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("educacion/crear")
    public void agregarEducacion(@RequestBody Educacion educacion) {
        servicioEducacion.guardarEducacion(educacion);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("educacion/eliminar/{id}")
    public void eliminarEducacion(@PathVariable Long id) {
        servicioEducacion.eliminarEducacion(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("educacion/editar/{id}")
    public Educacion educa(@PathVariable Long id, @RequestBody Educacion edu) {
        Educacion eduEdit = servicioEducacion.buscarEducacion(id);

        if (edu.getCarrera() != "") {
            eduEdit.setCarrera(edu.getCarrera());
        }
        if (edu.getInstitucion() != "") {
            eduEdit.setInstitucion(edu.getInstitucion());
        }

        if (edu.getDesde() != "") {
            eduEdit.setDesde(edu.getDesde());
        }
        if (edu.getHasta() != "") {
            eduEdit.setHasta(edu.getHasta());
        }
        if (edu.getLogo() != "") {
            eduEdit.setLogo(edu.getLogo());
        }

        servicioEducacion.guardarEducacion(eduEdit);
        return eduEdit;
    }

    //---------------------------Experiencia-----------------------------------//
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("experiencia/crear")
    public String agregarExperiencia(@RequestBody Experiencia_laboral experiencia) {
        servicioExperiencia.GuardarExperiencia(experiencia);
        return "creado con exito";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/experiencia/eliminar/{id}")
    public String eliminarExp(@PathVariable Long id) {
        servicioExperiencia.eliminarExperiencia(id);
        return "exito";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/experiencia/editar/{id}")
    public Experiencia_laboral editarExp(@PathVariable Long id,
            @RequestBody Experiencia_laboral exp) {
        Experiencia_laboral expEdit = servicioExperiencia.buscarExperiencia(id);

        if (exp.getEmpresa() != "") {
            expEdit.setEmpresa(exp.getEmpresa());
        }
        if (exp.getPuesto() != "") {
            expEdit.setPuesto(exp.getPuesto());
        }
        if (exp.getDesde() != "") {
            expEdit.setDesde(exp.getDesde());
        }
        if (exp.getHasta() != "") {
            expEdit.setHasta(exp.getHasta());
        }
        if (exp.getLogo() != "") {
            expEdit.setLogo(exp.getLogo());
        }
        servicioExperiencia.GuardarExperiencia(expEdit);
        return exp;
    }

    //---------------------------Habilidades-----------------------------------
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/habilidad/crear")
    public void crearHab(@RequestBody Habilidad hab) {
        servicioHabilidad.guardarHabilidad(hab);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/habilidad/eliminar/{id}")
    public void eliminarHab(@PathVariable Long id) {
        servicioHabilidad.eliminarHabilidad(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/habilidad/editar/{id}")
    public Habilidad editarHab(@PathVariable Long id, @RequestBody Habilidad hab) {
        Habilidad habEdit = servicioHabilidad.buscarHabilidad(id);
        if (hab.getNombre() != "") {
            habEdit.setNombre(hab.getNombre());
        }

        if (hab.getValor() >= 1) {
            habEdit.setValor(hab.getValor());
        }
        servicioHabilidad.guardarHabilidad(habEdit);

        return habEdit;
    }

    //-------------------------------Proyectos---------------------------------
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/proyecto/crear")
    public void crearPro(@RequestBody Proyecto pro) {
        servicioProyecto.guardarProyecto(pro);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/proyecto/eliminar/{id}")
    public void eliminarPro(@PathVariable Long id) {
        servicioProyecto.eliminarProyecto(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/proyecto/editar/{id}")
    public Proyecto editarPro(@PathVariable Long id, @RequestBody Proyecto pro) {
        Proyecto proEdit = servicioProyecto.buscarProyecto(id);
        if (pro.getTitulo() != "") {
            proEdit.setTitulo(pro.getTitulo());
        }
        if (pro.getDescripcion() != "") {
            proEdit.setDescripcion(pro.getDescripcion());
        }
        if (pro.getImg() != "") {
            proEdit.setImg(pro.getImg());
        }
        if (pro.getLink() != "") {
            proEdit.setLink(pro.getLink());
        }

        servicioProyecto.guardarProyecto(proEdit);

        return proEdit;
    }

    //----------------------------DTO Completo---------------------------------
    @GetMapping("/persona/obtenertodo/{email}")
    @ResponseBody
    public PorfolioDTO obtenerDTO(@PathVariable String email) {
        Long id = buscarIDporEmail(email);
        PorfolioDTO dto = new PorfolioDTO();
        dto.setPersona_id(buscarPersona(id).getId());
        dto.setNombre(buscarPersona(id).getNombre());
        dto.setApeliido(buscarPersona(id).getApellido());
        dto.setDescripcion(buscarPersona(id).getDescripcion());
        dto.setTitulo(buscarPersona(id).getTitulo());
        dto.setBanner(buscarPersona(id).getBanner());
        dto.setFoto(buscarPersona(id).getFoto());
        dto.setLedu(getEducacion(id));
        dto.setLexp(getExp(id));
        dto.setLhabl(getHabilidad(id));
        dto.setLpro(getProyecto(id));
        return dto;
    }

    //-------------------------------Metodos Soporte----------------------------
    public List<Experiencia_laboral> getExp(Long id) {
        List<Experiencia_laboral> listaExp = servicioExperiencia.getExperiencia();
        List<Experiencia_laboral> listaExpid = new ArrayList<Experiencia_laboral>();
        for (Experiencia_laboral e : listaExp) {
            if (Objects.equals(e.getPersona_id(), id)) {
                listaExpid.add(e);
            }
        }
        return listaExpid;
    }

    public List<Educacion> getEducacion(Long id) {
        List<Educacion> listaEdu = servicioEducacion.getEducacion();
        List<Educacion> listaEduid = new ArrayList<Educacion>();
        for (Educacion e : listaEdu) {
            if (Objects.equals(e.getPersona_id(), id)) {
                listaEduid.add(e);
            }
        }

        return listaEduid;
    }

    public List<Habilidad> getHabilidad(Long id) {
        List<Habilidad> listaHab = servicioHabilidad.getHabilidad();
        List<Habilidad> listaHabid = new ArrayList<Habilidad>();
        for (Habilidad e : listaHab) {
            if (Objects.equals(e.getPersona_id(), id)) {
                listaHabid.add(e);
            }
        }

        return listaHabid;
    }

    public List<Proyecto> getProyecto(Long id) {
        List<Proyecto> listaPro = servicioProyecto.getProyecto();
        List<Proyecto> listaProid = new ArrayList<Proyecto>();
        for (Proyecto e : listaPro) {
            if (Objects.equals(e.getPersona_id(), id)) {
                listaProid.add(e);
            }

        }

        return listaProid;
    }

    public Long buscarIDporEmail(String email) {
        for (Persona p : servicioPersonas.getPersona()) {

            if (Objects.equals(p.getEmail(), email)) {
                return p.getId();
            }
        }
        return null;
    }

    public Persona buscarPersona(@PathVariable Long id) {
        for (Persona p : servicioPersonas.getPersona()) {

            if (Objects.equals(p.getId(), id)) {
                return p;
            }
        }
        return null;
    }

}
