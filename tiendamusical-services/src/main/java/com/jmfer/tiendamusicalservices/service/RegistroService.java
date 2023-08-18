/**
 * 
 */
package com.jmfer.tiendamusicalservices.service;

import com.jmfer.tiendamusicalentities.entities.Persona;

/**
 * @author jmfer
 * Interface que contiene los metodos de logica de negocio para el registro de usuarios en tienda musical
 */
public interface RegistroService {
	
	/**
	 * Metodo que permite registrar a una persona en el sistema
	 * @param persona
	 * @return
	 */
	Persona registrarPersona(Persona persona);
}
