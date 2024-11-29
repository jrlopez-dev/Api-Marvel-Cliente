/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.marvel.client.reposirtory;

import com.marvel.client.modelo.entity.Personajeserie;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author jrlope
 */
public interface PersonajeSerieRepository extends JpaRepository<Personajeserie, Integer>{
     @Query("SELECT c FROM Personajeserie c WHERE c.idpersonaje = ?1")
     public List<Personajeserie> listSerie(Integer idpersona);
    
}
