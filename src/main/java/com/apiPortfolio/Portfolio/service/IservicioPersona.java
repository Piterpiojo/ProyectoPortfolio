
package com.apiPortfolio.Portfolio.service;

import com.apiPortfolio.Portfolio.model.Persona;
import java.util.List;

/**
 *
 * @author delgado
 */
public interface IservicioPersona {
    public List <Persona> getPersona();
    
    public void savePersona(Persona persona);
    
    public void deletePersona(Long id);
    
    public Persona findPersona(Long id);
    
}
