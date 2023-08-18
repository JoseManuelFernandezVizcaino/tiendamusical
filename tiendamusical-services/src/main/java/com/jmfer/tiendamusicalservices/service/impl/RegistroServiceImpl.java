/**
 * 
 */
package com.jmfer.tiendamusicalservices.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmfer.tiendamusicaldata.dao.PersonaDAO;
import com.jmfer.tiendamusicalentities.entities.Persona;
import com.jmfer.tiendamusicalservices.enums.RolEnum;
import com.jmfer.tiendamusicalservices.service.RegistroService;

/**
 * @author jmfer
 * Clase que implementa los metodos de logica de negocio para el registro de usuarios en el sistema
 */
@Service
public class RegistroServiceImpl implements RegistroService {
	
	@Autowired
	private PersonaDAO personaDAO;
	/**
	 * 
	 */
	@Override
	public Persona registrarPersona(Persona persona) {
		persona.getRol().setIdRol(RolEnum.CLIENTE.getClave());
		persona.setFechaCreacion(LocalDateTime.now());
		persona.setEstatus(true);
		
		persona.getCarrito().setPersona(persona);
		return this.personaDAO.save(persona);
	}

}
