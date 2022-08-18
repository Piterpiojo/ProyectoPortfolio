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

import com.apiPortfolio.Portfolio.service.ServicioPorfolio;
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

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class controlador {
    
    @Autowired
    private ServicioPorfolio inter;
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
    public Persona editarPersona(@PathVariable Long id,@RequestBody Persona perso){
        Persona persEdit = inter.findPersona(id);
       if(perso.getNombre() != ""){
         persEdit.setNombre(perso.getNombre());
        }
       if(perso.getApellido() != ""){
         persEdit.setApellido(perso.getApellido());
        }
        
       if(perso.getDescripcion() != ""){
        persEdit.setDescripcion(perso.getDescripcion());
       }
       if(perso.getFoto() != ""){
        persEdit.setFoto(perso.getFoto());
       }
       if(perso.getBanner() != ""){
        persEdit.setBanner(perso.getBanner());
       }
       if(perso.getTitulo() != ""){
           persEdit.setTitulo(perso.getTitulo());
       }
       inter.savePersona(persEdit);
       return persEdit;
    }
    //-----------------------------------------------------//
    @PostMapping ("educacion/crear")
    public void agregarEducacion(@RequestBody Educacion educacion){
        eduRepo.save(educacion);
    }
    
    @DeleteMapping ("educacion/eliminar/{id}")
    public void eliminarEducacion(@PathVariable Long id){
        eduRepo.deleteById(id);
    }
    
    @PutMapping ("educacion/editar/{id}")
    
    public Educacion educa (@PathVariable Long id, @RequestBody Educacion edu){
        Educacion eduEdit = eduRepo.findById(id).orElse(null);
        
        if(edu.getCarrera() != ""){
            eduEdit.setCarrera(edu.getCarrera());
        }
        if(edu.getInstitucion() != ""){
            eduEdit.setInstitucion(edu.getInstitucion());
        }
        
        if(edu.getDesde() != ""){
        eduEdit.setDesde(edu.getDesde());
       }
       if(edu.getHasta() != ""){
        eduEdit.setHasta(edu.getHasta());
       }
       if(edu.getLogo() != ""){
        eduEdit.setLogo(edu.getLogo());
       }
       
       eduRepo.save(eduEdit);
       return eduEdit;
    }
    
    //--------------------------------------------------------------------------
    @PostMapping ("experiencia/crear")

    public String agregarExperiencia(@RequestBody Experiencia_laboral experiencia){
        expRepo.save(experiencia);
        return "creado con exito";
    }
    
    
    @DeleteMapping("/experiencia/eliminar/{id}")
    public String eliminarExp(@PathVariable Long id){
        expRepo.deleteById(id);
        return "exito";
    }
    
    @PutMapping("/experiencia/editar/{id}")

    public Experiencia_laboral editarExp(@PathVariable Long id,
            @RequestBody Experiencia_laboral exp)
    {
       Experiencia_laboral expEdit = expRepo.findById(id).orElse(null);
       
       if(exp.getEmpresa() != ""){
        expEdit.setEmpresa(exp.getEmpresa());
       }
       if(exp.getPuesto() != ""){
        expEdit.setPuesto(exp.getPuesto());
       }
       if(exp.getDesde() != ""){
        expEdit.setDesde(exp.getDesde());
       }
       if(exp.getHasta() != ""){
        expEdit.setHasta(exp.getHasta());
       }
       if(exp.getLogo() != ""){
        expEdit.setLogo(exp.getLogo());
       }
       expRepo.save(expEdit);
       return exp;
    }
    
    //--------------------------------------------------------------------------
    @PostMapping("/habilidad/crear")
    public void crearHab(@RequestBody Habilidad hab)
    {
        habRepo.save(hab);
    }
    
    @DeleteMapping("/habilidad/eliminar/{id}")
    public void eliminarHab(@PathVariable Long id)
    {
        habRepo.deleteById(id);
    }
    
    @PutMapping("/habilidad/editar/{id}")
    public Habilidad editarHab(@PathVariable Long id,@RequestBody Habilidad hab)
    {
        Habilidad habEdit = habRepo.findById(id).orElse(null);
       if(hab.getNombre() != ""){
        habEdit.setNombre(hab.getNombre());
       }
       
       if(hab.getValor()>= 1){
        habEdit.setValor(hab.getValor());
       }
       habRepo.save(habEdit);
        
       return habEdit; 
    }
    

    
    //--------------------------------------------------------------------------
    @PostMapping ("/proyecto/crear")
    public void crearPro(@RequestBody Proyecto pro)
    {
        proRepo.save(pro);
    }
    
    @DeleteMapping ("/proyecto/eliminar/{id}")
    public void eliminarPro(@PathVariable Long id)
    {
        proRepo.deleteById(id);
    }
    
    @PutMapping ("/proyecto/editar/{id}")
    public Proyecto editarPro (@PathVariable Long id, @RequestBody Proyecto pro)
    {
        Proyecto proEdit = proRepo.findById(id).orElse(null);
       if(pro.getTitulo() != ""){
        proEdit.setTitulo(pro.getTitulo());
       }
       if(pro.getDescripcion() != ""){
        proEdit.setDescripcion(pro.getDescripcion());
       }
       if(pro.getImg() != ""){
        proEdit.setImg(pro.getImg());
       }
       if(pro.getLink() != ""){
        proEdit.setLink(pro.getLink());
       }

       proRepo.save(proEdit);
        
        return proEdit;
    }
    
    
    
    //--------------------------------------------------------------------------
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
        dto.setPersona_id(buscar(id).getId());
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
