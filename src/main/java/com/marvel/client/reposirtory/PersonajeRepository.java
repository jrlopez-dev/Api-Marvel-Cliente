/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.marvel.client.reposirtory;

import com.marvel.client.modelo.entity.Personajes;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jrlopez
 */
public interface PersonajeRepository extends JpaRepository<Personajes, Integer>{
    
}
