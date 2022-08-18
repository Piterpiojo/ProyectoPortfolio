/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.apiPortfolio.Portfolio.Security.Repository;

import com.apiPortfolio.Portfolio.Security.Entity.Rol;
import com.apiPortfolio.Portfolio.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author delgado
 */
@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{

    /**
     *
     * @param rolNombre
     * @return
     */
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
