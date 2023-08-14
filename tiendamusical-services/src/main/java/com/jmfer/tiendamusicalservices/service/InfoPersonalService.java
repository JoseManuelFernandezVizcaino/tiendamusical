/**
 * 
 */
package com.jmfer.tiendamusicalservices.service;

import com.jmfer.tiendamusicalentities.entities.Persona;

/**
 * @author jmfer
 * Interface que contiene los metodos de la logica de negocio para la pantalla de informacion
 * personal
 */
public interface InfoPersonalService {
	
	/**
	 * Metodo que permite actualizar la informacion personal del usuario en sesion
	 * @param persona
	 * @return
	 */
	Persona actualizarPersona(Persona persona);
}
