/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apiPortfolio.Portfolio.Controller;

import com.apiPortfolio.Portfolio.DTO.PorfolioDTO;
import com.apiPortfolio.Portfolio.model.Domicilio;
import com.apiPortfolio.Portfolio.model.Educacion;
import com.apiPortfolio.Portfolio.model.Experiencia_laboral;
import com.apiPortfolio.Portfolio.model.Habilidad;
import com.apiPortfolio.Portfolio.model.Persona;
import com.apiPortfolio.Portfolio.model.Proyecto;
import com.apiPortfolio.Portfolio.repository.domicilioRepository;
import com.apiPortfolio.Portfolio.repository.educacionRepositorio;
import com.apiPortfolio.Portfolio.repository.experienciaRepositorio;
import com.apiPortfolio.Portfolio.repository.habilidadRepositorio;
import com.apiPortfolio.Portfolio.repository.proyectoRepositorio;
import com.apiPortfolio.Portfolio.service.IservicePorfolio;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class controlador {
    
    @Autowired
    private IservicePorfolio inter;
    @Autowired
    private educacionRepositorio eduRepo;
    @Autowired
    private domicilioRepository domiRepo;
    @Autowired
    private experienciaRepositorio expRepo;
    @Autowired
    private habilidadRepositorio habRepo;
    @Autowired
    private proyectoRepositorio proRepo;
    
    
    
    @GetMapping ("/persona/traer")
    public List<Persona> getPersonas(){
        return inter.getPersona();
    }
    // ---------------------------------------//

    
   
    public List<Domicilio> getDomicilio(){
        List<Domicilio> listadom = domiRepo.findAll();
        return listadom;
    }
    
   
    

    public Domicilio buscarDom(@PathVariable Long id){
        for(Domicilio d:getDomicilio()){
  
            if(Objects.equals(d.getDom_id(), id)){
                return d;
            }
        }
       return null;
    }


    //--------------------------------------//
    @PostMapping ("/persona/crear")
    public String crearPersona(@RequestBody Persona persona){
        inter.savePersona(persona);
        return "exito";
    }
    
    @DeleteMapping ("/persona/eliminar/{id}")
    public String eliminarPersona(@PathVariable Long id){
        inter.deletePersona(id);
        return "eliminado con exito";
    }
    
    @PutMapping("/persona/editar/{id}")
    public Persona editarPersona(@PathVariable Long id, @RequestParam ("nombre") String nuevoNombre, @RequestParam ("Apellido") String nuevoApellido){
        Persona p = inter.findPersona(id);
        p.setApellido(nuevoApellido);
        p.setNombre(nuevoNombre);
        inter.savePersona(p);
        return p;
    }
    //-----------------------------------------------------//
    @PostMapping ("experiencia/crear")
    @ResponseBody
    public String agregarExperiencia(@RequestBody Experiencia_laboral experiencia){
        expRepo.save(experiencia);
        return "creado con exito";
    }
    
    
    @DeleteMapping("/experiencia/eliminar/{id}")
    @ResponseBody
    public String eliminarExp(@PathVariable Long id){
        expRepo.deleteById(id);
        return "exito";
    }
    
    @PutMapping("/experiencia/editar/{id}")

    public Experiencia_laboral editarExp(@PathVariable Long id, @RequestParam (name="puesto")  
            String npuesto, @RequestParam (name="desde", required =false) String ndesde, @RequestParam (name="empresa", required= false) 
            String nempresa,
            @RequestParam (name="hasta", required = false) String nhasta, @RequestParam (name="logo", required= false) String nlogo){
        
       Experiencia_laboral exp = expRepo.findById(id).orElse(null);
       exp.setEmpresa(nempresa);
       exp.setPuesto(npuesto);
       exp.setDesde(ndesde);
       exp.setHasta(nhasta);
       exp.setLogo(nlogo);
       expRepo.save(exp);
       return exp;
       
    }
    
    @GetMapping ("/persona/traer/{id}")
    public Persona buscar(@PathVariable Long id){
        for(Persona p:inter.getPersona()){
  
            if(Objects.equals(p.getId(), id)){
                return p;
            }
        }
       return null;
    }
    
    
    @GetMapping ("/persona/obtenertodo/{id}")
    @ResponseBody
    public PorfolioDTO obtenerDTO(@PathVariable Long id){
        PorfolioDTO dto = new PorfolioDTO();
        dto.setNombre(buscar(id).getNombre());
        dto.setApeliido(buscar(id).getApellido());
        dto.setDescripcion(buscar(id).getDescripcion());
        dto.setTitulo(buscar(id).getTitulo());
        dto.setBanner(buscar(id).getBanner());
        dto.setFoto(buscar(id).getFoto());
        dto.setCiudad(buscarDom(id).getCiudad());
        dto.setLedu(getEducacion(id));
        dto.setLexp(getExp(id));
        dto.setLhabl(getHabilidad(id));
        dto.setLpro(getProyecto(id));
        return dto;
    }
    
    
    
    
   public List<Experiencia_laboral> getExp(Long id){
        List<Experiencia_laboral> listaExp = expRepo.findAll();
        List<Experiencia_laboral> listaExpid = new ArrayList<Experiencia_laboral>();
        for(Experiencia_laboral e: listaExp){
       if(Objects.equals(e.getPersona_id(), id)){
           listaExpid.add(e);
       }
   }
        return listaExpid;
    }
   
    
    public List<Educacion> getEducacion(Long id){
        List<Educacion> listaEdu = eduRepo.findAll();
        List<Educacion> listaEduid = new ArrayList <Educacion>();
      for(Educacion e: listaEdu){
        if(Objects.equals(e.getPersona_id(), id)){
           listaEduid.add(e);
       }
   }
        
        return listaEduid;
    }
    
    public List<Habilidad> getHabilidad(Long id){
        List<Habilidad> listaHab = habRepo.findAll();
        List<Habilidad> listaHabid = new ArrayList <Habilidad>();
      for(Habilidad e: listaHab){
        if(Objects.equals(e.getPersona_id(), id)){
           listaHabid.add(e);
       }
   }
        
        return listaHabid;
    }
        
        
    public List<Proyecto> getProyecto(Long id){
        List<Proyecto> listaPro = proRepo.findAll();
        List<Proyecto> listaProid = new ArrayList <Proyecto>();
      for(Proyecto e: listaPro){
        if(Objects.equals(e.getPersona_id(), id)){
           listaProid.add(e);
       }
        
   }
        
        return listaProid;
    }
}
